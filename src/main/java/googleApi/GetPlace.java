package googleApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPlace {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		RequestSpecification request = RestAssured.given();
		request.log().all();
		request.param("location", "-33.8670522,151.1957362")
		.param("radius", "1500")
		.param("key", "AIzaSyBx2PWCw84Dqh02xT7fjw0no6GZOu_wk6I");
		
		Response response = request.get("/maps/api/place/nearbysearch/json");
		response.then().log().all();
		//System.out.println(response.getBody().asString());
		for(int i = 0;i<20;i++)
		{
		System.out.println(""+response.jsonPath().get("results["+i+"].name"));
		}
		
	}

}
