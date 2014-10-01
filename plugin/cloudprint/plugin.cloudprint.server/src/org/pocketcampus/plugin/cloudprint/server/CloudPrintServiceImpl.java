package org.pocketcampus.plugin.cloudprint.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.pocketcampus.platform.server.RawPlugin;
import org.pocketcampus.platform.server.launcher.PocketCampusServer;
import org.pocketcampus.plugin.authentication.server.AuthenticationServiceImpl;
import org.pocketcampus.plugin.cloudprint.shared.CloudPrintColorConfig;
import org.pocketcampus.plugin.cloudprint.shared.CloudPrintMultiPageLayout;
import org.pocketcampus.plugin.cloudprint.shared.CloudPrintService;
import org.pocketcampus.plugin.cloudprint.shared.CloudPrintStatusCode;
import org.pocketcampus.plugin.cloudprint.shared.PrintDocumentRequest;
import org.pocketcampus.plugin.cloudprint.shared.PrintDocumentResponse;

import com.google.gson.Gson;

/**
 * CloudPrintServiceImpl
 * 
 * The implementation of the server side of the CloudPrint Plugin.
 * It print on EPFL's pool
 * 
 * @author Amer <amer.chamseddine@epfl.ch>
 *
 */
public class CloudPrintServiceImpl implements CloudPrintService.Iface, RawPlugin {
	
	public CloudPrintServiceImpl() {
		System.out.println("Starting CloudPrint plugin server ...");
	}


