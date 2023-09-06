package Demo;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pojo.Api;
import Pojo.WebAutomation;
import Pojo.getCourse;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class oauthTest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		String[] courseTitles = {"Selenum WebDriver Java","Cypress","Protactor"};
//		ChromeOptions opt = new  ChromeOptions();
//		opt.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashok Raj\\Selenium\\RestAssured\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?Scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=	692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=verifydss");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("srinath19830.com");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//	Thread.sleep(4000);
	
//		String currentUrl = driver.getCurrentUrl();
		String url = "https://www.googleapis.com/oauth2/v4/token?code=4%2F0AZEOvhXO7_3EyK8vkyixY8qUPjTV3L6GXMqr0x5rQf3gHvFLBdGh19sw4_AISALLOFkUuQ&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&client_secret=erZOWM9g3UtwNRj340YYaK_W&redirect_uri=https://rahulshettyacademy.com/getCourse.php&grant_type=authorization_code";
		
		String partialcodeurl = url.split("code=")[1];
		String code = partialcodeurl.split("&scope")[0];
		System.out.println(code);
		
//		 for special character does not accept so we encode
		String accessTokenresponse = given().urlEncodingEnabled(false).
		given().queryParams("code",code).
		given().queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		given().queryParams("client_Secret","erZOWM9g3UtwNRj340YYaK_W").
		given().queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php").
		given().queryParams("grant_Type","authorization_code").when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		
		JsonPath js2 = new JsonPath(accessTokenresponse);
		String accesToken = js2.getString("access_token");
		System.out.println(accesToken);
//		Deserialization
	getCourse  gc =	given().queryParam("accessToken",accesToken).expect().defaultParser(Parser.JSON).
		when().get("https://rahulshettyacademy.com/getCourse.php").as(getCourse.class);
//	System.out.println(Response);
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getInstructor());
	
	
	System.out.println(gc.getCourses()
.getApi().get(1).getCourseTitle());
//	without using index we have to use the 
	List<Api> apiCourses = gc.getCourses().getApi();
	for (int i = 0; i < apiCourses.size(); i++) {
	if	(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"));
	{
		
System.out.println(apiCourses.get(i).getPrice()) ;
	}
ArrayList<String >	a = new ArrayList<String>();
List<WebAutomation> w = gc.getCourses().getWebAutomation();

for (int j = 0; j < w.size(); j++) {

w.get(j).getCourseTitle()
;
a.add(w.get(j).getCourseTitle());


}
List<String> expectedList = Arrays.asList(courseTitles);
a.equals(expectedList);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
