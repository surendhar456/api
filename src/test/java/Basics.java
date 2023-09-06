import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.xmlbeans.impl.store.Path;
import org.testng.Assert;

import File.ReusableMethod;
import File.payLoad;
public class Basics {
	public static void main(String[] args) throws IOException {
//		content of the file to string-->content of the file convert into Byte --->Byte data to string 
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").headers("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Ashok Raj\\Downloads\\addPlace.json")))
				)
		.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
		.body("scope",equalTo( "APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
//		update Place 
		String newAddress = "summer walk, Usa";
		given().log().all().queryParam("key ","qaclick123").headers("Content-Type","application/json").body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").
		when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
//		get place 
		String getPlaceResponse = 
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).
		when().get("maps/api/place/get/json").then().log().all().statusCode(200).extract().response().asString();
		JsonPath js1 = ReusableMethod.rawToJson(getPlaceResponse);
//		JsonPath js1 = new JsonPath(getPlaceResponse);
		String  actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		//junit and TestnG
		Assert.assertEquals(actualAddress, newAddress);
	}
}