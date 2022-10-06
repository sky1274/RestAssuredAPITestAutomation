package frameworkDesgin.utility;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		htmlReporter.config().setDocumentTitle("RestAssured Testing");
		htmlReporter.config().setReportName("Regression Testing Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Hostname", "QA Env");
		report.setSystemInfo("Name", "Imran");
	}
	
	public void onTestSuccess(ITestResult result) {
		test= report.createTest(result.getName());
		test.log(Status.PASS, "Test Case PASSED is"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test= report.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED is"+result.getName());
		test.log(Status.FAIL, "Test Case FAILED is"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result) {
		test= report.createTest(result.getName());
		test.log(Status.SKIP, "Test Case SKIPPED is"+result.getName());
	}
	
	public void onFinish(ITestContext testContext) {
		report.flush();
		
	}

}
