package Demo;

import Pojo.LoginResponse;
import Pojo.loginRequest;
import Pojo.orderDetail;
import Pojo.orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EcommerceApiTest {
	public static void main(String[] args) {
		
		
		
	RequestSpecification req =    new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
			setContentType(ContentType.JSON).build();
			
			 loginRequest  loginReque = new  loginRequest()
;		
//			 loginReque.setUserEmail("surendharmani0@gmail.com");
//			 loginReque.setUserPassword("771093123@Ss");
			 loginReque.setUserEmail("surendharmani0@gmail.com");
			 
			 loginReque.setUserPassword("771093123@Ss");
			 
	RequestSpecification reqLogin =given().spec(req).body( loginReque);
	
	
	LoginResponse loginResponse =reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
	
	
	System.out.println(loginResponse.getToken());
	String token = loginResponse.getToken();
	System.out.println(  loginResponse.getUserId());
	System.out.println(loginResponse.getMessage());
	String userId = loginResponse.getUserId();
	
	
	
//	Add a product
	RequestSpecification addProductBasereq =    new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			.addHeader("Authorization",token )
			.build();
RequestSpecification reqddProduct =given().log().all().spec(addProductBasereq).param("productName","Laptop").
	param("productAddedBy", userId	).param("productCategory", "fashion").param("productSubCategory","shirts")
	.param("productPrice", "11500").param("productDescription", "Addias Originals").
	param("productFor", "men").multiPart("productImage", new File("C:\\Users\\Ashok Raj\\Downloads\\pngtree-formal-shirt-free-png-and-psd-png-image_3159903.jpg"));
	
String response = reqddProduct.when().post("/api/ecom/product/add-product").
then().log().all().extract().response().
asString();
     
           JsonPath js = new JsonPath(response);
           String productId = js.get("productId");
           
//           js.get("message");
           
//          Creata a  order
          RequestSpecification   createOrder =new  RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization",token ).setContentType(ContentType.JSON).build();
           
          orderDetail orderDetails = new orderDetail();
          orderDetails.setCountry("India");
          orderDetails.setProductOrderedId(productId);
	
	List<orderDetail>  orderDetailList = new ArrayList();
	orderDetailList.add(orderDetails);
	
	
	orders orders = new orders();
	orders.setOrders(orderDetailList);
	
	
	
	RequestSpecification  createOrderReq =given().log().all().spec(createOrder).body(orders);
	
String responseaddOrder = 	createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
	
	System.out.println(responseaddOrder);
	
	
	
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
	
	}

}
