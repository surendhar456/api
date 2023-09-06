package File;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
@Test(dataProvider="Booksdata")
public void addBook(String isbn ,String aisle) {
RestAssured.baseURI = "http://216.10.245.166";
String response =given().log().all().header("Content-Type","application/json").body(payLoad.AddBook("isbt","228")).when().post("Library/Addbook.php")
.then().log().all().assertThat().statusCode(200).extract().response().asString();
JsonPath js =ReusableMethod.rawToJson(response);
String id  = js.get("ID");
System.out.println(id);
//Delete book



}
@DataProvider(name="Booksdata")
public Object [][] getData() {
//create an multi dimensional array
	
//	array collection of elements multi dimensional arrays =collection of arraya
	return new Object [][] { {"ghs","1212"},{"bhsd","484"},{"hai","1121"} };
}

}
