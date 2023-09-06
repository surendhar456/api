package StepDefinationss;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Pojo.addPlace;
import Pojo.location;
import Resources.TestDataBuild;
import Resources.Utlis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition extends Utlis {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	@Given("Add Place Payload")
	public void add_Place_Payload() throws FileNotFoundException {
TestDataBuild testDAta = new TestDataBuild ();
		
testDAta.addPlacePayload();
	
//	ReqspecBuilder
	
 

 
	
//		 res = given().spec(requestSpecification());
	 res =	 given().spec(RequestSpecification()).body(testDAta.addPlacePayload());
		
		
	}

	@When("user calls {string} with Post http request")
	public void user_calls_with_Post_http_request(String string) {
		    response = res.when().post("/maps/api/place/add/json").then().spec(resspec)
				.extract().response();

	}

	@Then("the API call got  success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body  is {string}")
	public void in_response_body_is(String key , String value) {
		 String resp =response.asString();
		 JsonPath js = new JsonPath(resp);
		 assertEquals(js.get(key).toString(), value);
		 
	}

	@Then("{string} in reponse body is {string}")
	public void in_reponse_body_is(String string, String string2) {
		
		
		
		
		
	}

}

	


