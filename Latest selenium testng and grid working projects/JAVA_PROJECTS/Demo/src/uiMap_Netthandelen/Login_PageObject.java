package uiMap_Netthandelen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Import files
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class Login_PageObject {
		
public Login_PageObject(WebDriver driver) {
			
			//Initialize A LoginPageObjects.
			PageFactory.initElements(driver, this);
		}
		
	
		//Login Link
		@FindBy(how=How.XPATH, using=".//*[@id='page-nav']/div[2]/div/div[2]/div/span[2]/a")
		
		public WebElement lnkLoggin;
		
		//Text Box Email address
		
		
				@FindBy(how=How.ID, using="Email")
				public WebElement txtEmailAddress;
				
				//Text Box Password
				
				@FindBy(how=How.ID, using="Password")
				public WebElement txtPassword;
				
				//Login Button
				
				@FindBy(how=How.ID, using="LoginButton")
				public WebElement btnLogin;
				
				
		
				
				
				
				
				
				
				
		
		
		

	}

