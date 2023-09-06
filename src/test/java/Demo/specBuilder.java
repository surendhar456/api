package Demo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


import Pojo.addPlace;
import Pojo.location;

public class specBuilder {
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
	
//	ReqspecBuilder
	
ResponseSpecification resspec =	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

 	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
	.setContentType(ContentType.JSON).build();
	
//		Response res = given().spec(req);
	RequestSpecification res =	 given().spec(req).body(p);
	
			Response    response = res.when().post("/maps/api/place/add/json").then().spec(resspec)
.extract().response();
//	
String responseString =response.asString();
System.out.println(responseString);
	
	}
	

}
