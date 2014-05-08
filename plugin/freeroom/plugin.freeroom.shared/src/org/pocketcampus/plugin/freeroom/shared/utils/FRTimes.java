package org.pocketcampus.plugin.freeroom.shared.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.pocketcampus.plugin.freeroom.shared.FRPeriod;
import org.pocketcampus.plugin.freeroom.shared.FreeRoomRequest;

/**
 * This is an utility class doing useful conversions, and defining a few
 * constants.
 * <p>
 * 
 * @author FreeRoom Project Team - Julien WEBER <julien.weber@epfl.ch> and
 *         Valentin MINDER <valentin.minder@epfl.ch>
 * 
 */
public class FRTimes {
	public static final long ONE_SEC_IN_MS = 1000;
	public static final long ONE_MIN_IN_MS = ONE_SEC_IN_MS * 60;
	public static final long ONE_HOUR_IN_MS = ONE_MIN_IN_MS * 60;
	public static final long ONE_DAY_IN_MS = ONE_HOUR_IN_MS * 24;
	public static final long ONE_WEEK_IN_MS = ONE_DAY_IN_MS * 7;
	public static final long ONE_MONTH_IN_MS = ONE_DAY_IN_MS * 30;
	public static final long MAXIMAL_WEEKS_IN_FUTURE = 14;
	public static final long MAXIMAL_WEEKS_IN_PAST = 4;

	public static final long STEP_OF_OCCUPANCY = ONE_HOUR_IN_MS;
	public static final long MAX_TIME_IN_FUTURE = ONE_DAY_IN_MS;
	public static final long MAX_TIME_IN_PAST = ONE_WEEK_IN_MS;
	public static final long AUTO_UPDATE_INTERVAL_USER_OCCUPANCY = ONE_DAY_IN_MS;
	/**
	 * This MUST be less than half of step of occupancy!
	 */
	public static final long USER_OCCUPANCY_UPDATE_MARGIN = ONE_MIN_IN_MS;

	public static final int FIRST_HOUR_CHECK = 8;
	public static final int LAST_HOUR_CHECK = 19;
	public static final int MIN_MINUTE_INTERVAL = 5;

	/**
	 * Return a FreeRoomRequest from a given day, starthour and endhour.
	 * 
	 * @param day
	 * @param startHour
	 * @param endHour
	 * @return
	 */
	public static FreeRoomRequest convert(int day, int startHour, int endHour) {
		return new FreeRoomRequest(convertFRPeriod(day, startHour, endHour));
	}

