package com.pulselms.api.services;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minidev.json.JSONObject;

import org.apache.log4j.Logger;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.pulselms.app.framework.EnvParameters;
import com.pulselms.app.framework.RESTServiceBase;
import com.pulselms.app.framework.TestData;

public class GLSAPIServices {
	
	private static String APIUrl;
	private static String AppId;
	private static String AppToken;
	private static String UserId;
	private static String ProductId;
	private static String ENV=EnvParameters.ENV;
	public static String PearsonAdminUser;
	public static String PearsonAdminPassword;
	public static String SchoolAdminUser;
	public static String SchoolAdminPassword;
	public static String TeacherUser;
	public static String TeacherPassword;
	public static String StudentUser;
	public static String StudentPassword;
	protected static final Logger log = Logger.getLogger(GLSAPIServices.class);
	
	public static void chooseEnv() {
		
		if (ENV.equals("QA"))
			APIUrl=TestData.getData("QA_APIUrl");
		else if(ENV.equals("STAGE"))
			APIUrl=TestData.getData("STG_APIUrl");
		else if(ENV.equals("PROD"))
			APIUrl=TestData.getData("PROD_APIUrl");
		else
		{
			log.info("Invalid Environment, Please specify a valid enviroment for choosing the API");
		}
	}
	
	public static void chooseUserAccount() {
		
		if (ENV.equals("QA"))
		{
			PearsonAdminUser=TestData.getData("QA_PearsonAdminUser");
			PearsonAdminPassword=TestData.getData("QA_PearsonAdminPassword");
			SchoolAdminUser=TestData.getData("QA_SchoolAdminUser");
			SchoolAdminPassword=TestData.getData("QA_SchoolAdminPassword");
			TeacherUser=TestData.getData("QA_TeacherUser");
			TeacherPassword=TestData.getData("QA_TeacherPassword");
			StudentUser=TestData.getData("QA_StudentUser");
			StudentPassword=TestData.getData("QA_StudentPassword");
		}
		else if(ENV.equals("STAGE"))
		{
			PearsonAdminUser=TestData.getData("STG_PearsonAdminUser");
			PearsonAdminPassword=TestData.getData("STG_PearsonAdminPassword");
			SchoolAdminUser=TestData.getData("STG_SchoolAdminUser");
			SchoolAdminPassword=TestData.getData("STG_SchoolAdminPassword");
			TeacherUser=TestData.getData("STG_TeacherUser");
			TeacherPassword=TestData.getData("STG_TeacherPassword");
			StudentUser=TestData.getData("STG_StudentUser");
			StudentPassword=TestData.getData("STG_StudentPassword");
		}
		else if(ENV.equals("PROD"))
		{
			PearsonAdminUser=TestData.getData("PROD_PearsonAdminUser");
			PearsonAdminPassword=TestData.getData("PROD_PearsonAdminPassword");
			SchoolAdminUser=TestData.getData("PROD_SchoolAdminUser");
			SchoolAdminPassword=TestData.getData("PROD_SchoolAdminPassword");
			TeacherUser=TestData.getData("PROD_TeacherUser");
			TeacherPassword=TestData.getData("PROD_TeacherPassword");
			StudentUser=TestData.getData("PROD_StudentUser");
			StudentPassword=TestData.getData("PROD_StudentPassword");
		}
		else
		{
			log.info("Invalid Environment, Please specify a valid enviroment for choosing the users");
		}
		System.out.println(APIUrl);
	}
	
	public static Response app() {
		System.out.println("Append---->"+APIUrl+"/auth");
		return RESTServiceBase.getCall(APIUrl+"/auth");
		
		
	}

	
	/*public static void generateAppId()
	{
		Response response=app();
		log.info("iiii--->"+response);
		String json = response.asString();
		List<String> AppIds = JsonPath.with(json).get("id");
		AppId=AppIds.get(0);
		System.out.println("APP ID="+AppId);
			
	}*/
	
