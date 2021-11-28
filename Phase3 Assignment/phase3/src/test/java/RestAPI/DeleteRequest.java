package RestAPI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {
	@Test
	public void DeleteCall()
	{
		Logger logger =Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("=============Start of Delete Call=============");
		
		RestAssured.given()
		.baseUri("http://18.212.17.202:8088")
		.when()
		.delete("/employees/5")
		.then()
		.statusCode(200)
		.log()
		.all();
		
	}

}
