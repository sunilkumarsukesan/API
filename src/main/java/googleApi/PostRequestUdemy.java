package googleApi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestUdemy {
	public static String place_id;
	Properties properties = new Properties();
	
	@BeforeTest
	public void getData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./src/main/java/files/env.properties");
		properties.load(fileInputStream);
	}

	@Test
	public void addPlace() {
		
		RestAssured.baseURI = properties.getProperty("BASEURL");
		RequestSpecification request = RestAssured.given();
		request.queryParam("key", "qaclick123");
		
		request.body(PayLoad.addPlaceBody());
		Response post = request.post(Resources.placePostReq());
		place_id = post.jsonPath().get("place_id");
		System.out.println("Place created successfully !\nPlace_id = "+ place_id);
	}

}
