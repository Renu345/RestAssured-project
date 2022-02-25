package Sample;

import org.json.simple.JSONObject;
import org.junit.Assert;
//import org.junit.Assert;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class Post_Request {

	@SuppressWarnings("unchecked")
	public  void postrequest() {
		
		//BaseURI
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		//Request object
		RequestSpecification request12 = RestAssured.given();
		
		//POST Body
           
		JSONObject requestObject = new JSONObject();
		
		/*requestObject.put("userName", "Vasanthi");
		requestObject.put("password", "Vasanthi@98");*/

		
		requestObject.put("id", "1");
		requestObject.put("petId","2");
		requestObject.put("quantity","3");
		requestObject.put("shipDate","2022-02-24T09:44:56.472Z");
		requestObject.put("status","placed");
		requestObject.put("complete","true");

		request12.header("Content-Type","application/json");
		
		request12.body(requestObject.toJSONString()); //attach above data to the request
		
		//Response object
		Response response = request12.request(Method.POST,"/store/order");
		
		System.out.println(response);
		
		
		
		
		//Printing the response in console window
		String responseBody = response.getBody().asPrettyString();
		System.out.println("Response body is:"+responseBody);
		
		//Status code validation
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is:"+statusCode);
	
		Assert.assertEquals(statusCode,200);
		
		/*int statusCode1 = response.getStatusCode();
		System.out.println("Status code is:"+statusCode1);
	
		Assert.assertEquals(statusCode1,201);*/
		
		/*String sucessCode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(sucessCode, "successful operation");*/
		
		
		


	}
}
