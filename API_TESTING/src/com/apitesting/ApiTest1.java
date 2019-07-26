package com.apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest1 {

	@Test
	public void test() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification Request = RestAssured.given();
		
		Response response = Request.request(Method.GET,"/api/users/2");
		
		String responsebody = response.body().asString();
		
		System.out.println("Response Body => "+ responsebody);
		
	}
}
