package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	@Test
	public void PutCall()
	{
		Logger logger =Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("=============Start of Put Call=============");
		
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		JsonMap.put("firstName","Raju");
		JsonMap.put("lastName","BD");
		JsonMap.put("salary", 25000);
		JsonMap.put("email", "raju@abc.com");
		
		RestAssured.given()
		.baseUri("http://18.212.17.202:8088")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(JsonMap)
		.when()
		.put("/employees/5")
		.then()
		.statusCode(200)
		.log()
		.body();
	}

}
