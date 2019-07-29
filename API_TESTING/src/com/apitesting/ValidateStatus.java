package com.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.jxc.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateStatus {
	
	public utils.ConfigReader cr;
	
	@Test
	public void validateCorrectStatus() throws Exception {
		
		cr = new utils.ConfigReader();
		
		RestAssured.baseURI = cr.readBaseUrl();
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, cr.readApi());
		
		int statusCodeActual = response.getStatusCode();
		
		int StatusCodeExpeted = 200;
		
		Assert.assertEquals(statusCodeActual, StatusCodeExpeted);
	}
	
}
