package com.pulselms.base.test;

import org.apache.log4j.Logger;

import com.pulselms.app.framework.EnvParameters;
import com.pulselms.app.framework.TestData;
import com.pulselms.app.framework.WebBase;

public class WebPortalBaseTest extends WebBase {
	
	public static String URL;
	public static String PearsonAdminUser;
	public static String PearsonAdminPassword;
	public static String SchoolAdminUser;
	public static String SchoolAdminPassword;
	public static String TeacherUser;
	public static String TeacherPassword;
	public static String StudentUser;
	public static String StudentPassword;
	public static String Product=TestData.getData("SampleProduct");
	
	protected static final Logger log = Logger.getLogger(WebPortalBaseTest.class);
		
	public void loadEnvData() {
		
		if (EnvParameters.ENV.equals("QA"))
		{
			URL=TestData.getData("QA_WebPortal");
		}
		else if(EnvParameters.ENV.equals("STAGE"))
		{
			URL=TestData.getData("STG_WebPortal");
		}
		else if(EnvParameters.ENV.equals("PROD"))
		{
			URL=TestData.getData("PROD_WebPortal");
		}
		else
		{
			log.info("Invalid Environment, Please specify a valid enviroment for choosing the users");
		}
	}

}
