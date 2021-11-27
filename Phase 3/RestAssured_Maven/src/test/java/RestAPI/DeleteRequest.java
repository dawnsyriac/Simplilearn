package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
@Test
	public void DeleteCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();	
		Response response=request.delete("/employees/3");
								
		String ResponseBody =response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode,200);
}
}