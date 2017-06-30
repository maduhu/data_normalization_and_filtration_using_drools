package com.treselle.datavalidation.value;

import java.util.Date;

import com.treselle.datavalidation.util.Constants;

/**
 * 
 * Oklahoma POJO object.
 *
 */
public class Oklahoma {

	private String apiNumber = Constants.EMPTY_STRING;
	private Date testDate = null;
	private float oilbblPerday = 0.0f;
	private float gasmcfPerday = 0.0f;
	private float waterbblPerday = 0.0f;
	private Date modifyDate = null;
	private Date createTime = null;
	private Date updateTime = null;
	private boolean isFilteredData = false;
	private String drillType  = Constants.EMPTY_STRING;
	
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
	 * @return testDate
	 */
	public Date getTestDate() {
		return testDate;
	}
	
	/**
	 * Sets the first test date.
	 * 
	 * @param testDate
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	/**
	 * Gets the OilbblPerday.
	 * 
	 * @return oilbblPerday
	 */
	public float getOilbblPerday() {
		return oilbblPerday;
	}
	
	/**
	 * Sets the first oilbblPerday.
	 * 
	 * @param oilbblPerday
	 */
	public void setOilbblPerday(float oilbblPerday) {
		this.oilbblPerday = oilbblPerday;
	}
	
	/**
	 * Gets the gasmcfPerday.
	 * 
	 * @return gasmcfPerday
	 */
	public float getGasmcfPerday() {
		return gasmcfPerday;
	}
	
	/**
	 * Sets the gasmcfPerday.
	 * 
	 * @param gasmcfPerday
	 */
	public void setGasmcfPerday(float gasmcfPerday) {
		this.gasmcfPerday = gasmcfPerday;
	}
	
	/**
	 * Gets the waterbblPerday.
	 * 
	 * @return waterbblPerday
	 */
	public float getWaterbblPerday() {
		return waterbblPerday;
	}
	
	/**
	 * Sets the waterbblPerday.
	 * 
	 * @param waterbblPerday
	 */
	public void setWaterbblPerday(float waterbblPerday) {
		this.waterbblPerday = waterbblPerday;
	}
	
	/**
	 * Gets the createTime.
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * Sets the createTime.
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * Gets the updateTime.
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * Sets the updateTime.
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * Gets the first production date value.
	 * 
	 * @return modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	
	/**
	 * Sets the first production date.
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	/**
	 * Gets the first drillType.
	 * 
	 * @return drillType
	 */
	public String getDrillType() {
		return drillType;
	}
	
	/**
	 * Sets the first drillType.
	 * 
	 * @param drillType
	 */
	public void setDrillType(String drillType) {
		this.drillType = drillType;
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
}
