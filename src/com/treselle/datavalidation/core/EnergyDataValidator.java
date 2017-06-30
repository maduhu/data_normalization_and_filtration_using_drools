package com.treselle.datavalidation.core;

import java.io.FileInputStream;

import org.apache.log4j.Logger;

import com.treselle.datavalidation.process.EnergyDataValidatorProcess;
import com.treselle.datavalidation.util.PropertyUtils;

/**
 * 
 * @author Treselle.
 *
 */
public class EnergyDataValidator {
	
	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(EnergyDataValidator.class);

	/**
	 * Filters and normalizes data 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		EnergyDataValidator energyDataValidator = new EnergyDataValidator();
		String currentWorkingDir = System.getProperty("user.dir").replaceAll("\\\\", "/");
		
		//Initializes the data filtration and normalization process.
		energyDataValidator.initProccess(currentWorkingDir);
		
		long endTime = System.currentTimeMillis() - startTime;
		LOGGER.info("Execution time is "+endTime+" milliseconds");
	}
	
	/**
	 * This method initializes the data filtration process.
	 * 
	 * @param propertyPath
	 */
	public void initProccess(String currentWorkingDir)  {
		try {
			String propertyPath = currentWorkingDir +"/src/common.properties";
			//Loads the Property class with property path defined.
			PropertyUtils.init(new FileInputStream(propertyPath));
			
			EnergyDataValidatorProcess energyDataValidatorProcess = new EnergyDataValidatorProcess();
			
			//Executes the input data processing and based on rules.
			energyDataValidatorProcess.dataValidator(currentWorkingDir);
			
		} catch(Exception exp) {
			LOGGER.info("Exception in initProccess "+exp.getMessage());
		}
	}

}
