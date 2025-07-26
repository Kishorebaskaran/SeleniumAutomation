package tests;

import org.testng.annotations.Test;

import base.Basetest;
import pages.Loginpage;

public class Logintest extends Basetest{
	
	@Test
      public void testvalidlogin() {
		 
    	  Loginpage loginpage=new Loginpage(driver);
    	  loginpage.enterusername("admin@yourstore.com");
    	  loginpage.enterpassword("admin");
    	  loginpage.clicklogin();
    	  System.out.println("title  page is "+driver.getTitle());
    	  
	}
}
