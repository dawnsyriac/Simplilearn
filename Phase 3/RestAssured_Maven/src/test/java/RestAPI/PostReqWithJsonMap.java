package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReqWithJsonMap {
			@Test
		public void PostCall() {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();	
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		
		JsonMap.put("name","Raju");
		JsonMap.put("salary", "2000");
		Response response=request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(JsonMap)
								.post("/employees/create");
								
		String ResponseBody =response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode,201);

	}

}
