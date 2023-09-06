package Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.addPlace;
import Pojo.location;

public class serializeTest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		addPlace p = new addPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 0");
		p.setLanguage("French-IN");
		p.setWebsite("http://google.com");
		p.setName("surendhar");
		p.setPhone_number("(+91) 983 893 3937")
		;
		List<String> myList = new ArrayList<String>();
		
		myList.add("shoe park");
		myList.add("shop");
		
		
		
		
		p.setTypes(myList);
		location l = new location ()
;
	l.setLat( -38.383494);
	l.setLng(33.427362);
		p.setLocation(l);
		
	Response res =	given().queryParam("key ", "qaclick123").log().all().body(p).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
.extract().response();
	
String responseString =res.asString();
System.out.println(responseString);
	
	}
	

}
