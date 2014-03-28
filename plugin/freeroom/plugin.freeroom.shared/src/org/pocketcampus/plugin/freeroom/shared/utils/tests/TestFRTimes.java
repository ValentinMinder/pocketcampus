package org.pocketcampus.plugin.freeroom.shared.utils.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.pocketcampus.plugin.freeroom.shared.utils.FRTimes;

public class TestFRTimes {

	/**
	 * Tests that all cases excluded from valid calendars are indeed excluded.
	 */
	@Test
	public void testValidCalendars() {

		Calendar calStart = Calendar.getInstance();
		// 24.03.2014 was a Monday, no problem
		calStart.set(2014, 02, 24, 9, 0, 0);
		calStart.set(Calendar.MILLISECOND, 0);

		Calendar calEnd = Calendar.getInstance();
		calEnd.set(2014, 02, 24, 10, 0, 0);
		calEnd.set(Calendar.MILLISECOND, 0);

		long now = calStart.getTimeInMillis();
		long nowEnd = calEnd.getTimeInMillis();

		// usual period
		assertTrue(FRTimes.validCalendars(calStart, calEnd, now));

		// start after end
		assertFalse(FRTimes.validCalendars(calEnd, calStart, now));

		// not same year
		calEnd.set(Calendar.YEAR, 2015);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.YEAR, 2014);
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// not same month
		calEnd.set(Calendar.MONTH, 4);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.MONTH, 2);
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// not same day
		calEnd.set(Calendar.DAY_OF_MONTH, 25);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.DAY_OF_MONTH, 22);
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// not enough time
		calEnd.set(Calendar.HOUR_OF_DAY, 9);
		calEnd.set(Calendar.MINUTE, FRTimes.MIN_MINUTE_INTERVAL - 1);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.HOUR_OF_DAY, 10);
		calEnd.set(Calendar.MINUTE, 0);
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// not enough time
		calEnd.setTimeInMillis(calStart.getTimeInMillis()
				+ (FRTimes.MIN_MINUTE_INTERVAL - 1) * FRTimes.ONE_MIN_IN_MS);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// not weekdays
		calEnd.setTimeInMillis(now - FRTimes.ONE_DAY_IN_MS);
		calStart.setTimeInMillis(nowEnd - FRTimes.ONE_DAY_IN_MS);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// limit of first hour
		calStart.set(Calendar.HOUR_OF_DAY, 7);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calStart.set(Calendar.HOUR_OF_DAY, 9);
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// limit of last hour (case > 19h)
		calEnd.set(Calendar.HOUR_OF_DAY, 20);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.HOUR_OF_DAY, 10);

		// limit of last hour (case 19h01)
		calEnd.set(Calendar.HOUR_OF_DAY, 19);
		calEnd.set(Calendar.MINUTE, 1);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.HOUR_OF_DAY, 10);
		calEnd.set(Calendar.MINUTE, 0);

		// checking minutes (a bit of redundancy)
		calEnd.set(Calendar.HOUR_OF_DAY, 9);
		calEnd.set(Calendar.MINUTE, 10);
		calStart.set(Calendar.MINUTE, 50);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calEnd.set(Calendar.HOUR_OF_DAY, 10);
		calEnd.set(Calendar.MINUTE, 0);
		calStart.set(Calendar.MINUTE, 0);

		// cannot check too much in the past
		// As we shift with full weeks, it's garanteed to stay on Monday!
		calStart.setTimeInMillis(now - (FRTimes.MAXIMAL_WEEKS_IN_PAST + 1)
				* FRTimes.ONE_WEEK_IN_MS);
		calEnd.setTimeInMillis(calStart.getTimeInMillis()
				+ FRTimes.ONE_HOUR_IN_MS);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// cannot check too much in the future
		calStart.setTimeInMillis(now + (FRTimes.MAXIMAL_WEEKS_IN_FUTURE + 1)
				* FRTimes.ONE_WEEK_IN_MS);
		calEnd.setTimeInMillis(calStart.getTimeInMillis()
				+ FRTimes.ONE_HOUR_IN_MS);
		assertFalse(FRTimes.validCalendars(calStart, calEnd, now));
		calStart.setTimeInMillis(now);
		calEnd.setTimeInMillis(nowEnd);

		// well... we tested so many cases !!!
	}

	/**
	 * This test ONLY that it gives a valid period.
	 * 
	 * This doesn't test that it's the one that is supposed to be given.
	 */
	@Test
	public void testGetNextValidPeriodGiveValidPeriod() {

		Calendar mCalendar = Calendar.getInstance();
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// thursday, early morning
		mCalendar.set(2014, 02, 20, 01, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// thursday, during day, usual
		mCalendar.set(2014, 02, 20, 17, 59);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// thursday, late afternoon
		mCalendar.set(2014, 02, 20, 18, 23);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// thursday, after delay
		mCalendar.set(2014, 02, 20, 18, 56);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// thursday, after delay
		mCalendar.set(2014, 02, 20, 19, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// friday, late afternoon
		mCalendar.set(2014, 02, 21, 18, 23);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// friday, after delay
		mCalendar.set(2014, 02, 21, 18, 56);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// friday, after delay
		mCalendar.set(2014, 02, 21, 19, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, early morning
		mCalendar.set(2014, 02, 22, 00, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, early morning
		mCalendar.set(2014, 02, 22, 00, 21);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, during day, usual
		mCalendar.set(2014, 02, 22, 17, 59);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, late afternoon
		mCalendar.set(2014, 02, 22, 18, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, after delay
		mCalendar.set(2014, 02, 22, 18, 55);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, after delay
		mCalendar.set(2014, 02, 22, 19, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, early morning
		mCalendar.set(2014, 02, 23, 00, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, during day, usual
		mCalendar.set(2014, 02, 23, 17, 59);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, late afternoon
		mCalendar.set(2014, 02, 23, 18, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, after delay
		mCalendar.set(2014, 02, 23, 18, 55);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// saturday, after delay
		mCalendar.set(2014, 02, 23, 19, 00);
		assertTrue(FRTimes
				.validCalendars(FRTimes.getNextValidPeriod(mCalendar)));

		// checks the validity of 100000 hasardous times during a week!
		for (int i = 0; i < 100000; i++) {
			long now = (long) (Math.random() * FRTimes.ONE_WEEK_IN_MS);
			assertTrue(FRTimes.validCalendars(FRTimes.getNextValidPeriod(System
					.currentTimeMillis() + now)));
		}

	}
	
	@Test
	public void testGetNextValidPeriodIsNeededValidPeriod() {
		// TODO: write this test for many cases!
	}

}