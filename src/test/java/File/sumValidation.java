package File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumValidation {
	@Test
	public void sumofCourses() {
		int Sum = 0;
		JsonPath js = new JsonPath(payLoad.coursePrice());
		int count =	js.getInt("courses.size()");

		
		for (int i = 0; i < count; i++) {
			 int price  = js.get("courses["+i+"].price");
			 int copies  = js.get("courses["+i+"].copies");			
			 int amount =price* copies;
			System.out.println(amount);
			Sum = Sum +amount;
		}
		System.out.println(Sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(Sum,purchaseAmount);
	}

}
