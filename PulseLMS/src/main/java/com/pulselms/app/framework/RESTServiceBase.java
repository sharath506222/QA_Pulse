package com.pulselms.app.framework;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import net.minidev.json.JSONObject;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class RESTServiceBase {
	
	public static Response getCall(String URL) {
		
		return get(URL);
	}
	
	public static Response getCallWithHeaderParam(Map<String, String> headers, String URL) {
		
		return given().relaxedHTTPSValidation()
        		.headers(headers)
				.contentType(getContentType()).request().when()
				.get(URL);
	}
	
	public static Response postCallWithFormParam(JSONObject jsonObject, String URL) {
		
		return given().relaxedHTTPSValidation().formParameters(jsonObject)
				.contentType(getContentType()).request().when()
				.post(URL);
	}
	
	public static Response postCallWithHeaderAndBodyParam(Map<String, String> headers, JSONObject jsonObject, String URL) {
		
		return given().relaxedHTTPSValidation()
				.headers(headers)
				.contentType(getContentType()).request().body(jsonObject).when()
				.post(URL);
	}
	
	public static Response PostCallWithHeaderParam(Map<String, String> headers, String URL) {
		
		return given().relaxedHTTPSValidation()
				.headers(headers)
				.contentType(getContentType()).request().when()
				.post(URL);
	}
	

	private static ContentType getContentType() {
		
	    if(EnvParameters.CONTENT_TYPE.equals("JSON"))
	    	return ContentType.JSON;
	    else if (EnvParameters.CONTENT_TYPE.equals("URLENC"))
	    	return ContentType.URLENC;
	    else if (EnvParameters.CONTENT_TYPE.equals("TEXT"))
	    	return ContentType.TEXT;
	    else if (EnvParameters.CONTENT_TYPE.equals("HTML"))
	    	return ContentType.HTML;
	    else if (EnvParameters.CONTENT_TYPE.equals("BINARY"))
	    	return ContentType.BINARY;
	    else if (EnvParameters.CONTENT_TYPE.equals("XML"))
	    	return ContentType.XML;
	    else
	    	throw new BrowserBotException("Not a valid Content Type, Please set the valid Content Type");
		
	}
}
