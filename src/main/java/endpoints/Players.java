package endpoints;


import utils.RestSpecifications;

public class Players extends RestSpecifications{
	
	private final String ENDPOINT = "/players";
	
	public void getUsers() {
		getCall(ENDPOINT);
	}
	

}
