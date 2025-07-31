package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;
import utils.Log;

public class Loginpage {
	
         private WebDriver driver;
         
         @FindBy(id = "Email")
         WebElement usernameTextBox;
         
         @FindBy(id = "Password")
         WebElement passwordTextBox;
         
         @FindBy(xpath = "//button[.='Log in']")
         WebElement Loginbtn;
         
//         private By usernameTextBox=By.id("Email");
//         private By passwordTextBox=By.id("Password");
//         private By Loginbtn=By.xpath("//button[.='Log in']");
         
         public Loginpage(WebDriver driver) {
        	 this.driver=driver;
        	 PageFactory.initElements(driver, this);
         }
         
         public void enterusername(String username) {
        	 usernameTextBox.clear();
        	 usernameTextBox.sendKeys(username);
//        	  driver.findElement(usernameTextBox).clear();
//			  driver.findElement(usernameTextBox).sendKeys(username);
		}
         public void enterpassword(String password) {
        	 passwordTextBox.clear();
        	 passwordTextBox.sendKeys(password);
//        	 driver.findElement(passwordTextBox).clear();
//        	 driver.findElement(passwordTextBox).sendKeys(password);
			
		}
         public void clicklogin() {
        	 
        	 Log.info("Clicking Login Btn....");
        	 Loginbtn.click();
//			driver.findElement(Loginbtn).click();
		}
}

