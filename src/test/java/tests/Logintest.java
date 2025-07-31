package tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;
import utils.ExcelUtils;
import utils.ExtendReportManager;
import utils.Log;

public class Logintest extends Basetest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException{
		String filepath= System.getProperty("user.dir")+"/testdata/TxtData.xlsx";
		ExcelUtils.loadexcel(filepath, "Sheet1");
		int rowCount=ExcelUtils.getRowCount();
		Object[][] data=new Object[rowCount-1][2];
		for (int i = 1; i < rowCount; i++) {
			
			data[i-1][0]=ExcelUtils.getCellData(i, 0);
			data[i-1][1]=ExcelUtils.getCellData(i, 1);
		}
	ExcelUtils.closeExcel();
	return data;
	}
	
	@DataProvider(name = "Logindata2")
	public Object[][] getData(){
		return new Object[][] {
			{"user123","pass1"},
			{"user234","pass2"},
			{"user345","pass3"}
			
		};
	}
	
//	@Test(dataProvider = "Logindata2")
	@Test
	@Parameters({"username","password"})
	public void testvalidlogin(String username,String password) {
		Log.info("Starting Login Test....");
		test = ExtendReportManager.createTest("Login Test - "+username);
		Loginpage loginpage = new Loginpage(driver);
		test.info("Navigating to url");

		Log.info("Adding credentials");
		test.info("Adding Credentials");
//		loginpage.enterusername("admin@yourstore.com");
//		loginpage.enterpassword("admin");
		loginpage.enterusername(username);
		loginpage.enterpassword(password);
		test.info("Clicking on Login Btn");
		loginpage.clicklogin();

		System.out.println("title  page is " + driver.getTitle());
		Log.info("Verify page title...");
		Assert.assertEquals(driver.getTitle(),"Just a moment..");
		test.info("Login Succes");
	}
//@Test
//	public void testvalidloginwithInvalidCrediatials() {
//		 Log.info("Starting Login Test....");
//		 test=ExtendReportManager.createTest("Login Test with invalid credentials");
//    	 Loginpage loginpage=new Loginpage(driver);
//    	 test.info("Navigating to url");
//    	  
//    	  Log.info("Adding credentials");
//    	  test.info("Adding Credentials");
//    	  loginpage.enterusername("admin1234@yourstore.com");
//    	  loginpage.enterpassword("admin33");
//    	  test.info("Clicking on Login Btn");
//    	  loginpage.clicklogin();
//    	  
//    	  System.out.println("title  page is "+driver.getTitle());
//    	  Log.info("Verify page title...");
//    	  Assert.assertEquals(driver.getTitle(),"Just a moment..");
//    	  test.info("Login Succes");
//}
}