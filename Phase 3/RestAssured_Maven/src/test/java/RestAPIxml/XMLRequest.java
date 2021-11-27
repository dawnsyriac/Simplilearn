package RestAPIxml;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLRequest {
	@Test
	public void GetCall()
	{
		RestAssured.given()
		.baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log()
		.body();
	}
	@Test
	public void Validate()
	{
		Response response=RestAssured.given()
				.baseUri("https://chercher.tech/sample/api/books.xml")
				.when()
				.get();
		String Books= response.then().extract().xmlPath().getString("bookstore.book.title");
		System.out.println(Books);
	}
	@Test
	public void test1()
	{
		Response response=RestAssured.given()
				.baseUri("https://chercher.tech/sample/api/books.xml")
				.when()
				.get();
		NodeChildrenImpl Books1=response.then().extract().path("bookstore.book.title");
		String Act =Books1.get(0).toString();
		String Exp="The Nightingale";
		System.out.println("Book Name is "+Act);
		Assert.assertEquals(Act, Exp);
		
	}
	@Test
	public void test2()
	{
		Response response=RestAssured.given()
				.baseUri("https://chercher.tech/sample/api/books.xml")
				.when()
				.get();
		NodeChildrenImpl Books1=response.then().extract().path("bookstore.book.title");
		String Act =Books1.get(1).toString();
		String Exp="Harry Potter";
		System.out.println("Book Name is "+Act);
		Assert.assertEquals(Act, Exp);
		
	}

}
