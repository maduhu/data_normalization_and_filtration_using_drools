package com.treselle.datavalidation.ruleengine;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class KnowledgeBase {
	
	private KieSession kSession = null;
	
	/**
	 * LOGGER
	 */
	private static Logger LOGGER = Logger.getLogger(KnowledgeBase.class);
	
	/**
	 * This method creates kiesession with given drl file path.
	 * 
	 * @param rulePath
	 */
	public void createKnowledgeSession(String rulePath) {
		//Gets the factory class for KIE.
		KieServices ks = KieServices.Factory.get();

		KieFileSystem kfs = ks.newKieFileSystem();
		KieRepository kr = ks.getRepository();
		
		File rulePathFile = new File(rulePath);
		File ruleFiles[] = null;
		
		if(rulePathFile.isDirectory()) {
			ruleFiles = rulePathFile.listFiles();
		}
		
		for(File drlFile : ruleFiles) {
			LOGGER.info("File path is "+drlFile.getAbsolutePath());
			kfs.write(ResourceFactory.newFileResource(drlFile));
		}
		
		KieBuilder kb = ks.newKieBuilder(kfs);
		kb.buildAll();
		
		KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
		this.kSession = kContainer.newKieSession();
	}
	
	/**
	 * Inserts the facts into kie session and fires the rules on facts
	 * 
	 * @param facts
	 */
	public void executeFacts(List<?> facts ) {
		for(Object obj : facts) {
			this.kSession.insert(obj);
		}
		LOGGER.info("Number of rules fired "+this.kSession.fireAllRules());
		this.kSession.dispose();
	}
}
