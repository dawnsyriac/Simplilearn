package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void PostCall() {
		Logger logger =Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("=============Start of Post Call=============");
		
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		JsonMap.put("firstName","Raju");
		JsonMap.put("lastName","BDD");
		JsonMap.put("salary", 25000);
		JsonMap.put("email", "raju@abc.com");
		
		RestAssured.given()
		.baseUri("http://18.212.17.202:8088")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(JsonMap)
		.when()
		.post("/employees")
		.then()
		.statusCode(201)
		.body("firstName", Matchers.equalTo("Raju"))
		.body("salary", Matchers.equalTo(25000))
		.log()
		.body();
		
	}

}
