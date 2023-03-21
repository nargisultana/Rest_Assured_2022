package endpoints;

import utils.RestSpecifications;

public class Countries extends RestSpecifications{

	private final String ENDPOINT = "/countries";
	private final String fileName = "country.json";
	
	public void getCountries() {
		getCall(ENDPOINT);
	}
	
	public void getEachCountry(int countryId) {
		getCall(ENDPOINT + "/" + countryId);
	}
	
	public void postACountry() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsJson();
		setBasicAuth("user", "pass");
		postCall(ENDPOINT);
	}

	
	}

	
		



