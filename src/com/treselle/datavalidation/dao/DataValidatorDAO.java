package com.treselle.datavalidation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.treselle.datavalidation.util.DBConnection;
import com.treselle.datavalidation.util.PropertyUtils;
import com.treselle.datavalidation.value.Arkanas;
import com.treselle.datavalidation.value.Oklahoma;

public class DataValidatorDAO {

	private static Logger LOGGER = Logger.getLogger(DataValidatorDAO.class);

	/**
	 * 1.Gets the Oklahoma raw content from MSSQL.
	 * 2.Converts the Oklahoma data into list of objects.
	 * 
	 * @param query
	 * @return oklahomaContent
	 */
	public List<Oklahoma> getOklahomaContent(String query) {
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		List<Oklahoma> oklahomaContent = new ArrayList<Oklahoma>();

		try {
			//Gets the DB Connection.
			conn = DBConnection.getConnection();
			st=conn.createStatement();
			//Executes the query to get Oklahoma raw content.
			rs=st.executeQuery(query);
			Oklahoma oklahoma = null;

			while(rs.next())
			{
				oklahoma = new Oklahoma();

				oklahoma.setApiNumber(rs.getString("api_number"));
				oklahoma.setTestDate(rs.getDate("test_date"));
				oklahoma.setModifyDate(rs.getDate("modify_date"));
				oklahoma.setGasmcfPerday(rs.getFloat("gasmcf_perday"));
				oklahoma.setOilbblPerday(rs.getFloat("oilbbl_perday"));
				oklahoma.setWaterbblPerday(rs.getFloat("waterbbl_perday"));
				oklahoma.setDrillType(rs.getString("drill_type"));

				oklahomaContent.add(oklahoma);
			}
		} catch ( Exception e ) {
			LOGGER.info("Exception in getOklahomaContent "+e.getMessage());
		} 

		return oklahomaContent;

	}

	/**
	 * Inserts the filtered output data into MSSQL.
	 * 
	 * @param oklahomaData
	 */
	public void insertOklahomaData(List<Oklahoma> oklahomaData) {

		LOGGER.info("Inserting Oklahoma data...........");
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			//Gets the DB Connection.
			conn = DBConnection.getConnection();
			String insertQuery = PropertyUtils.get("oklahoma_transient_insert_query");
			ps = conn.prepareStatement(insertQuery);
			int idCount = 0;

			for(Oklahoma oklahoma : oklahomaData) {

				if(oklahoma.isFilteredData()) {
					idCount++;

					ps.setInt(1, idCount);
					ps.setString(2, oklahoma.getApiNumber());
					ps.setFloat(3, oklahoma.getOilbblPerday());
					ps.setFloat(4, oklahoma.getGasmcfPerday());
					ps.setFloat(5, oklahoma.getWaterbblPerday());
					ps.setDate(6, (Date) oklahoma.getTestDate());
					ps.setDate(7, new Date(Calendar.getInstance().getTime().getTime()));
					ps.setDate(8, new Date(Calendar.getInstance().getTime().getTime()));

					ps.addBatch();
				}
			}
			ps.executeBatch();
		} catch(Exception e) {
			LOGGER.info("Exception in insertOklahomaData "+e.getMessage());
		}finally {

		}
	}

	/**
	 * 1.Gets the Arkansas raw content from MSSQL.
	 * 2.Converts the Arkansas data into list of objects.
	 * 
	 * @param query
	 * @return arkanasContent
	 */
	public List<Arkanas> getArkanasData(String query) {
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		List<Arkanas> arkanasContent = new ArrayList<Arkanas>();

		try {
			//Gets the DB Connection.
			conn = DBConnection.getConnection();
			st=conn.createStatement();
			//Executes the query to get Arkansas raw content.
			rs=st.executeQuery(query);
			Arkanas arkanas = null;

			while(rs.next())
			{
				arkanas = new Arkanas();
				arkanas.setApiNumber(rs.getString("api_number"));
				arkanas.setFirstProdDate(rs.getString("first_prod_date"));
				arkanas.setInitialProcuction(rs.getString("initial_production"));
				
				arkanasContent.add(arkanas);

			}
		} catch (Exception e) {
			LOGGER.info("Exception in getArkanasData "+e.getMessage());
		}

		return arkanasContent;

	}

	/**
	 * Inserts the filtered output data into MSSQL.
	 * 
	 * @param arkanasData
	 */
	public void insertArkanasData(List<Arkanas> arkanasData) {

		LOGGER.info("Inserting Arkansas data...........");
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			//Gets the DB Connection.
			conn = DBConnection.getConnection();
			String insertQuery = PropertyUtils.get("arkanas_transient_insert_query");
			Statement st = conn.createStatement();
			st.execute("SET IDENTITY_INSERT  energy_transient.dbo.ar_transient ON");
			ps = conn.prepareStatement(insertQuery);
			int idCount = 0;

			for(Arkanas arkanas : arkanasData) {

				if(arkanas.isFilteredData()) {
					idCount++;

					ps.setInt(1, idCount);
					ps.setString(2, arkanas.getApiNumber());
					ps.setFloat(3, arkanas.getOilVol());
					ps.setFloat(4, arkanas.getGasVol());
					ps.setFloat(5, arkanas.getWaterVol());
					ps.setDate(6, new Date(arkanas.getDateTime().getTime()));
					ps.setDate(7, new Date(Calendar.getInstance().getTime().getTime()));
					ps.setDate(8, new Date(Calendar.getInstance().getTime().getTime()));

					ps.addBatch();
				}
			}
			ps.executeBatch();
		} catch(Exception e) {
			LOGGER.info("Exception in insertArkanasData "+e.getMessage());
		}finally {
			try {
				if(conn!=null && ps!=null) {
					conn.close();
					ps.close();
				}
			} catch (SQLException e) {
				LOGGER.info("Exception in insertArkanasData "+e.getMessage());
			}
		}
	}
}
