package unittests;



import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	@Test(enabled=false)
	public void getPlayersPreetyPrint() {
		RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
	}
	@Test(enabled=false)
	public void getPlayersVar() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
	}
	@Test(enabled=false)
	public void getPlayersResponseCodeValidation() {
		RestAssured.get("https://reqres.in/api/users?page=2")
		. then()
		. statusCode(200);
		
	}
	@Test(enabled=false)
	public void getPlayersResponseCodeNegativeTest404() {
		RestAssured.get("https://reqres.in/api/users?page=2")
		. then()
		. statusCode(404);
		
	}
	@Test(enabled=true)
	public void getPlayersRequestLogs() {
		RestAssured.given()
		.log().all()
		. get("https://reqres.in/api/users?page=2")
		. then()
		. statusCode(200);
		
	}
	@Test(enabled=true)
	public void getPlayersResponseValidation() {
		RestAssured.given()
		.log().all()//Request Log
		.get("https://reqres.in/api/Id/12")
		.then()
		.log().all()//Response Log
		.statusCode(200)
		.and();
		//.body("id", equalTo("7"))
		//.body("firstName", equalTo("Michael"));
		//.body("DOB", equalTo("11/02/1992"));
	}
	
	@Test(enabled = true)
	public void getPlayersBaseUriPath() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users?page=2")
		.basePath("/id/7")
		.log().all()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}
}
