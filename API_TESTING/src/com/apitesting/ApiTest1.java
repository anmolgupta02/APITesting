package com.apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class ApiTest1 {
	
	ConfigReader cr;
	
	@Test
	public void test() throws Exception {
		
		cr = new ConfigReader();
		
		RestAssured.baseURI = cr.readBaseUrl();
		
		RequestSpecification Request = RestAssured.given();
		
		Response response = Request.request(Method.GET, cr.readApi());
		
		String responsebody = response.body().asString();
		
		System.out.println("Response Body => "+ responsebody);
		
		Long time = response.getTime();
		
		System.out.println("TIme taken => " +time+" ms");
		
	}

}
