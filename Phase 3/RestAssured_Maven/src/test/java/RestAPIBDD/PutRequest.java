package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	@Test
	public void PutCall()
	{
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		JsonMap.put("name","Raju BDDD");
		JsonMap.put("salary", "25000");
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(JsonMap)
		.when()
		.put("/employees/17")
		.then()
		.statusCode(200)
		.body("name", Matchers.equalTo("Raju BDDD"))
		.body("salary", Matchers.equalTo("25000"))
		.log()
		.body();
	}

}