	public static void generateAppId()
	{
		Response response=app();
		System.out.println("response---->"+response);
		log.info("iiii--->"+response);
		/*String json = response.asString();
		List<String> AppIds = JsonPath.with(json).get("id");
		AppId=AppIds.get(0);
		System.out.println("APP ID="+AppId);*/
			
	}
	
	public static Response authenticate(String user, String pass)
	{
		
		JSONObject myJsonObject= new JSONObject();
        myJsonObject.put("username", user);
        myJsonObject.put("password", pass);
        Map<String, String> headers = new HashMap<String, String>();
		headers.put("appid", AppId);
		Response response = RESTServiceBase.postCallWithHeaderAndBodyParam(headers, myJsonObject, APIUrl+"/auth");
		String json = response.asString();
		AppToken=JsonPath.with(json).get("token");
		System.out.println(json);
        return response;

	}
	
	public static void getUserId() {
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("appid", AppId);
		headers.put("token", AppToken); 
		Response response = RESTServiceBase.getCallWithHeaderParam(headers, APIUrl+"/user");
		System.out.println("response code::" + response.getStatusCode());
		String json = response.asString();
		UserId=JsonPath.with(json).get("id");
		System.out.println("User ID="+UserId);
	}
	
	public static void createUser(String firstName, String lastName, String email, String password, String[] role)
	{
		JSONObject myJsonObject= new JSONObject();
        myJsonObject.put("firstName", firstName);
        myJsonObject.put("lastName", lastName);
        myJsonObject.put("email", email);
        myJsonObject.put("password", password);
        myJsonObject.put("roles", role);
        Map<String, String> headers = new HashMap<String, String>();
		headers.put("appid", AppId);
		headers.put("token", AppToken);
		Response response = RESTServiceBase.postCallWithHeaderAndBodyParam(headers, myJsonObject, APIUrl+"/user");
		System.out.println("response code::" + response.getStatusCode());
		String json = response.asString();
		System.out.println(json);
		UserId=JsonPath.with(json).get("id");
		System.out.println("User ID="+UserId);
	}
	
	public static Response getAllUsers() {

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("appid", AppId);
		headers.put("token", AppToken);
		Response response = RESTServiceBase.getCallWithHeaderParam(headers, APIUrl + "/user/all");
		log.info("Getting all User Details: " + response.asString());
		return response;
	}
	
	
	public static Response uploadProduct(String title, String description, String coverImageURL, String epubURL, String navigation, String[] layout) {
		
		JSONObject myJsonObject= new JSONObject();
        myJsonObject.put("title", title);
        myJsonObject.put("description", description);
        myJsonObject.put("coverImageURL", coverImageURL);
        myJsonObject.put("epubURL", epubURL);
        myJsonObject.put("allowedPageNavigation", navigation);
        myJsonObject.put("layout", layout);
        Map<String, String> headers = new HashMap<String, String>();
		headers.put("appid", AppId);
		headers.put("token", AppToken);
		Response response = RESTServiceBase.postCallWithHeaderAndBodyParam(headers, myJsonObject, APIUrl+"/product");
		String json = response.asString();
		ProductId=JsonPath.with(json).get("id");
		System.out.println("Product ID="+ProductId);
		return response;
		
	}
	
	public static void main(String arg[]) {
		
		
		
		chooseEnv();
		generateAppId();
		authenticate("test_pearson_admin@pearson.com","zdDoERwU1h7I");
		String[] role={"student"};
		createUser("automation","testuser","reader090220154456337@qa.com", "hudson102",role);
		getUserId();
	//	String[] layout={"portrait_single_page","landscape_single_page"};
	/*	uploadProduct("Sample Epub",
				"ISBN:9780409119923",
				"http://cdn.gloss.pearson-intl.com/resources/products/epubs/protected/SA/cti/pdf/ced673d0-5366-4723-98fa-0ddf2641cc4d-9780409119923.png",
				"http://cdn.gloss.pearson-intl.com/resources/products/epubs/protected/SA/cti/pdf/ced673d0-5366-4723-98fa-0ddf2641cc4d-9780409119923.pdf",
				"vertical",layout); */
		
	}

}
