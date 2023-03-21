package unittests;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {
	
	@Test(enabled=false)
	public void postTestStringBody() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body("{\"id\": 1, \"email\": \"george.bluth@reqres.in\",\"first_name\": \"George\", \"last_name\": \"Bluth\",\"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"}")
		.basePath("/players")					
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		

	}
	
	@Test(enabled=false)
	public void postTestStringBody400() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body("{\"id\": 1/, \"email\": \"george.bluth@reqres.in\",\"first_name\": \"George\", \"last_name\": \"Bluth\",\"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"}")
		.basePath("/players")					
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
		

	}
	@Test(enabled=false)
	public void postTestFileBody500() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/player.json"))
		.basePath("/players")					
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
	}
		@Test(enabled=true)
		public void postTestInputStreamBody() {
			RestAssured.given()
			.baseUri("https://reqres.in/api")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("players2.json"))
			.basePath("/players")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		}
		@Test(enabled = false)
		public void postTestByteBody() {
			try {
				RestAssured.given()
				.baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON)
				.body(getClass().getClassLoader().getResourceAsStream("players2.json").readAllBytes())
				.basePath("/players")
				.when()
				.log().all()
				.post()
				.then()
				.log().all()
				.statusCode(201);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		@Test(enabled = false)
		public void postTestMapBody() {
			Map<String, Object> map = new HashMap<>();
			map.put("firstName", "Aman");
			map.put("lastName", "Hasan");
			map.put("DOB", "01/05/1998");
			map.put("countryCode", 77);
			RestAssured.given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(map)
			.basePath("/players")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		}
}	


