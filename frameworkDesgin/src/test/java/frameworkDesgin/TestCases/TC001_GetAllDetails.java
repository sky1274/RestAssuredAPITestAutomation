package frameworkDesgin.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkDesgin.BasePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GetAllDetails extends BaseClass {
	
	@BeforeClass
	void getAllDetails() {
		logger.info("******Started TC001_GetAllDetails******");
		RestAssured.baseURI= baseURI;
		httpRequest = RestAssured.given();
		response =  httpRequest.request(Method.GET,getPathParameter);
	}
	
	@Test
	void verifyStatusCode() {
		logger.info("Checking Status Code");
		int statusCode = response.getStatusCode();
		logger.info("Status Code -> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@AfterClass
	void tearDown() {
		logger.info(("****************Finished TC001_GetAllDetails************* "));
	}

}
