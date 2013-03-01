package com.mehdok.jimer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * this class performing all time and schedule related stuff.
 * @author MEHDOK
 *
 */
public class TimeStuff 
{
	// date fields.
	private static  int year = 0;
	private static  int month = 0;
	private static  int day = 0;
	private static  int hour = 0;
	private static  int minute = 0;
	private static  int second = 0;
		
		
	/**
	 * this method find the current date and fill the field of date.
	 */
	public void getCurrentTime()
	{
		// create an instance of current time.
		Calendar rightNow = Calendar.getInstance();
		
		// fill the date field with current time.
		year   = rightNow.get(Calendar.YEAR);//rightNow.YEAR;
		month  = rightNow.get(Calendar.MONTH) + 1;
		day    = rightNow.get(Calendar.DAY_OF_MONTH);
		hour   = rightNow.get(Calendar.HOUR_OF_DAY);
		minute = rightNow.get(Calendar.MINUTE);
		second = rightNow.get(Calendar.SECOND);
	}
	
	/**
	 * this method create a calendar instance and set the desired time for
	 * executing something, then return the calendar fir using in Timer class.
	 * 
	 * @param sYear, year the command will be executed.
	 * @param sMonth, month the command will be executed.
	 * @param sDay, day the command will be executed.
	 * @param sHour, hour the command will be executed.
	 * @param sMinute, minute the command will be executed.
	 * @param sSecond, second the command will be executed.
	 * @return time, returning schedulded calendar
	 */
	public  Calendar setFutureTime(int sYear,
									int sMonth,
									int sDay,
									int sHour,
									int sMinute,
									int sSecond)
	{
		// create an instance of current time.
		Calendar time = Calendar.getInstance();
		
		// fill the calendar field with specific time.
		time.set(Calendar.YEAR, sYear);
		time.set(Calendar.MONTH, sMonth);
		time.set(Calendar.DAY_OF_MONTH, sDay);
		time.set(Calendar.HOUR, sHour);
		time.set(Calendar.MINUTE, sMinute);
		time.set(Calendar.SECOND, sSecond);
		
		// returning time object of Calendar class
		return(time);
	}
	
	/**
	 * this method create a new instance of DoTask class and schedule the action
	 * to performed at the time.
	 * @param action, the action to be performed.
	 * @param time, time the action will be performed.
	 */
	public void newScheduled(int action, Date time)
	{
		Timer timer = new Timer();
		timer.schedule(new DoTask(action), time /* networkname also*/);
	}
}
