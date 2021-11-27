package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void PutCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();	
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		
		JsonMap.put("name","Mokshaa");
		JsonMap.put("salary", "20000");
		Response response=request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(JsonMap)
								.put("/employees/4");
								
		String ResponseBody =response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode,200);

	}
}
