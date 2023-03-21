package functionaltests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Countries;

public class GetCountriesTest {
	
	Countries countries;
	
	@BeforeMethod
	
	public void init() {
		countries = new Countries();
		countries.init();
	}
	@Test(enabled=false)
	public void getCountries() {
		countries.getCountries();
		countries.validateStatusCode(200);
	}
	@Test(enabled = false)
	public void getCountryById() {
		countries.getEachCountry(30);
		countries.validateStatusCode(200);
		countries.validatePayloadObject("firstName", "Michael");
	    countries.validatePayloadObject("id", 7);
		countries.validate_w_JsonPath("id", 7);
	}
	
	@Test(enabled=true)
	public void responValidation() {
		countries.getEachCountry(30);
		System.out.println(countries.getResponse().getBody().jsonPath().getString("iccRank"));
	}
}
