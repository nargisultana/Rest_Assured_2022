package misc;

import java.io.InputStream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathExample {
	
JsonPath jsonPath;
	
	@BeforeMethod
	public void init() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.json");
		jsonPath = new JsonPath(inputStream);
	}
	

	@Test
	
	public void jsonPathMap() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
		JsonPath jsonPath = new JsonPath(inputStream);
		System.out.println(jsonPath.getMap("items"));
	}

     @Test
	
	public void jsonPathGetList() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
		JsonPath jsonPath = new JsonPath(inputStream);
		System.out.println(jsonPath.getList("items.item"));
	}
	
     @Test
 	
 	public void jsonPathGetDouble() {
 		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
 		JsonPath jsonPath = new JsonPath(inputStream);
 		System.out.println(jsonPath.getDouble("items.item[0].ppu"));
 	}
     
     @Test
  	
  	public void jsonPathWildCard() {
  		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
  		JsonPath jsonPath = new JsonPath(inputStream);
  		//System.out.println(jsonPath.getList("items..ppu"));
  	}
  	
 	

}
