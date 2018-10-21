package googleApi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://restapi.demoqa.com"; 	
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.get("/utilities/weather/city/Hyderabad");
		//String Response = response.getBody().asString();
		//System.out.println(Response);
		JsonPath jsonPath = response.jsonPath();
		System.out.println(""+jsonPath.get("Temperature"));
	}

}
