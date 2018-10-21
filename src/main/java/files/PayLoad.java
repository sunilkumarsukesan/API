package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoad {
	public static String addPlaceBody() {
		return "{\r\n" + 
				"    \"location\":{\r\n" + 
				"        \"lat\" : -38.383494,\r\n" + 
				"        \"lng\" : 33.427362\r\n" + 
				"    },\r\n" + 
				"    \"accuracy\":50,\r\n" + 
				"    \"name\":\"Frontline house\",\r\n" + 
				"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
				"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
				"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
				"    \"website\" : \"http://google.com\",\r\n" + 
				"    \"language\" : \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String addPlaceBodyXML() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
				"<root>\r\n" + 
				"    <location>\r\n" + 
				"        <lat>-38.383494</lat>\r\n" + 
				"        <lng>33.427362</lng>\r\n" + 
				"    </location>\r\n" + 
				"    <accuracy>50</accuracy>\r\n" + 
				"    <name>The Mens store</name>\r\n" + 
				"    <phone_number>(+91) 983 893 3937</phone_number>\r\n" + 
				"    <address>Anna Salai, Chennai</address>\r\n" + 
				"    <types>shoe park</types>\r\n" + 
				"    <types>kadai</types>\r\n" + 
				"    <website>http://google.com</website>\r\n" + 
				"    <language>tamil-IN</language>\r\n" + 
				"</root>\r\n" + 
				"";		
	}
	
	public static String generateStringFromResource(String path) throws IOException {
		return new String (Files.readAllBytes(Paths.get(path)));
	}
}