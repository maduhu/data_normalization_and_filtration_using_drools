package com.treselle.datavalidation.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

/**
 * 
 * Creates DB connection.
 *
 */
public class DBConnection {
	
	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(DBConnection.class);

	/**
	 * DB URL
	 */
	private static String url = PropertyUtils.get("url");
	
	/**
	 * USER NAME
	 */
	private static String userName = PropertyUtils.get("user_name");
	
	/**
	 * PASSWORD
	 */
	private static String passWord = PropertyUtils.get("password");
	
	/**
	 * DB CONNECTION
	 */
	private static Connection conn = null;
	
	//Loads the DB connection.
	static {
		
		try {
			LOGGER.info("Creating MSSQL connection ................");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,userName,passWord);
		} catch (Exception e) {
			LOGGER.info("Exception in static block for connection creation");
		}
	}

	/**
	 * Gets the DB connection
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {
		
		return conn;
	}
	
	
}
