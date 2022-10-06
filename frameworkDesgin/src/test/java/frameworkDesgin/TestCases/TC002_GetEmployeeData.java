package frameworkDesgin.TestCases;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkDesgin.BasePackage.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GetEmployeeData extends BaseClass {
	
	@BeforeClass
	void getEmployeeIDResponse() {
		logger.info("****** TC002_GetEmployeeData Started************");
		RestAssured.baseURI= baseURI;
		httpRequest = RestAssured.given();
		response =  httpRequest.request(Method.GET,"/users?id=1");
	}
	
	@Test
	void getEmployeeData() {
		logger.info("Fetching Data from Server for Eompoyee ID: 1");
		String responsebody = response.getBody().asString();
		Assert.assertTrue(responsebody!=null);
	}
	
	@Test
	void getStatusCode() {
		logger.info("Getting Status Code");
		int StatusCode = response.getStatusCode();
		logger.info("Status Code ->"+ StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
	
//	@Test
//	void getDataID() throws ParseException {
//		logger.info("Extracting data from JSON");
//		JSONObject obj = getParsingDone(response.getBody().asString());
//		String email = obj.get("data.email").toString();
//		logger.info("Email ID ->"+ email);
//		//Assert
//		
//	}
	
	@AfterClass
	void teardown() {
		logger.info("TC002 Completed");
	}

}
