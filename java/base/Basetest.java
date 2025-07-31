package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtendReportManager;
import utils.Log;
public class Basetest {
       
	protected WebDriver driver;
	
	protected static ExtentReports extent;
	protected ExtentTest tests;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent=ExtendReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		Log.info("Starting WebDriver...");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to URL...");
		driver.get("https://www.nop-station.com/login?returnUrl=%2Fkingdom-theme-flutter-mobile-app-combo%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26gad_source%3D1%26gad_campaignid%3D22221166953%26gbraid%3D0AAAAA-moW5KTbriPgKrHLg-xrYT2IyPVt%26gclid%3DCj0KCQjwkILEBhDeARIsAL--pjyZl5WOct5YRQb5PgM6sAuAGjMbrxIEDt_VTmtNwJ6HfckBBdlGjCEaAswqEALw_wcB");
		
	}
	@AfterMethod
	 public void teardown(ITestResult result) {
		 
		if (result.getStatus()==ITestResult.FAILURE) {
			String screenshotpath=ExtendReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test Failed... Check screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		 if (driver !=null) {
			 Log.info("Closing Browser...");
			 driver.quit();
		 }
		
	}
}
