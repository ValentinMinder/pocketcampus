package org.pocketcampus.plugin.freeroom.server.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.pocketcampus.platform.sdk.server.database.ConnectionManager;
import org.pocketcampus.platform.sdk.server.database.handlers.exceptions.ServerException;

public class FetchRoomsDetails {

	private final String URL_ROOMS_LIST = "https://pocketcampus.epfl.ch/proxy/"
			+ "archibus.php/rwsrooms/searchRooms"
			+ "?961264a174e15211109e1deb779b17d0=1&app=freeroom&"
			+ "caller=public&unitname=DAF%";
	private final String URL_INDIVIDUAL_ROOM = "http://pocketcampus.epfl.ch/proxy/"
			+ "archibus.php/rwsrooms/getRoom"
			+ "?961264a174e15211109e1deb779b17d0=1&app=freeroom&caller=sciper&id=";
	private final String FILE_DINCAT = "src/org/pocketcampus/plugin/freeroom/server/data/locaux_din.txt";
	private HashMap<String, String> dincat_text = null;

	private ConnectionManager connMgr = null;

	public FetchRoomsDetails(String db_url, String username, String passwd) {
		try {
			connMgr = new ConnectionManager(db_url, username, passwd);
		} catch (ServerException e) {
			e.printStackTrace();
		}

	}

	public int fetchRoomsIntoDB() {
		int totalCount = 0;
		StringBuffer page = new StringBuffer();
		URL url;
		InputStream is = null;
		BufferedReader bufferedInput;

		try {
			url = new URL(URL_ROOMS_LIST);
			is = url.openStream();
			bufferedInput = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = bufferedInput.readLine()) != null) {
				page.append(line);
			}

			totalCount += fetchAndinsertRoomsDetailsFromJSONtoDB(page);
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return totalCount;
	}

	/**
	 * Fetch details about a room (i.e all its attributes) and convert it to a
	 * JSONObject.
	 * 
	 * @param uid
	 *            The unique id of the room to fetch.
	 * @return The JSONObject associated or null if an error occured (wrong id,
	 *         error...)
	 */
	public JSONObject fetchRoomDetail(String uid) {
		StringBuffer mRoomDetail = new StringBuffer();
		URL url;
		InputStream is = null;
		BufferedReader bufferedInput;
		JSONObject mJSONRoom = null;

		try {
			url = new URL(URL_INDIVIDUAL_ROOM + uid);
			is = url.openStream();
			bufferedInput = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = bufferedInput.readLine()) != null) {
				mRoomDetail.append(line);
			}

			mJSONRoom = new JSONObject(mRoomDetail.toString());

			if (mJSONRoom.has("result")) {
				return mJSONRoom.getJSONObject("result");
			}

		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	private int fetchAndinsertRoomsDetailsFromJSONtoDB(StringBuffer page) {
		int countInsert = 0;

		try {
			JSONObject jsonPage = new JSONObject(page.toString());
			JSONArray arrayPage = jsonPage.getJSONArray("result");

			int numberOfRecord = arrayPage.length();
			for (int i = 0; i < numberOfRecord; ++i) {
				JSONObject record = arrayPage.getJSONObject(i);
				String uid = record.getString("id");

				JSONObject roomDetail = fetchRoomDetail(uid);

				if (roomDetail != null) {
					if (insertIntoDBRoomDetail(roomDetail)) {
						countInsert++;
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return countInsert;
	}

	private boolean insertIntoDBRoomDetail(JSONObject room) {
		Connection conn = null;
		try {
			conn = connMgr.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		String req = "INSERT INTO `fr-roomslist`("
				+ "uid, doorCode, doorCodeWithoutSpace, capacity, "
				+ "site_label, surface, building_name, zone, unitlabel, "
				+ "site_id, floor, unitname, site_name, unitid, building_label, "
				+ "cf, adminuse, type, dincat) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?, ?, ?, ?, ?)";
		PreparedStatement query;
		try {
			query = conn.prepareStatement(req);
			// filling the query with values
			// doorCode is mapped to name in the JSON
			if (room.has("id") && room.has("name")) {
				query.setString(1, room.getString("id"));
				query.setString(2, room.getString("name"));
				query.setString(3, room.getString("name").replaceAll("\\s", ""));
			} else {
				// the required field for inserting a new record in the DB are
				// not available,
				// useless to go further
				return false;
			}

			// from now, fields are optional, thus if some are not present,
			// we still continue to check the other
			String sitename = null;
			if (room.has("places")) {
				query.setInt(4, room.getInt("places"));
			} else {
				query.setNull(4, Types.INTEGER);
			}

			if (room.has("site_label")) {
				query.setString(5, room.getString("site_label"));
			} else {
				query.setNull(5, Types.CHAR);
			}

			if (room.has("surface")) {
				query.setDouble(6, room.getDouble("surface"));
			} else {
				query.setNull(6, Types.DOUBLE);
			}

			if (room.has("building_name")) {
				query.setString(7, room.getString("building_name"));
			} else {
				query.setNull(7, Types.CHAR);
			}

			if (room.has("zone")) {
				query.setString(8, room.getString("zone"));
			} else {
				query.setNull(8, Types.CHAR);
			}

			if (room.has("unitlabel")) {
				query.setString(9, room.getString("unitlabel"));
			} else {
				query.setNull(9, Types.CHAR);
			}

			if (room.has("site_id")) {
				query.setInt(10, room.getInt("site_id"));
			} else {
				query.setNull(10, Types.INTEGER);
			}

			if (room.has("floor")) {
				query.setInt(11, room.getInt("floor"));
			} else {
				query.setNull(11, Types.INTEGER);
			}

			if (room.has("unitname")) {
				query.setString(12, room.getString("unitname"));
			} else {
				query.setNull(12, Types.CHAR);
			}

			if (room.has("site_name")) {
				query.setString(13, room.getString("site_name"));
				sitename = room.getString("site_name");
			} else {
				query.setNull(13, Types.CHAR);
			}

			if (room.has("unitid")) {
				query.setInt(14, room.getInt("unitid"));
			} else {
				query.setNull(14, Types.INTEGER);
			}

			if (room.has("building_label")) {
				query.setString(15, room.getString("building_label"));
			} else {
				query.setNull(15, Types.CHAR);
			}

			if (room.has("cf")) {
				query.setString(16, room.getString("cf"));
			} else {
				query.setNull(16, Types.CHAR);
			}

			if (room.has("adminuse")) {
				query.setString(17, room.getString("adminuse"));
			} else {
				query.setNull(17, Types.CHAR);
			}

			if (room.has("dincat")) {
				String type = getFromFileDinCatString(room.getString("dincat"),
						sitename);
				query.setString(18, type);
				query.setString(19, room.getString("dincat"));
			} else {
				query.setNull(18, Types.CHAR);
				query.setNull(19, Types.CHAR);
			}

			query.executeUpdate();
			System.out.println("fetched"
					+ getFromFileDinCatString(room.getString("dincat"),
							sitename));
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private String getFromFileDinCatString(String dincat, String sitename) {
		if (dincat_text == null) {
			dincat_text = new HashMap<String, String>();
			try {
				Scanner sc = new Scanner(new File(FILE_DINCAT));

				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] lineSplitted = line.split("[;]");
					if (lineSplitted.length >= 2) {
						dincat_text.put(lineSplitted[0], lineSplitted[1]);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (sitename != null) {
			return dincat_text.get(dincat + "." + sitename);
		} else {
			return null;
		}

	}
}