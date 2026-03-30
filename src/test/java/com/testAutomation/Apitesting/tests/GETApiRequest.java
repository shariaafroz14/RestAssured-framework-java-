package com.testAutomation.Apitesting.tests;


import java.io.IOException;
import java.net.CacheResponse;
import java.net.ResponseCache;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class GETApiRequest {
	@Test
	
	
	public void getAllBooking() throws IOException {
		
		
		
		
			RestAssured
			
			 .given()
			     .contentType(ContentType.JSON)
			     .baseUri("https://restful-booker.herokuapp.com/booking")
			     .when()
			         .get()
			         .then()
			         .assertThat()
			         .statusCode(200)
			         .statusLine("HTTP/1.1 200 OK")
			.header( "Content-Type","application/json; charset=utf-8")
			.extract()
			.response();

	

			
		
			      
		

	
	
	}
}



