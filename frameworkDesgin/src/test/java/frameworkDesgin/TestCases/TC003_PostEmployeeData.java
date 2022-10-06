package frameworkDesgin.TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import frameworkDesgin.BasePackage.BaseClass;
import frameworkDesgin.utility.RandomStringGenerator;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_PostEmployeeData extends BaseClass {
	
	public String name = RandomStringGenerator.generateName();
	public String age = RandomStringGenerator.generateAge();

	@BeforeClass
	void postData() {

		logger.info("*************TC03_Post Request is started***************");
		RestAssured.baseURI = baseURI;
		httpRequest = RestAssured.given();

		JSONObject obj = new JSONObject();
		obj.put("Name", name);
		obj.put("age", age);

		logger.info("Data Added"+"->"+name+"->"+age);

		httpRequest.header("content-type", "application/json");
		httpRequest.body(obj.toJSONString());

		response = httpRequest.request(Method.POST, "/users");
		logger.info("Request Posted");

	}
	
	@Test
	void getSatusCode() {
		int statusCode =  response.getStatusCode();
		logger.info("Status Code for Post Request ->"+statusCode);
		Assert.assertEquals(statusCode, 201);	
	}
	
	@Test
	void valiateResponseBody() {
		logger.info("Validating Response body");
		Assert.assertEquals(response.getBody().asString().contains(name), true);	
		Assert.assertEquals(response.getBody().asString().contains(age), true);	
	}
	
	@AfterClass
	void tearDown() {
		logger.info("TC03 Post Request is Completed");
	}

}
