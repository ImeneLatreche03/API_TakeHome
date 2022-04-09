package baseRequest;

import java.util.Random;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {

	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Random ran = new Random();
	public static int x = ran.nextInt(99);

	@BeforeSuite

	public void setupReport() {

		String fileName = "extentReport.html";
		htmlReporter = new ExtentHtmlReporter(fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}

		@AfterMethod 
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.fail(MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName() + "Test Case Passed", ExtentColor.GREEN));
		} else {

			test.skip(MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
			test.fail(result.getThrowable());

		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}



