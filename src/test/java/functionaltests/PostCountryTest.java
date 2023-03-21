package functionaltests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Countries;

public class PostCountryTest {
	
	Countries countries;
	
	@BeforeMethod
	public void init() {
		countries = new Countries();
		countries.init();
	}
	
	@Test
	public void postACountry() {
		countries.postACountry();
		countries.validateStatusCode(201);
		countries.validatePayloadObject("userName", "Michael");
		countries.validate_w_JsonPath("email", "michael.lawson@reqres.in");
	}

}
