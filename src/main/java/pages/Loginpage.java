package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
         private WebDriver driver;
         private By usernameTextBox=By.id("Email");
         private By passwordTextBox=By.id("Password");
         private By Loginbtn=By.xpath("//button[.='Log in']");
         
         public Loginpage(WebDriver driver) {
        	 this.driver=driver;
         }
         
         public void enterusername(String username) {
        	  driver.findElement(usernameTextBox).clear();
			  driver.findElement(usernameTextBox).sendKeys(username);
		}
         public void enterpassword(String password) {
        	 driver.findElement(passwordTextBox).clear();
        	 driver.findElement(passwordTextBox).sendKeys(password);
			
		}
         public void clicklogin() {
			driver.findElement(Loginbtn).click();
		}
}