	public static FRPeriod convertFRPeriod(int day, int startHour, int endHour) {
		Calendar calendar = Calendar.getInstance();
		int today_day = calendar.get(Calendar.DAY_OF_WEEK);
		int now_hour = calendar.get(Calendar.HOUR_OF_DAY);

		// first case we are the given day but the specified hour is before,
		// thus need to go to the next given day
		// if you select the current hour, it's this day! But if it's before the
		// current hour, it's the next week!
		// also the case for cases where the given day is different from today
		long timestampshift = 0;
		if (now_hour >= startHour && day == today_day) {
			timestampshift = ONE_WEEK_IN_MS;
		} else if (day != today_day) {
			if (today_day < day) {
				timestampshift = (day - today_day) * ONE_DAY_IN_MS;
			} else {
				int daysToCompleteWeek = 7 - today_day;
				int daysToGo = daysToCompleteWeek + day;
				timestampshift = daysToGo * ONE_DAY_IN_MS;
			}
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() + timestampshift);
		calendar.set(Calendar.HOUR_OF_DAY, startHour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		long t_start = calendar.getTimeInMillis();
		long t_end = t_start + (endHour - startHour) * ONE_HOUR_IN_MS;

		return new FRPeriod(t_start, t_end, false);
	}

	/**
	 * Define the period with more precision. for instance : Monday, 10h25-10h59
	 * convertWith...sion(Calendar.Monday, 10, 15, 10, 59)
	 * 
	 * @param day
	 *            The day as defined in Calendar class.
	 * @param startHour
	 *            The start of the period in hours
	 * @param startMin
	 *            The precision in minutes for the start
	 * @param endHour
	 *            The end of the period in hours
	 * @param endMin
	 *            The precision in minutes for the end
	 * @return
	 */
	public static FreeRoomRequest convertWithMinPrecision(int day,
			int startHour, int startMin, int endHour, int endMin) {
		return new FreeRoomRequest(convertWithMinPrecisionFRPeriod(day,
				startHour, startMin, endHour, endMin));
	}

	public static FRPeriod convertWithMinPrecisionFRPeriod(int day,
			int startHour, int startMin, int endHour, int endMin) {
		FRPeriod period = convert(day, startHour, endHour).getPeriod();
		period.setTimeStampStart(period.getTimeStampStart() + startMin
				* ONE_MIN_IN_MS);
		period.setTimeStampEnd(period.getTimeStampEnd() + endMin
				* ONE_MIN_IN_MS);
		return period;
	}

	/**
	 * Returns a list of FRPeriod that are contiguous, that covers entirely the
	 * given mFrPeriod, and that have steps of exactly step.
	 * 
	 * Moreover, all the period starts with a full step.
	 * 
	 * Example: if you select from 14.12 to 15.32 with step half an hour, you'll
	 * get a list of {(14.00, 14.30), (14.30,15.00), (15.00, 15.30), (15.30,
	 * 16.00)}
	 * 
	 * The default <code>STEP_OF_OCCUPANCY</code> is used there.
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static List<FRPeriod> getFRPeriodByStep(FRPeriod mFrPeriod) {
		return getFRPeriodByStep(mFrPeriod, STEP_OF_OCCUPANCY);
	}

	private static List<FRPeriod> getFRPeriodByStep(FRPeriod mFrPeriod,
			long step) {
		long timestampEnd = mFrPeriod.getTimeStampEnd();
		long timestampStart = mFrPeriod.getTimeStampStart();
		long size = (timestampEnd - timestampStart) / step + 2;
		List<FRPeriod> mFrPeriods = new ArrayList<FRPeriod>((int) size);

		timestampStart = getPreviousTimeStampFromStep(timestampStart, step,
				true);
		timestampEnd = getPreviousTimeStampFromStep(timestampEnd, step, false);
		long next = timestampStart + step;
		for (; next <= timestampEnd; timestampStart += step, next += step) {
			FRPeriod period = new FRPeriod(timestampStart, next, false);
			mFrPeriods.add(period);
		}
		return mFrPeriods;
	}

	/**
	 * Returns the previous full step just before the timestamp. (if previous
	 * boolean is false, returns the next one).
	 * 
	 * @param timeStamp
	 * @param step
	 * @param previous
	 * @return
	 */
	private static long getPreviousTimeStampFromStep(long timeStamp, long step,
			boolean previous) {
		long shift = (timeStamp % step);
		if (shift == 0) {
			return timeStamp;
		}

		if (previous) {
			return timeStamp - shift;
		} else {
			return timeStamp + step - shift;
		}
	}

	/*
	 * All the validCalendars share the same JAVADOC.
	 */

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static boolean validCalendars(FRPeriod mFrPeriod) {
		String message = validCalendarsString(mFrPeriod);
		return message.equals("");
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static boolean validCalendars(FRPeriod mFrPeriod, long now) {
		String message = validCalendarsString(mFrPeriod, now);
		return message.equals("");
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static boolean validCalendars(Calendar start, Calendar end) {
		FRPeriod mFRPeriod = new FRPeriod(start.getTimeInMillis(),
				end.getTimeInMillis(), false);
		return validCalendars(mFRPeriod);
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static boolean validCalendars(Calendar start, Calendar end, long now) {
		FRPeriod mFRPeriod = new FRPeriod(start.getTimeInMillis(),
				end.getTimeInMillis(), false);
		return validCalendars(mFRPeriod, now);
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static String validCalendarsString(Calendar start, Calendar end) {
		FRPeriod mFRPeriod = new FRPeriod(start.getTimeInMillis(),
				end.getTimeInMillis(), false);
		return validCalendarsString(mFRPeriod);
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static String validCalendarsString(Calendar start, Calendar end,
			long now) {
		FRPeriod mFRPeriod = new FRPeriod(start.getTimeInMillis(),
				end.getTimeInMillis(), false);
		return validCalendarsString(mFRPeriod, now);
	}

	/**
	 * See the doc of
	 * <code>public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp)</code>
	 * 
	 * @param mFrPeriod
	 * @return
	 */
	public static String validCalendarsString(FRPeriod mFrPeriod) {
		long now = System.currentTimeMillis();
		return validCalendarsString(mFrPeriod, now);
	}

	/**
	 * Check if the given period is correct
	 * 
	 * Constructed from the previous methods in both server and client. Now they
	 * share the exact same definition of a "valid" or "invalid" period.
	 * 
	 * A valid period: is between Monday and Friday, between 8am and 7pm, the
	 * start timestamp is before the end timestamp, and as a length of at least
	 * 5 minutes.
	 * 
	 * It cannot be in the past more than 1 month, and in the future more than 4
	 * month.
	 * 
	 * All these constants are ONLY defined in THIS class. Changing them there
	 * will immediately change them for both server and client.
	 * 
	 * The string returned is empty ("") if everything is fine. It contains an
	 * error message per line otherwise.
	 * 
	 * CAUTION: if you change the conditions, especially if you strengthen them,
	 * during PRODUCTION, and if you already have clients, they will probably
	 * have errors (they will be allowed to do things the server don't accept
	 * anymore).
	 * 
	 * @param mFrPeriod
	 *            a period of time to check
	 * @param nowTimeStamp
	 *            a time stamp representing "now" (used for testing purposes).
	 * @return empty string if is everything is fine, an error message if some
	 *         conditions does not hold (a message per condition broken)
	 */
	public static String validCalendarsString(FRPeriod mFrPeriod,
			long nowTimeStamp) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("");

		Calendar mStartCalendar = Calendar.getInstance();
		long startTimeStamp = mFrPeriod.getTimeStampStart();
		mStartCalendar.setTimeInMillis(startTimeStamp);

		Calendar mEndCalendar = Calendar.getInstance();
		long endTimeStamp = mFrPeriod.getTimeStampEnd();
		mEndCalendar.setTimeInMillis(endTimeStamp);

		// the end date should be after the start, not equal or before.
		if ((endTimeStamp - startTimeStamp) < 0) {
			buffer.append("Timestamp start is after timestamp end.\n");
		}

		// same year
		if (mStartCalendar.get(Calendar.YEAR) != mEndCalendar
				.get(Calendar.YEAR)) {
			buffer.append("Timestamps start and end must be same year.\n");
		}

		// same month
		if (mStartCalendar.get(Calendar.MONTH) != mEndCalendar
				.get(Calendar.MONTH)) {
			buffer.append("Timestamps start and end must be same month.\n");
		}

		// same day of month
		if (mStartCalendar.get(Calendar.DAY_OF_WEEK) != mEndCalendar
				.get(Calendar.DAY_OF_WEEK)) {
			buffer.append("Timestamps start and end must be same day of month.\n");
		}

		// defines the minimal time interval
		if (Math.abs(endTimeStamp - startTimeStamp) < MIN_MINUTE_INTERVAL
				* ONE_MIN_IN_MS) {
			buffer.append("Their should be at least " + MIN_MINUTE_INTERVAL
					+ " minutes to check.\n");
		}

		// not more than 24h (It's redundant: no message)
		if (Math.abs(mStartCalendar.getTimeInMillis()
				- mEndCalendar.getTimeInMillis()) > ONE_DAY_IN_MS
				+ MIN_MINUTE_INTERVAL) {
			buffer.append(" ");
		}

		// we only accept weekdays
		int dayWeek = mStartCalendar.get(Calendar.DAY_OF_WEEK);
		if (dayWeek == Calendar.SUNDAY || dayWeek == Calendar.SATURDAY) {
			buffer.append("Only weekdays are accepted. Please avoid Saturdays and Sundays.\n");
		}

		int startHour = mStartCalendar.get(Calendar.HOUR_OF_DAY);
		int startMinutes = mStartCalendar.get(Calendar.MINUTE);
		int endHour = mEndCalendar.get(Calendar.HOUR_OF_DAY);
		int endMinutes = mEndCalendar.get(Calendar.MINUTE);

		// we limit the first hour checkable
		if (startHour < FIRST_HOUR_CHECK) {
			buffer.append("Start time cannot be before " + FIRST_HOUR_CHECK
					+ " am .\n");
		}

		// we limit the last hour checkable
		// case > 19h
		if (endHour > LAST_HOUR_CHECK) {
			buffer.append("End time cannot be after " + LAST_HOUR_CHECK
					+ " am .\n");
		}
		// case 19h00
		if (endHour == LAST_HOUR_CHECK && endMinutes != 0) {
			buffer.append("End time cannot be after " + LAST_HOUR_CHECK
					+ " am .\n");
		}

		// It's redundant, no message
		if ((startHour > endHour)
				|| ((startHour == endHour) && startMinutes > endMinutes)) {
			buffer.append(" ");
		}

		// limit the timestamp in the past
		if (nowTimeStamp > startTimeStamp) {
			if ((nowTimeStamp - startTimeStamp) > MAXIMAL_WEEKS_IN_PAST
					* ONE_WEEK_IN_MS) {
				buffer.append("You cannot check more than "
						+ MAXIMAL_WEEKS_IN_PAST + " weeks in the past.\n");
			}
		}

		// limit the timestamp in the future
		if (nowTimeStamp < startTimeStamp) {
			if ((startTimeStamp - nowTimeStamp) > MAXIMAL_WEEKS_IN_FUTURE
					* ONE_WEEK_IN_MS) {
				buffer.append("You cannot check more than "
						+ MAXIMAL_WEEKS_IN_FUTURE + " weeks in the future.\n");
			}
		}

		return buffer.toString();
	}

	/**
	 * getNextValidPeriod() should return the next valid period to check,
	 * MON-FRI 8am-7pm
	 * 
	 * MON-FRI 8am-6pm should return nextHour to nextHour+1, minutes to 0.
	 * 
	 * MON-FRI 6am-6:55pm should return exact min up to 7pm
	 * 
	 * All night (after 6:55pm) should return next day 8am-9am
	 * 
	 * All weekend (after FR 6:55pm) should return next Monday 8am-9am
	 * 
	 * @return
	 */
	public static FRPeriod getNextValidPeriod() {
		return getNextValidPeriod(System.currentTimeMillis());
	}

	public static FRPeriod getNextValidPeriod(Calendar calendar) {
		return getNextValidPeriod(calendar.getTimeInMillis());
	}

	public static FRPeriod getNextValidPeriod(long nowTimeStampNeeded) {

		// reset the time to the present time given
		Calendar mCalendar = Calendar.getInstance();
		mCalendar.setTimeInMillis(nowTimeStampNeeded);

		int yearSelected = mCalendar.get(Calendar.YEAR);
		int monthSelected = mCalendar.get(Calendar.MONTH);
		int dayOfMonthSelected = mCalendar.get(Calendar.DAY_OF_MONTH);
		int startHourSelected = mCalendar.get(Calendar.HOUR_OF_DAY);
		int startMinSelected = mCalendar.get(Calendar.MINUTE);
		int endHourSelected = mCalendar.get(Calendar.HOUR_OF_DAY);
		int endMinSelected = mCalendar.get(Calendar.MINUTE);

		// values for test only (weekends, nights, ...)
		int temp_now_day_week = mCalendar.get(Calendar.DAY_OF_WEEK);
		int temp_now_hour = mCalendar.get(Calendar.HOUR_OF_DAY);
		int temp_now_min = mCalendar.get(Calendar.MINUTE);

		// starting Friday 18h55, and during all the weekend, we shift to Mon
		// between 0am and 1am. It will be reshifted to Mon 8h-9h after.
		int hourShift = 0;
		if (temp_now_day_week == Calendar.SUNDAY) {
			hourShift = 24 - temp_now_hour + 1;
		}
		if (temp_now_day_week == Calendar.SATURDAY) {
			hourShift = 24 - temp_now_hour + 1;
			hourShift += 24;
		}
		if ((temp_now_day_week == Calendar.FRIDAY)
				&& checkHourMinIsEveningAndShifted(temp_now_hour, temp_now_min)) {
			hourShift = 24 - temp_now_hour + 1;
			hourShift += 2 * 24;
		}
		long newTimeInMS = mCalendar.getTimeInMillis() + hourShift
				* ONE_HOUR_IN_MS;
		mCalendar.setTimeInMillis(newTimeInMS);

		// actualize with the enventually shifted Calendar
		temp_now_hour = mCalendar.get(Calendar.HOUR_OF_DAY);
		temp_now_min = mCalendar.get(Calendar.MINUTE);

		yearSelected = mCalendar.get(Calendar.YEAR);
		monthSelected = mCalendar.get(Calendar.MONTH);
		dayOfMonthSelected = mCalendar.get(Calendar.DAY_OF_MONTH);

		// default set: next hour to next+1 hour, all minutes to 0
		// Works perfectly Mon-Fri 8h-18h.
		// weekend are handled before to be on next Monday.
		startHourSelected = mCalendar.get(Calendar.HOUR_OF_DAY) + 1;
		startMinSelected = 0;
		endHourSelected = startHourSelected + 1;
		endMinSelected = 0;

		// during the evening (starting 18h55), we shift to the next morning
		// during the night (before 8h), we shift to the first hour of morning
		// (8h-9h).
		// during late afternoon (18h-18h55), we default set from now to 19h00.
		if (temp_now_hour < FIRST_HOUR_CHECK) {
			startHourSelected = FIRST_HOUR_CHECK;
			endHourSelected = FIRST_HOUR_CHECK + 1;
		} else if (checkHourMinIsEveningAndShifted(temp_now_hour, temp_now_min)) {
			yearSelected = mCalendar.get(Calendar.YEAR);
			monthSelected = mCalendar.get(Calendar.MONTH);
			dayOfMonthSelected = mCalendar.get(Calendar.DAY_OF_MONTH);
			mCalendar
					.setTimeInMillis(mCalendar.getTimeInMillis() + 24 * 3600 * 1000);
			yearSelected = mCalendar.get(Calendar.YEAR);
			monthSelected = mCalendar.get(Calendar.MONTH);
			dayOfMonthSelected = mCalendar.get(Calendar.DAY_OF_MONTH);
			startHourSelected = FIRST_HOUR_CHECK;
			endHourSelected = FIRST_HOUR_CHECK + 1;
		} else if (temp_now_hour == LAST_HOUR_CHECK - 1) {
			startHourSelected = temp_now_hour;
			startMinSelected = temp_now_min;
			endHourSelected = temp_now_hour + 1;
		}

		mCalendar.set(yearSelected, monthSelected, dayOfMonthSelected,
				startHourSelected, startMinSelected);
		long startMS = mCalendar.getTimeInMillis();
		mCalendar.set(yearSelected, monthSelected, dayOfMonthSelected,
				endHourSelected, endMinSelected);
		long endMS = mCalendar.getTimeInMillis();

		FRPeriod mFrPeriod = new FRPeriod(startMS, endMS, false);
		return mFrPeriod;
	}

	/**
	 * Checks if the given hour and minutes is evening. Request in evening are
	 * shifted to next morning.
	 * 
	 * Should return true if time is greater or equal to 19h00, up to 24h00.
	 * Moreover, it returns true a few minutes before 19h00, because we need at
	 * least a few minutes to check
	 * 
	 * @param hour
	 * @param min
	 * @return
	 */
	private static boolean checkHourMinIsEveningAndShifted(int hour, int min) {
		return (hour >= LAST_HOUR_CHECK)
				|| (hour == (LAST_HOUR_CHECK - 1) && min >= (60 - MIN_MINUTE_INTERVAL));
	}

	/**
	 * Compare two calendars to know if it's the same day, basically if their
	 * year/month/day are all the same.
	 * 
	 * @param cal1
	 *            first calendar to compare
	 * @param cal2
	 *            second calendar to compare
	 * @return true if their year/month/day are all the same.
	 */
	public static boolean compareCalendars(Calendar cal1, Calendar cal2) {
		boolean sameYear = (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR));
		boolean sameMonth = (cal1.get(Calendar.MONTH) == cal2
				.get(Calendar.MONTH));
		boolean sameDay = (cal1.get(Calendar.DAY_OF_MONTH) == cal2
				.get(Calendar.DAY_OF_MONTH));
		return sameYear && sameMonth && sameDay;
	}
}