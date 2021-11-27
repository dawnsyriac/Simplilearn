package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqWithParams {
@Test	
	public void GetCall() {
	RestAssured.baseURI="http://localhost:7000";
	RequestSpecification request = RestAssured.given();
	Response response=request.param("id","4").get("/employees");
	String responseBody = response.getBody().asString();
	int ResCode=response.getStatusCode();
	System.out.println(responseBody);
	Assert.assertEquals(ResCode,200);
	}

}
