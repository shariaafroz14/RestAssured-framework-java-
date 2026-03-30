package com.testAutomation.Apitesting.tests;

public class FileUpload {
	
	public class FileUpload {

		@Test
		public void uploadFile() {
			RestAssured
				.given()
					.multiPart(new File(
					"E:\\2023RestAssuredFullCourse\\RestAssuredTutorials\\RestAssuredAPITestingTutorial\\src\\test\\resources\\putapirequestbody.txt"))
					.baseUri("http://postman-echo.com/post")
				.when()
					.post()
				.then()
					.assertThat()
					.statusCode(200);
		}

	}

}
