package TestNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleRequest {
	@Test
	
	public void getrequest() {
		
		RestAssured.baseURI= "https://awshay.fusionapi.traveltek.net/0.9/interface.pl";
		RestAssured.basePath= "xml=<?xml version=\"1.0\"?>\r\n" + 
				"<request><auth username=\"suppliertest\" password=\"ev17uh81\" />\r\n" + 
				"<method action=\"simplesearch\" sitename=\"supplier.site.traveltek.net\" currency=\"GBP\" status=\"Test\" type=\"flight\">\r\n" + 
				"<searchdetail type=\"flight\" depair=\"LHR\" destair=\"BCN\" adults=\"2\" children=\"0\" infants=\"0\" depdate=\"2021-03-20\" retdate=\"2021-03-27\" sid=\"37740\" resultkey=\"default\" />\r\n" + 
				"</method>\r\n" + 
				"</request>";
		Response response = RestAssured.given().when().get().then().extract().response();
		String body = response.getBody().asString();
		System.out.println("test");
		System.out.println(body);
		int StatusCode = response.getStatusCode();
		System.out.println("Statuscode = "+StatusCode);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(StatusCode, 200);
		soft.assertAll();
		
	}

}
