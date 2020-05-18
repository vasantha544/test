package com.traveltek.BasePack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import utills.Property;

public class TestBase {
	
	public static  String baseURI;
	public static Response response;
	public Logger log;
	
	public TestBase() {
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	String filePath = "C:\\Users\\Lucy Rani\\Documents\\Automation\\BackendTesting\\Config\\Congfig.properties";
	
	public void initilizeFramework() {
		log.warn("demo");
		log.info("Framework initilized");
		baseURI = Property.getPropertyValue(filePath, "baseURI");
	}

}
