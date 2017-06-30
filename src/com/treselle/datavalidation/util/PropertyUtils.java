package com.treselle.datavalidation.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * Loads the property files.
 *
 */
public class PropertyUtils {

	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(PropertyUtils.class);

	/**
	 * properties
	 */
	private static Properties properties = new Properties();

	private PropertyUtils() {
		// Utility Class object creation is restricted.
	}

	/**
	 * Loads the property file with input stream
	 * 
	 * @param inputStream
	 */
	public static void init(InputStream inputStream) {

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			LOGGER.info("Exception in init "+e.getMessage());
		} finally {

			try {

				if(inputStream!=null) {
					inputStream.close();	
				}
			} catch(Exception e) {
				LOGGER.info("Exception in init "+e.getMessage());
			}
		}
	}

	/**
	 * Gets the value based on the key from property file.
	 * 
	 * @param key
	 * @return value
	 */
	public static String get(String key) {
		String value = "";
		
		if(properties.getProperty(key) != null) {
			value = properties.getProperty(key);
		}

		return value;
		
	}
}
