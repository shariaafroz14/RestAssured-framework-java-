package com.testAutomation.Apitesting.Utils;


	
	
	import java.io.PrintWriter;
	import java.io.StringWriter;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.restassured.RestAssured;

	public class BaseTest {
		
		protected static final Logger logger = LogManager.getLogger(Base.class);
		
		@BeforeMethod
		public void beforeMethod() {
			//RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result) {
			if(result.getStatus() == ITestResult.FAILURE) {
				Throwable t = result.getThrowable();
				StringWriter error = new StringWriter();
				t.printStackTrace(new PrintWriter(error));
				logger.info(error.toString());
			}
			
		}
		
	}


