package googleApi;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void testPostRequest() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification request = RestAssured.given();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("FirstName", "Virend"); 
		jsonObject.put("LastName", "Sing");
		jsonObject.put("UserName", "simpleser001");
		jsonObject.put("Password", "password1");
		jsonObject.put("Email",  "somuser@gmail.com");
		
		request.header("Content-Type","application/json");
		request.body(jsonObject.toJSONString());
		Response post = request.post("/customer/register");
		
		Assert.assertEquals(post.getStatusCode(), 200);
		System.out.println(""+post.getBody().asString());
		
	}

}
