package TestNg;

import org.testng.annotations.Test;

import utills.Property;

public class TestClass {
	
	@Test
	public void testmethod() {
		String filePath = "C:\\Users\\Lucy Rani\\Documents\\Automation\\BackendTesting\\Config\\Congfig.properties";
		String baseURI = Property.getPropertyValue(filePath, "baseURL");
		System.out.println(baseURI);
	}

}
