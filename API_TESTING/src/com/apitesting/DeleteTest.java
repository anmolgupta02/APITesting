package com.apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteTest {

	@Test
	public void TestPost(){
		
		RequestSpecification request = RestAssured.given();
		
		
		
		Response res = request.delete("http://localhost:3000/posts/25");

		int code = res.getStatusCode();
		
		Assert.assertEquals(code, 200);
	}
	
	
}
