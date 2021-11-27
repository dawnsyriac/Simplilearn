package RestAPI;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndtoEndTest {

	@Test
	public void GetCall() {
		String ResponseId;
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification GetRequest = RestAssured.given();
		Response response=GetRequest.get("/employees");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		RequestSpecification PostRequest = RestAssured.given();
		JSONObject jobj =new JSONObject();
		jobj.put("name","Ro");
		jobj.put("salary", "2000");
		Response PostResponse=PostRequest.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(jobj.toString())
								.post("/employees/create");
								
		String ResponseBody =PostResponse.getBody().asString();
		System.out.println(ResponseBody);
		
		JsonPath jpath =PostResponse.jsonPath();
		ResponseId=jpath.get("id").toString();
		System.out.println("Id is "+ResponseId);
		
		
		RequestSpecification PutRequest = RestAssured.given();
		jobj.put("name","Rohit1");
		jobj.put("salary", "2000");
		Response PutResponse=PutRequest.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(jobj.toString())
								.put("/employees/"+ResponseId);
								
		ResponseBody =PutResponse.getBody().asString();
		System.out.println(ResponseBody);
		
		
		
		RequestSpecification DeleteRequest = RestAssured.given();	
		Response DeleteResponse=DeleteRequest.delete("/employees/"+ResponseId);
		ResponseBody =DeleteResponse.getBody().asString();
		System.out.println(ResponseBody);
	}
	
}
