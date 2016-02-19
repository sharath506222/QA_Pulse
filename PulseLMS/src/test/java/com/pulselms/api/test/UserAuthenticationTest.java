package com.pulselms.api.test;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.pulselms.app.framework.DataProviderArguments;
import com.pulselms.app.framework.DataProviderClass;
import com.pulselms.base.test.APIBaseTest;

public class UserAuthenticationTest extends APIBaseTest {
	
	protected static final Logger log = Logger.getLogger(UserAuthenticationTest.class);
     

	@Test
	public void AppIdTest() {
		
		Response response=app();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	/* @Test(dataProvider = "DP_POI", dataProviderClass = DataProviderClass.class@DataProviderArguments(data_Folder = "bulkupload", data_File_Name =
		"studentbulk.xlsx", sheetname = "MGI_23Dec-Testing")*/
	
	/*log.info("UserName-->"+login.get("UserName"));
	log.info("Pasword--->"+login.get("Password"));
	loginPage.login(login.get("UserName"),login.get("Password"));*/
	
	@Test(dataProvider="DP_POI", dataProviderClass=DataProviderClass.class)
	@DataProviderArguments(data_Folder="bulkupload", data_File_Name="Controller.xlsx",sheetname="LoginTest",tablename="Dummy")
	public void GetAllUsersTest(Map<String, String> testdata) {
		
		System.out.println("*********Method IN*****");
		
		generateAppId();
		System.out.println("222222");
		
		log.info("UserName--->"+testdata.get("UserName"));
		log.info("Password--->"+testdata.get("Password"));
		
		System.out.println("UserName--->"+testdata.get("UserName"));
		System.out.println("Password--->"+testdata.get("Password"));
		
		authenticate(testdata.get("UserName"), testdata.get("Password"));
		Response response = getAllUsers();
		Assert.assertEquals(response.statusCode(), 200);

	}

	/**
	 * Bulk User Upload Test, Not for regression suite. Can be used when there's
	 * any test requirement
	 * 
	 */

	// @Test(dataProvider = "DP_POI", dataProviderClass =
	// DataProviderClass.class)
	// @DataProviderArguments(data_Folder = "bulkupload", data_File_Name =
	// "studentbulk.xlsx", sheetname = "MGI_23Dec-Testing")
	/*public void UserCreationInBulkTest(Map<String, String> testdata) {

		generateAppId();
		authenticate(SchoolAdminUser, SchoolAdminPassword);
		String role = null;
		if (testdata.get("Role").equalsIgnoreCase("student")) {
			role = "student";
		} else {
			role = "teacher";
		}
		String[] roleNew = new String[] { role };
		Response response = createUser(testdata.get("Firstname"), testdata.get("Surname"), testdata.get("Email"),testdata.get("Password"), roleNew);
		Assert.assertEquals(response.statusCode(), 201);

	}*/

	
	@Test
	public void PearsonAdmin_AuthenticationTest() {
		
		generateAppId();
		Response response=authenticate(PearsonAdminUser, PearsonAdminPassword);
		Assert.assertEquals(response.statusCode(), 200);
				
	}
	
	@Test
	public void SchoolAdmin_AuthenticationTest() {
		
		generateAppId();
		Response response=authenticate(SchoolAdminUser, SchoolAdminPassword);
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test
	public void TeacherUser_AuthenticationTest() {
		
		generateAppId();
		Response response=authenticate(TeacherUser, TeacherPassword);
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test
	public void StudentUser_AuthenticationTest() {
		
		generateAppId();
		Response response=authenticate(StudentUser, StudentPassword);
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
