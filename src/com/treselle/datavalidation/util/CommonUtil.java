package com.treselle.datavalidation.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 * This class contains common utils for dates.
 *
 */
public class CommonUtil {

	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(CommonUtil.class);

	/**
	 * Restrict object creation for util Class.
	 */
	private CommonUtil() {

	}

	/**
	 * Formats the date to the given format.
	 * 
	 * @param dateStr
	 * @param format
	 * @return date
	 */
	public static Date getDate(String dateStr,String format) {
		Date date = null;

		try {
			if(StringUtil.isValidString(dateStr)) {
				date = new SimpleDateFormat(format).parse(dateStr);
			}
		} catch (ParseException e) {
			LOGGER.info("Exception in getDate "+e.getMessage());
		}  

		return date;
	}

	/**
	 * This method checks whether date is an valid date.
	 * 
	 * @param dateStr
	 * @param format
	 * @return boolean
	 */ 
	public static boolean isValidDate(String dateStr,String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);

		try {
			dateFormat.parse(dateStr.trim());
		} catch (ParseException pe) {
			return false;
		}

		return true;

	}

	/**
	 * Checks for date range is with in start and end date range.
	 * 
	 * @param startDate
	 * @param endDate
	 * @param date
	 * @return boolean
	 */
	public static boolean isDateWithinRange(Date startDate,Date endDate,Date date) {
		return date.after(startDate) && date.before(endDate);
	}
}
