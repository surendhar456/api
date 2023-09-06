package File;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
public static void main(String[] args) {
	JsonPath js = new JsonPath(payLoad.coursePrice());
//	print no of courses returned in ApI
	
int count =	js.getInt("courses.size()");
	System.out.println(count);
	
//	Print Puurchase amount 
	
int totalAmount = js.getInt("dashboard.purchaseAmount");	

System.out.println(totalAmount);

//Print the title of the course 
String TitleFirstCourse = js.getString("courses[2].title");
System.out.println(TitleFirstCourse);

//Print all  courses in respective prices
//when it is dynamic
for (int i = 0; i < count; i++) {
	 String courseTitle  = js.get("courses["+i+"].title");
System.out.println(js.get("courses["+i+"].price").toString());
	 
System.out.println(courseTitle);
}

//Print no of copies sold by RPA Course
for (int i = 0; i < count; i++) {
	String Title = js.get("courses["+i+"].title");
	if (Title.equalsIgnoreCase("RPA")) {
		int copies  = js.get("courses["+i+"].copies");
		System.out.println(copies);
		break;
	}
//	Verify if Sum of all Course prices matches with Purchase Amount
}


}
}
