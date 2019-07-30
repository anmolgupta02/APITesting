package com.apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutTest {

	@Test
	public void TestPost(){
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-type","application/json");
		
		
		JSONObject json = new JSONObject();
		
		json.put("id", "90");
		json.put("title", "Test Put API again");
		json.put("body", "Result body again");
		
		request.body(json.toJSONString());
		
		Response res = request.put("http://localhost:3000/posts/90");

		int code = res.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}
	
	
}
