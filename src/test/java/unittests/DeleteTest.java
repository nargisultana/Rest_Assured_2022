package unittests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteTest {
	
	@Test
	
	public void deleteTest() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users?page=2")
		.basePath("/id/2")
		.log().all()
		.then()
		.log().all()
		.statusCode(200);
	}
	
	
	}


