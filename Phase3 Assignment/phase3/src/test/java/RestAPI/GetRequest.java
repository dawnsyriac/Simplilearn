package RestAPI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void GetCall() {
		Logger logger =Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("=============Start of Get Call=============");
		RestAssured.given()
		.baseUri("http://18.212.17.202:8088")
		//.queryParam("id","1")
		.when()
		.get("/employees")
		.then()
		.body("[0].id", Matchers.equalTo(1))
		.body("[0].firstName", Matchers.equalTo("saurabh"))
		.body("[0].lastName", Matchers.equalTo("oza"))
		.body("[0].salary", Matchers.equalTo(1000))
		.body("[0].email", Matchers.equalTo("saurabh@abc.com"))
		.statusCode(200)
		.log()
		.body();
	}

}
