package RestAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReqWithJSONFile {
	@Test
	public void PostCall() throws IOException {
		RestAssured.baseURI="http://localhost:7000";
		RequestSpecification request = RestAssured.given();	
		String Body=readJSON("data.json");
		Response response=request.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(Body)
								.post("/employees/create");
								
		String ResponseBody =response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode=response.getStatusCode();
		Assert.assertEquals(ResCode,201);

	}
public String readJSON(String FilePath) throws IOException {
	return new String(Files.readAllBytes(Paths.get(FilePath)));
}
}
