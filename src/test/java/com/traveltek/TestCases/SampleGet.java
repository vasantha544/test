package com.traveltek.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.traveltek.BasePack.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SampleGet extends TestBase {
	
	@BeforeClass
	public void sampleGetCall() {
		initilizeFramework();
		RestAssured.baseURI = baseURI;
		RestAssured.basePath = "/api/users?page=2";
		response = RestAssured.given().when().get().then().extract().response();
	}
	
	@Test
	public void verifyStatusCode() {
		log.info("@@@@@@@@@@@  Checking the status code  @@@@@@@@@@@");	
		SoftAssert soft  = new SoftAssert();
		int statusCode = response.getStatusCode();
		soft.assertEquals(statusCode, 200);
		soft.assertAll();
	}
	
	@Test
	public void checkBody() {
		log.info("@@@@@@@@@@@  Checking the Body @@@@@@@@@@@");
		SoftAssert soft = new SoftAssert();
		String response_Body = response.getBody().asString();
		System.out.println("Response Body:-"+response_Body);
		JsonPath jsonPathEvaluator = response.jsonPath();
		int page_value = jsonPathEvaluator.get("page");
		soft.assertEquals(page_value, 1);
		soft.assertAll();
		}
	@Test
	public void check_responseTime() {
		log.info("@@@@@@@@@@@  Checking the Response Time  @@@@@@@@@@@");
		long time = response.getTime();
		System.out.println("Response Time :="+time);
		
	}

}
