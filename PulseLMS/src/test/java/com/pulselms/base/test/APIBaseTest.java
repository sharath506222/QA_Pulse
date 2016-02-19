package com.pulselms.base.test;

import org.testng.annotations.BeforeClass;

import com.pulselms.api.services.GLSAPIServices;

public class APIBaseTest extends GLSAPIServices {
	
	@BeforeClass
	public void setUp() {
		
		chooseEnv();
//		chooseUserAccount();
	}
}
