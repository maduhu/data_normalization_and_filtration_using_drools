package com.treselle.datavalidation.value;

import java.util.Date;

import com.treselle.datavalidation.util.Constants;

/**
 * 
 * Arkansas POJO object.
 *
 */
public class Arkanas {
	
	private String apiNumber = Constants.EMPTY_STRING;
	private String firstProdDate = Constants.EMPTY_STRING;
	private String initialProcuction = Constants.EMPTY_STRING;
	private float gasVol = 0.0f;
	private float oilVol = 0.0f;
	private float waterVol = 0.0f;
	private boolean isFilteredData = false;
	private Date dateTime = null;
	
	/**
	 * Gets the API number.
	 * 
	 * @return apiNumber
	 */
	public String getApiNumber() {
		return apiNumber;
	}
	
	/**
	 * Sets the API Number.
	 * 
	 * @param apiNumber
	 */
	public void setApiNumber(String apiNumber) {
		this.apiNumber = apiNumber;
	}
	
	/**
	 * Gets the first production date value.
	 * 
	 * @return firstProdDate
	 */
	public String getFirstProdDate() {
		return firstProdDate;
	}
	
	/**
	 * Sets the first production date.
	 * 
	 * @param firstProdDate
	 */
	public void setFirstProdDate(String firstProdDate) {
		this.firstProdDate = firstProdDate;
	}
	
	/**
	 * Gets the gas volume data.
	 * 
	 * @return gasVol
	 */
	public float getGasVol() {
		return gasVol;
	}
	
	/**
	 * Sets the gas volume data.
	 * 
	 * @param gasVol
	 */
	public void setGasVol(float gasVol) {
		this.gasVol = gasVol;
	}
	
	/**
	 * Gets the oil volume data
	 *
	 * @return oilVol
	 */
	public float getOilVol() {
		return oilVol;
	}
	
	/**
	 * Sets the oil volume data.
	 * 
	 * @param oilVol
	 */
	public void setOilVol(float oilVol) {
		this.oilVol = oilVol;
	}
	
	/**
	 * Gets the water volume data
	 * 
	 * @return waterVol
	 */
	public float getWaterVol() {
		return waterVol;
	}
	
	/**
	 * Sets the water volume data.
	 * 
	 * @param waterVol
	 */
	public void setWaterVol(float waterVol) {
		this.waterVol = waterVol;
	}
	
	/**
	 * Checks for is filtered data.
	 * 
	 * @return isFilteredData
	 */
	public boolean isFilteredData() {
		return isFilteredData;
	}
	
	/**
	 * Sets whether filtered data.
	 * 
	 * @param isFilteredData
	 */
	public void setFilteredData(boolean isFilteredData) {
		this.isFilteredData = isFilteredData;
	}
	
	/**
	 * Gets the initial production value.
	 * 
	 * @return initialProcuction
	 */
	public String getInitialProcuction() {
		return initialProcuction;
	}
	
	/**
	 * Sets the initial production value.
	 * 
	 * @param initialProcuction
	 */
	public void setInitialProcuction(String initialProcuction) {
		this.initialProcuction = initialProcuction;
	}
	
	/**
	 * Gets the date time.
	 * 
	 * @return dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}
	
	/**
	 * Sets the date time.
	 * 
	 * @param dateTime
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
		
	}
	
}
