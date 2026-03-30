package com.testAutomation.Apitesting.tests;

import java.io.File;

import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apitesing.listener.RestAssuredListener;
import com.jayway.jsonpath.JsonPath;
import com.testAutomation.Apitesting.Utils.BaseTest;
import com.testAutomation.Apitesting.Utils.FileNameConstant.FileNameConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

@Epic("Epic-01")
@Feature("Create Update Delete Booking")

public class AllureReportGenration extends BaseTest {
	
	private static final LogManager logger = LogManager.getLogManager();
	
	@Story("Story 1")
	@Test(description = "end to end api testing")
	@Description("end to end testing")
	@Severity(SeverityLevel.CRITICAL)
	public void e2eAPIRequest() {
		((Logger) logger).info("e2eAPIRequest test execution started...");
	
 {

	

				try {
					String postAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.POST_API_REQUEST_BODY),
							"UTF-8");
					String tokenAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.TOKEN_API_REQUEST_BODY),
							"UTF-8");
					String putAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.PUT_API_REQUEST_BODY),
							"UTF-8");
					String patchAPIRequestBody = FileUtils.readFileToString(new File(FileNameConstants.PATCH_API_REQUEST_BODY),
							"UTF-8");

					// post api call
					Response response = RestAssured
							.given().filter(new AllureRestAssured())
								.filter(new RestAssuredListener())
								.contentType(ContentType.JSON).body(postAPIRequestBody)
								.baseUri("https://restful-booker.herokuapp.com/booking")
							.when()
								.post()
							.then()
								.assertThat()
								.statusCode(200)
							.extract()
								.response();

					JSONArray jsonArray = JsonPath.read(response.body().asString(), "$.booking..firstname");
					String firstName = (String) jsonArray.get(0);

					Assert.assertEquals(firstName, "api testing");

					int bookingId = JsonPath.read(response.body().asString(), "$.bookingid");
					System.out.println("Booking Id : " + bookingId);

					// get api call
					RestAssured
						.given().filter(new AllureRestAssured())
							.filter(new RestAssuredListener())
							.contentType(ContentType.JSON)
							.baseUri("https://restful-booker.herokuapp.com/booking")
						.when()
							.get("/{bookingId}", bookingId)
						.then()
							.assertThat()
							.statusCode(200);

					// token generation
					Response tokenAPIResponse = RestAssured
							.given().filter(new AllureRestAssured())
								.filter(new RestAssuredListener())
								.contentType(ContentType.JSON)
								.body(tokenAPIRequestBody)
								.baseUri("https://restful-booker.herokuapp.com/auth")
							.when()
								.post()
							.then()
								.assertThat()
								.statusCode(200)
							.extract()
								.response();

					String token = JsonPath.read(tokenAPIResponse.body().asString(), "$.token");
					System.out.println("Token Id : " + token);

					// put api call
					
					// delete api call
					RestAssured
					.given().filter(new AllureRestAssured())
						.filter(new RestAssuredListener())
						.contentType(ContentType.JSON)
						.header("Cookie", "token=" + token)
						.baseUri("https://restful-booker.herokuapp.com/booking")
					.when()
						.delete("/{bookingId}", bookingId)
					.then()
						.assertThat()
						.statusCode(201);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Logger) logger).info("e2eAPIRequest test execution ended...");

			}

	}
}