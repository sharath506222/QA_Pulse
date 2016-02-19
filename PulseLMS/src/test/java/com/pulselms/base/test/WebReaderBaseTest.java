package com.pulselms.base.test;

import org.apache.log4j.Logger;

import com.pulselms.app.framework.EnvParameters;
import com.pulselms.app.framework.TestData;
import com.pulselms.app.framework.WebBase;

public class WebReaderBaseTest extends WebBase {
	
	public static String URL;
	protected static String username="student@demo.com";
	protected static String password="hudson102";
	protected static final Logger log = Logger.getLogger(WebReaderBaseTest.class);
	
public void loadEnvData() {
		
		if (EnvParameters.ENV.equals("QA"))
		{
			URL=TestData.getData("QA_WebReader");
			
		}
		else if(EnvParameters.ENV.equals("STAGE"))
		{
			URL=TestData.getData("QA_WebReader");
		
		}
		else if(EnvParameters.ENV.equals("PROD"))
		{
			URL=TestData.getData("QA_WebReader");
			
		}
		else
		{
			log.info("Invalid Environment, Please specify a valid enviroment for choosing the users");
		}
	}

}
