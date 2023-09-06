package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utlis {
	RequestSpecification req ;
	public    RequestSpecification RequestSpecification() throws FileNotFoundException {
	PrintStream	log = new PrintStream(new FileOutputStream("logging.txt")) ;
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				
				.setContentType(ContentType.JSON).build();
		 return RequestSpecification();
	}
	public static  Properties getGobalvalue(String key ) throws IOException {
	Properties prop = new Properties();
	
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Ashok Raj\\Selenium\\RestAssured\\src\\test\\java\\Resources\\global.properties");
	prop.load(fis);
	prop.getProperty(key);
	return prop;
}
}
