package unittests;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Jhon");
		map.put("lastName", "Robert");
		map.put("DOB", "12/09/1988");
		map.put("countryCode", 2);
		
		RestAssured.given()
		.baseUri("https://reqres.in/api/users?page=2")
		.basePath("/players/2")
		.contentType(ContentType.JSON)
		.body(map)
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
	}

}
