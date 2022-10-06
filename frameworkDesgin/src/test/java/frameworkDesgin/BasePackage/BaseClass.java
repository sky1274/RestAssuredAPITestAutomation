package frameworkDesgin.BasePackage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	public String baseURI = "https://reqres.in/api";
	public String getPathParameter = "/users?page=1";
	
	@BeforeClass
	public void setUp() {
		logger= Logger.getLogger("EmployeeData");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
	
	public JSONObject getParsingDone(String data) throws ParseException {
		
		JSONParser parse =  new JSONParser();
		JSONObject obj = (JSONObject) parse.parse(data);
		return obj;
	}

}
