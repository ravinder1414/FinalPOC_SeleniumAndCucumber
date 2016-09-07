package uiMap_Netthandelen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Import files
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class Registration_PageObject {
		
public Registration_PageObject(WebDriver driver) {
			
			//Initialize A RegistrationPageObjects.
			PageFactory.initElements(driver, this);
		}
		
	
		//Pop up message
		@FindBy(how=How.XPATH, using="//img[@src='//s3.amazonaws.com/static.barilliance.com/img/close_buttons/close2_32.png']")
		
		public WebElement popMessage;
		
       @FindBy(how=How.NAME, using="q")
		
		public WebElement googlesend;
       
       
       @FindBy(how=How.NAME, using="btnG")
		
		public WebElement googleCLICK;
       
       
       
		
		
		
		
		//Register link English
		
		
				@FindBy(how=How.LINK_TEXT, using="Ny kunde")
				public WebElement lnkRegister;
		
		//@FindBy(how=How.LINK_TEXT, using="Register")
		//public WebElement lnkRegister;
	                                               

		//First Name
		@FindBy(how=How.ID, using="txt-first-name")
		public WebElement txtFirstName;
		

		//Last Name
		@FindBy(how=How.ID, using= "txt-last-name")
		public WebElement txtLastName;
		
		//Email Address Text Box
		@FindBy(how=How.ID, using="txt-email")
		public WebElement txtEmailAddress;
				
		//Password
		@FindBy(how=How.ID, using="txt-password")
		public WebElement txtNewPassword;
		
		//Address
		@FindBy(how=How.ID, using="txt-address")
		public WebElement txtAddress;
		
		//Home ZIP Code Text
		@FindBy(how=How.ID, using="txt-post-number")
		public WebElement txtHomeZipcode;
		
		
		//Mobile number Text
		@FindBy(how=How.ID, using="txt-mobile-number")
		public WebElement txtMobileNumber;
		

		//Register button
		//@FindBy(how=How.XPATH, using= "//span[text()='Registrer']")
		//public WebElement btnRegister;
		
		@FindBy(how=How.ID, using= "btn-register")
		public WebElement btnRegister;
		
		
		
		
		
		//Registation message
				@FindBy(how=How.XPATH, using= ".//*[@id='validationWrapper']/div[3]/div[1]/label")
				public WebElement txtRegistrationMessage;
				
				
				//Database value text
				
				@FindBy(how=How.ID, using= "txt-code")
				public WebElement txtDataValue;
				
				
				
				//After database code Register link
				
				@FindBy(how=How.ID, using="btn-validate")
				public WebElement btnRegisterAfterValidation;
				
				//Min Side
				
				@FindBy(how=How.XPATH, using="html/body/div[2]/div[1]/div/ul[1]/li[2]/a/span")
				public WebElement lnkMinSide;
				
				
				//@FindBy(how=How.XPATH, using="//li[2]/a/span")
				//public WebElement lnkMinSide;
				
				
				
				
				
				
				//Logout 
				
				//@FindBy(how=How.XPATH, using="//a[(@href='/logout')]")
				//public WebElement lnkLogout;
				
				@FindBy(how=How.XPATH, using=".//*[@id='account-content']/div/div[1]/div/a/span")
				public WebElement lnkLogout;
				
				
				
				
				
				
				
				
				
				
		
		
		

	}

