package File;

public class payLoad {
	public static String addPlace() {
		return "{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Surendhar\",\r\n" + 
			"  \"phone_number\": \"(+91) 6382559102\",\r\n" + 
			"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"Enatha solla\",\r\n" + 
			"    \"shop\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"http://google.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + "}";
		

	}
	public static String coursePrice() {
return "{\r\n" + 
		"  \"dashboard\": {\r\n" + 
		"    \"purchaseAmount\": 1162,\r\n" + 
		"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
		"  },\r\n" + 
		"  \"courses\": [\r\n" + 
		"    {\r\n" + 
		"      \"title\": \"Selenium Python\",\r\n" + 
		"      \"price\": 50,\r\n" + 
		"      \"copies\": 6\r\n" + 
		"    },\r\n" + 
		"    {\r\n" + 
		"      \"title\": \"Cypress\",\r\n" + 
		"      \"price\": 40,\r\n" + 
		"      \"copies\": 4\r\n" + 
		"    },\r\n" + 
		"    {\r\n" + 
		"      \"title\": \"RPA\",\r\n" + 
		"      \"price\": 45,\r\n" + 
		"      \"copies\": 10\r\n" + 
		"    },{\r\n" + 
		"      \"title\": \"Appium\",\r\n" + 
		"      \"price\": 36,\r\n" + 
		"      \"copies\": 7\r\n" + 
		"    }\r\n" + 
		"  ]\r\n" + 
		"}";
	}
	public static String AddBook(String isbn, String aisle) {
	String payload =	"{\r\n" + 
		"\r\n" + 
		"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
		"\"isbn\":\""+isbn+"\",\r\n" + 
		"\"aisle\":\""+aisle+"\",\r\n" + 
		"\"author\":\"John foe\"\r\n" + 
		"}\r\n" + 
		" \r\n" + 
		"";
	return payload;

	}

}
