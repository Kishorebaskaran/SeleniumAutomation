package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class Basetest {
       
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nop-station.com/login?returnUrl=%2Fkingdom-theme-flutter-mobile-app-combo%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26gad_source%3D1%26gad_campaignid%3D22221166953%26gbraid%3D0AAAAA-moW5KTbriPgKrHLg-xrYT2IyPVt%26gclid%3DCj0KCQjwkILEBhDeARIsAL--pjyZl5WOct5YRQb5PgM6sAuAGjMbrxIEDt_VTmtNwJ6HfckBBdlGjCEaAswqEALw_wcB");
		
	}
	@AfterMethod
	 public void teardown() {
		 
		 if (driver !=null) {
			 driver.quit();
		 }
		
	}
}
