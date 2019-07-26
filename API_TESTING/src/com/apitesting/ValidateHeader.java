package com.apitesting;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHeader {

	@Test
	public void readHeader() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.request(Method.GET,"/api/users/2");
		
		Headers headerList = response.headers();
		
		for(Header header : headerList) {
			
			System.out.println("Key: "+header.getName()+" Value: "+header.getValue());
			
		}

		
	}
	
}
