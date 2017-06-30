package com.treselle.datavalidation.process;

import java.util.List;

import org.apache.log4j.Logger;

import com.treselle.datavalidation.dao.DataValidatorDAO;
import com.treselle.datavalidation.ruleengine.KnowledgeBase;
import com.treselle.datavalidation.util.PropertyUtils;
import com.treselle.datavalidation.value.Arkanas;
import com.treselle.datavalidation.value.Oklahoma;

public class EnergyDataValidatorProcess {
	
	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(EnergyDataValidatorProcess.class);
	
	/**
	 * 1.Gets the raw Oklahoma and Arkansas data as list of Object.
	 * 2.Passes the Oklahoma and Arkansas rules path for creating ksession.
	 * 3.Raw data is passed on for applying rules.
	 */
	public void dataValidator(String currentWorkingDir) {
		DataValidatorDAO dataValidatorDAO = new DataValidatorDAO();
		KnowledgeBase kbase = new KnowledgeBase();
		
		//Gets the list of Oklahoma data from DB.
		List<Oklahoma> oklahomaData = dataValidatorDAO.getOklahomaContent(PropertyUtils.get("oklahoma_raw_data_query"));
		
		LOGGER.info("Oklahoma raw data input size is "+oklahomaData.size());
		String oklahomaRulesPath = currentWorkingDir+PropertyUtils.get("oklahoma_rules");
		
		//Creates the KIE session for given Oklahoma rules.
		kbase.createKnowledgeSession(oklahomaRulesPath);
		
		//Oklahoma data is passed on to knowledge base for applying rules on it for filtration and normalization.
		kbase.executeFacts(oklahomaData);
		
		//filtered data is inserted into the MSSQL.
		dataValidatorDAO.insertOklahomaData(oklahomaData);
		
		//Gets the list of Arkansas data from DB.
		List<Arkanas> arkanasData = dataValidatorDAO.getArkanasData(PropertyUtils.get("arkanas_raw_data_query"));
		
		LOGGER.info("Arkanas raw data input size is "+arkanasData.size());
		String arkanasRulesPath = currentWorkingDir+PropertyUtils.get("arkanas_rules");
		
		//Creates the KIE session for given arkanas rules.
		kbase.createKnowledgeSession(arkanasRulesPath);
		
		//Arkansas data is passed on to knowledge base for applying rules on it for filtration and normalization.
		kbase.executeFacts(arkanasData);
		
		//filtered data is inserted into the MSSQL.
		dataValidatorDAO.insertArkanasData(arkanasData);
	}
	
}
