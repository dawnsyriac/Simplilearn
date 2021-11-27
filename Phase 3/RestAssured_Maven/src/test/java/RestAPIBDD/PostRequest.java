package RestAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void PostCall() {
		Map<String,Object>JsonMap=new HashMap<String,Object>();
		JsonMap.put("name","Raju BDD");
		JsonMap.put("salary", "25000");
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(JsonMap)
		.when()
		.post("/employees/create")
		.then()
		.statusCode(201)
		.body("name", Matchers.equalTo("Raju BDD"))
		.body("salary", Matchers.equalTo("25000"))
		.log()
		.body();
		
	}

	private Object baseURI(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
