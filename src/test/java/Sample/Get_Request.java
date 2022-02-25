package Sample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request {

	@Test
	public  void getrequest() {
		
		//BaseURI
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		//Request object
		RequestSpecification request = RestAssured.given();
		
		//Response object
		Response response = request.request(Method.GET,"/store/order/1");
		
		//Printing the response in console window
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is:"+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
	
		Assert.assertEquals(statusCode,200);
		
		//Status line validation
		String statusLine = response.getStatusLine();
		System.out.println("Status line is"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

	}

}
