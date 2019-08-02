package com.apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTest2 {

	@Test
	public void TestPost(){
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/x-www-form-urlencoded");
		request.header("Accept","application/json");
		
		JSONObject json = new JSONObject();
		
		json.put("email", "anmol91@yopmail.com");
		json.put("password","12345678");
		
		request.body(json.toJSONString());
		
		Response res = request.post("https://instacei.com:4010/user/webLogin");

		int code = res.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}
	
	
}