	@Override
	public HttpServlet getServlet() {
		return new HttpServlet() {
			private static final long serialVersionUID = -6760157045775850293L;
			@Override
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String gaspar = AuthenticationServiceImpl.authGetUserGasparFromReq(request);
				if (gaspar == null) {
					response.setStatus(HttpURLConnection.HTTP_PROXY_AUTH);
					return;
				}
				long id = System.currentTimeMillis();
				String filePath = PocketCampusServer.CONFIG.getString("CLOUDPRINT_DUMP_DIRECTORY") + "/" + gaspar + "_" + id;
			    new File(filePath).mkdirs();
				//String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
			    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
				if (filePart == null) {
					response.setStatus(HttpURLConnection.HTTP_BAD_REQUEST);
					return;
				}
			    String filename = getFilenameFromContentDisposition(filePart.getHeader("content-disposition"));
			    InputStream filecontent = filePart.getInputStream();
			    FileOutputStream fos = new FileOutputStream(filePath + "/" + filename);
			    IOUtils.copy(filecontent, fos);
			    fos.close();

			    // Will be used for print-preview functionality 
				//String cupsPdfOutDir = PocketCampusServer.CONFIG.getString("CLOUDPRINT_CUPSPDF_OUTDIR");
			    
			    response.setContentType("application/json");
			    response.getOutputStream().write(new Gson().toJson(new CloudPrintUploadResponse(id)).getBytes());
			}
		};
	}
	
	public static class CloudPrintUploadResponse {
		public long file_id;
		public CloudPrintUploadResponse(long file_id){
			this.file_id = file_id;
		}
	}

	@Override
	public PrintDocumentResponse printDocument(PrintDocumentRequest request) throws TException {
		String gaspar = AuthenticationServiceImpl.authGetUserGaspar();
		if (gaspar == null) {
			return new PrintDocumentResponse(CloudPrintStatusCode.AUTHENTICATION_ERROR);
		}
		String filePath = PocketCampusServer.CONFIG.getString("CLOUDPRINT_DUMP_DIRECTORY") + "/" + gaspar + "_" + request.getDocumentId();
		String [] files = new File(filePath).list();
		if(files == null || files.length == 0) {
			return new PrintDocumentResponse(CloudPrintStatusCode.PRINT_ERROR);	    	
	    }
		try {
			String[] command = buildLprCommand("mainPrinter", gaspar, files[0], filePath + "/" + files[0], request);
			System.out.println("$ " + StringUtils.join(command, " "));
			Runtime.getRuntime().exec(command);
			command = buildLprCommand("Cups-PDF", null, gaspar + "_" + request.getDocumentId(), filePath + "/" + files[0], request);
			System.out.println("$ " + StringUtils.join(command, " "));
			Runtime.getRuntime().exec(command);
			return new PrintDocumentResponse(CloudPrintStatusCode.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new PrintDocumentResponse(CloudPrintStatusCode.PRINT_ERROR);
		}
	}
	
	private static String[] buildLprCommand(String printer, String gaspar, String jobTitle, String filePath, PrintDocumentRequest request) {
		List<String> command = new LinkedList<String>();
		command.add("lpr");
		command.add("-P");command.add(printer);
		if(gaspar != null) {
			command.add("-U");command.add(gaspar);
		}
		//command.add("-r"); // delete file afterward
		command.add("-o");command.add("fitplot");
		if(request.isSetPageSelection()) {
			command.add("-o");command.add("page-ranges=" + request.getPageSelection().getPageFrom() + "-" + request.getPageSelection().getPageTo());
		}

		if(request.isSetDoubleSided()) {
			switch (request.getDoubleSided()) {
			case LONG_EDGE:
				command.add("-o");command.add("sides=two-sided-long-edge");			
				break;
			case SHORT_EDGE:
				command.add("-o");command.add("sides=two-sided-short-edge");			
				break;
			}
		}
		if(request.isSetMultiPageConfig()) {
			int nup = request.getMultiPageConfig().getNbPagesPerSheet().getValue();
			String layout = decodeLayout(request.getMultiPageConfig().getLayout());
			command.add("-o");command.add("number-up=" + nup);
			command.add("-o");command.add("number-up-layout=" + layout);
		}
		if(request.isSetOrientation()) {
			switch (request.getOrientation()) {
			case PORTRAIT:
			case REVERSE_PORTRAIT:
				command.add("-o");command.add("media=Custom.8.27x11.69in");
				break;
			case LANDSCAPE:
			case REVERSE_LANDSCAPE:
				command.add("-o");command.add("media=Custom.11.69x8.27in");
				break;
			}
		}
		if(request.isSetMultipleCopies()) {
			command.add("-#" + request.getMultipleCopies().getNumberOfCopies());
			if(request.getMultipleCopies().isCollate()) {
				command.add("-o");command.add("Collate=True");
			}
		}
		if(request.isSetColorConfig()) {
			if(request.getColorConfig() == CloudPrintColorConfig.BLACK_WHITE) {
				command.add("-o");command.add("JCLColorCorrection=BlackWhite");
			}
		}
		command.add("-T");command.add(jobTitle);
		command.add(filePath);
		return command.toArray(new String[command.size()]);
	}
	
	/** 
		convert 
			LEFT_TO_RIGHT_TOP_TO_BOTTOM
			TOP_TO_BOTTOM_LEFT_TO_RIGHT
			BOTTOM_TO_TOP_LEFT_TO_RIGHT
			BOTTOM_TO_TOP_RIGHT_TO_LEFT
			LEFT_TO_RIGHT_BOTTOM_TO_TOP
			RIGHT_TO_LEFT_BOTTOM_TO_TOP
			RIGHT_TO_LEFT_TOP_TO_BOTTOM
			TOP_TO_BOTTOM_RIGHT_TO_LEFT
		to
			lrtb
			tblr
			btlr
			btrl
			lrbt
			rlbt
			rltb
			tbrl
	 */
	private static String decodeLayout(CloudPrintMultiPageLayout layout) {
		return layout.name().toLowerCase(Locale.US).replace("to_", "").replaceAll("([a-z])[a-z]+_([a-z])[a-z]+_([a-z])[a-z]+_([a-z])[a-z]+", "$1$2$3$4");
	}

	public static String getFilenameFromContentDisposition(String contentDisposition) {
	    for (String cd : contentDisposition.split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
}
