package googleApi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	Properties properties = new Properties();
	
	@BeforeTest
	public void getData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./src/main/java/files/env.properties");
		properties.load(fileInputStream);
	}

	@Test
	public void deletePlace() {
		RestAssured.baseURI= properties.getProperty("BASEURL");
		RequestSpecification request = RestAssured.given();
		
		request.queryParam("key", "qaclick123");
		request.body("{\r\n" + 
				"    \"place_id\":\""+ PostRequestUdemy.place_id + "\"\r\n" + 
				"}\r\n" + 
				"");
		Response post = request.post(Resources.placeDeletePost());
		assertEquals(post.jsonPath().get("status"), "OK");
		System.out.println(post.getBody().asString());
		
	}

}
