package com.testAutomation.Apitesting.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Cookies {
		
		

		  @Test
		  public void cookiesAPITest() {
			  
			  RestAssured
			  		.given()
			  			.cookies(RestAPIHelper.getCookiesData());
			  			.baseUri("http://postman-echo.com/cookies/set")
			  			.log().all()
			  		.when()
			  			.get()
			  		.then()
			  			.assertThat()
			  			.statusCode(200);
			  
		  }

		 
		  }
		}


