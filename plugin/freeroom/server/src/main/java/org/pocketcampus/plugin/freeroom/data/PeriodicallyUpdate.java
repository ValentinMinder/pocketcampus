package org.pocketcampus.plugin.freeroom.data;

import org.pocketcampus.plugin.freeroom.server.FreeRoomServiceImpl;
import org.pocketcampus.plugin.freeroom.shared.Constants;
import org.pocketcampus.plugin.freeroom.shared.utils.FRTimes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;

/**
 * Runnable used to be launched periodically to fetch and update data in the
 * database
 * 
 * @author FreeRoom Project Team (2014/05)
 * @author Julien WEBER <julien.weber@epfl.ch>
 * @author Valentin MINDER <valentin.minder@epfl.ch>
 * 
 */
public class PeriodicallyUpdate implements Runnable {
	private FreeRoomServiceImpl server;
	private Connection conn;

	public PeriodicallyUpdate(FreeRoomServiceImpl server) {
		this.server = server;
	}

	/**
	 * Assume connUpdate's autocommit is set to false.
	 */
	public PeriodicallyUpdate(FreeRoomServiceImpl freeRoomServiceImpl,Connection connUpdate) {
		this.server = freeRoomServiceImpl;
		this.conn = connUpdate;
	}

	@Override
	public void run() {
		// The clean part, and setAutoCommit(false) is done just before
		// inserting, the later the better. See the fetchAndInsert(start,end)
		// below
		
		server.log(Level.INFO, "Starting update of data from ISA");
		FetchOccupancyDataJSON fodj = new FetchOccupancyDataJSON(server, conn);
		Calendar mCalendar = Calendar.getInstance();
		long now = mCalendar.getTimeInMillis();
		// end is two weeks after what is authorized by clients.
		// just in case the ISA server goes down for a while, or we cannot fetch
		// data for any other reason, we have data for a longer period.
		long end = now + (Constants.MAXIMAL_WEEKS_IN_FUTURE + 2)
				* FRTimes.ONE_WEEK_IN_MS;
		fodj.fetchAndInsert(now, end);

		try {
			this.conn.commit();
			server.log(Level.INFO, "Finished updating data for FreeRoom");
		} catch (SQLException e) {
			server.log(Level.SEVERE, "Cannot commit update change");
			e.printStackTrace();
		}

	}

}