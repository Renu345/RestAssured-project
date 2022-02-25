package Sample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Request {
	
@Test
	public void deleterequest() {
	//BaseURI
	RestAssured.baseURI="https://petstore.swagger.io/v2";
	RequestSpecification request = RestAssured.given();
	
	Response response = request.request(Method.DELETE,"/store/order/1");
	
	System.out.println("The response code is"+response);

	String responseBody = response.getBody().asPrettyString();
	System.out.println("Response body is:"+responseBody);
	
	//Status code validation
	int statusCode1 = response.getStatusCode();
	System.out.println("Status code is:"+statusCode1);

	Assert.assertEquals(statusCode1,404);
	
	/*RestAssured.baseURI = baseUrl;
	  RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
		         .header("Content-Type", "application/json");
	 
	  //Calling the Delete API with request body
	  Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");

	  //Fetching the response code from the request and validating the same
	  System.out.println("The response code is - " +res.getStatusCode());
    Assert.assertEquals(res.getStatusCode(),204);*/
}
}
