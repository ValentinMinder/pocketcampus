package org.pocketcampus.core.router;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pocketcampus.core.debug.Reporter;
import org.pocketcampus.core.exception.ServerException;

import com.google.gson.Gson;

public class MainRouter extends HttpServlet {
	
	private static final long serialVersionUID = 2912684020711306666L;
	
	// List of available methods for the plugin
	private static HashMap<String, HashMap<String, Method>> methods_;
	private static HashMap<String, IServerBase> classes_;
	
	// Gson instance to serialize resulting objects
	private static Gson gson_;
	
	private static Reporter reporter_;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		methods_ = new HashMap<String, HashMap<String, Method>>();
		classes_ = new HashMap<String, IServerBase>();
		gson_ = new Gson();
		reporter_ = new Reporter();
	}

	/**
	 * Handle the GET request
	 * Final because the children do not have to handle the request by themselves
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// URL used to access the servlet
		String path = request.getPathInfo();

		// Request without any command
		if(path.equals("/")) {
			reporter_.statusReport(response, classes_, methods_);
			return;
		}
		
		// Get the object and the method connected to the command
		try {
			IServerBase obj = getObject(path);
			Method m = getMethod(obj, path);
			invoke(request, response, obj, m);
			
		} catch (ServerException e) {
			reporter_.errorReport(response, e);
		}
		
	}
	
	private IServerBase getObject(String path) throws ServerException {
		String className = getClassNameFromPath(path);
		IServerBase obj = initClass(className);
		
		if(obj == null) {
			throw new ServerException("Object initialization failed.");
		}
		
		return obj;
	}
	
	private String getClassNameFromPath(String path) {
		String split[] = path.split("/");
		
		if(split.length > 1) {
			return "org.pocketcampus.plugin." + split[1];
		}
		
		return null;
	}

	private void invoke(HttpServletRequest request, HttpServletResponse response, IServerBase obj, Method m) throws IOException {
		// Create the arguments to pass to the method
		Object arglist[] = new Object[1];
		arglist[0] = request;

		try {

			// Invoke the method
			Object ret = m.invoke(obj, arglist);
			
			String json = gson_.toJson(ret);
			
			// Put the method content into the response
			response.getOutputStream().println(json);
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * Get the name of the method that has to be invoked using the URL
	 * @param path path from the request
	 * @return the name of the request if exist, or the name of the default method
	 */
	private String getMethodNameFromPath(String path) {
		
		String split[] = path.split("/");
		
		if(split.length < 3 || split[2] == null) {
			return null;
		} else {
			return split[2];
		}
		
	}
	
	
	private Method getMethod(IServerBase obj, String path) {
		
		String className = getClassNameFromPath(path);
		String methodName = getMethodNameFromPath(path);
		
		if(methodName == null || !methods_.get(className).containsKey(methodName)) {
			methodName = obj.getDefaultMethod();
		}
		
		Method m = methods_.get(className).get(methodName);
		
		return m;
	}
	
	private IServerBase initClass(String className) throws ServerException {
		
		// Checks if the class already exists
		IServerBase clazz = classes_.get(className);
		if(clazz != null) {
			return clazz;
		}
		
		IServerBase obj = null;
		
		try {
			Class<?> c = Class.forName(className);
			Constructor<?> ct = c.getConstructor();
			
			// Check that the class implements the correct interface
			Class<?>[] interfaces = c.getInterfaces();
			boolean ok = false;
			for(Class<?> i : interfaces) {
				ok = ok || i.equals(IServerBase.class);
			}
			
			if(!ok) {
				return null;
			}

			obj = (IServerBase) ct.newInstance(new Object[0]);
			
			classes_.put(className, obj);
			
			// Get the methods from the class
			Method methlist[] = c.getDeclaredMethods();
			
			HashMap<String, Method> classMethods = new HashMap<String, Method>();
			
			for(Method m : methlist) {
				
				// Check if the programmer wants to put the method public
				if(m.isAnnotationPresent(PublicMethod.class)) {
					classMethods.put(m.getName(), m);
				}
			}
			
			methods_.put(className, classMethods);
			
		} catch (ClassNotFoundException e) {
			throw new ServerException("The class \"" + className + "\" was not found. You probably mispeled it.");
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}
	


}
