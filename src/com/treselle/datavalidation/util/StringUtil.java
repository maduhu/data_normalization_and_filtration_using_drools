package com.treselle.datavalidation.util;

/**
 * 
 *Contains common method for validating string.
 *
 */
public class StringUtil {

	private StringUtil() {
		// Utility Class object creation is restricted.
	}
	
	/**
	 * Checks whether the string is valid or not.
	 * 
	 * @param str
	 * @return isValidStr
	 */
	public static boolean isValidString(String str) {
		boolean isValidStr = false;
		isValidStr = str!=null && !Constants.EMPTY_STRING.equalsIgnoreCase(str);
		
		return isValidStr;
		
	}
}
