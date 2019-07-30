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
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		
		json.put("id", "25");
		json.put("title", "Selenium Test");
		json.put("author", "Learn Automation");
		
		request.body(json.toJSONString());
		
		Response res = request.post("http://localhost:3000/posts/");

		int code = res.getStatusCode();
		
		Assert.assertEquals(code, 201);
	}
	
	
}
