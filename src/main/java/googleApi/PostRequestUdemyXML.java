package googleApi;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import files.Resources;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestUdemyXML {
	public static String place_id;
	Properties properties = new Properties();
	
	@BeforeTest
	public void getData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./src/main/java/files/env.properties");
		properties.load(fileInputStream);
	}

	@Test
	public void addPlace() throws IOException {
		
		RestAssured.baseURI = properties.getProperty("BASEURL");
		RequestSpecification request = RestAssured.given();
		request.queryParam("key", "qaclick123");
		
		request.body(PayLoad.generateStringFromResource("./src/main/java/files/AddBodyXML.xml"));
		Response post = request.post(Resources.placePostReqXML());
		assertEquals(200,post.getStatusCode());
		System.out.println(post.getBody().asString());
		XmlPath xmlPath = post.xmlPath();
		System.out.println(""+xmlPath.get("response.place_id"));
	}

}
