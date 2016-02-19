package com.pulselms.api.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.pulselms.app.framework.DataProviderArguments;
import com.pulselms.app.framework.DataProviderClass;
import com.pulselms.app.framework.RESTServiceBase;

import net.minidev.json.JSONObject;

public class TestUsers {
	
	
	@Test(dataProvider="DP_POI", dataProviderClass=DataProviderClass.class)
	@DataProviderArguments(data_Folder="bulkupload", data_File_Name="Controller.xlsx",sheetname="LoginTest",tablename="Dummy")
	public void GetAllUsersTest(Map<String, String> testdata) {
		
		
		System.out.println("UserName--->"+testdata.get("UserName"));
		System.out.println("Password--->"+testdata.get("Password"));
		webCredentialsPulse(testdata.get("UserName"),testdata.get("Password"));
		
		
//		Assert.assertEquals(response.statusCode(), 200);

	}
	
	
	
	
		
		public static Response webCredentialsPulse(String username, String password) {

			JSONObject myJsonObject= new JSONObject();
			myJsonObject.put("username", username);
			myJsonObject.put("password", password);
			Response response = RESTServiceBase.postCallWithFormParam(myJsonObject, "https://pulse-stg.noip.me:4000/auth");
			System.out.println("Response---->"+response.getStatusCode());
			Assert.assertEquals(response.statusCode(), 200);
			return response;	
			

		}


}
