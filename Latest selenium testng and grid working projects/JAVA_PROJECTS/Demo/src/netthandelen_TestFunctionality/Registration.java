package netthandelen_TestFunctionality;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonfunctions.BrowserManagement;
import commonfunctions.ReportExtn;
import netthandelen_Variables.EnvironmentVariables;
import reusableMethods_PageObject.Netthandelen_ReusableMethods;
import uiMap_Netthandelen.Registration_PageObject;

		public class Registration {
			
					//Remote Web driver for remote execution
					public RemoteWebDriver driver = null;
					
					//BrowseManagement to set the browser capabilities
					public BrowserManagement objBrowserMgr = null;
					
					

					public Registration_PageObject uiRegistation_PageObject;
					
					
					//Static variable
					
					//String sRandStrNumber = RandomStringUtils.randomNumeric(4);
					//public String sMobileNumber = "9814" + sRandStrNumber;
					
					//public String sRandStr = RandomStringUtils.randomAlphabetic(5);
					
					//public  String sFirstName = "Fir" + sRandStr;
					public  String sFirstName = "Fir";
					//public  String sLastName = "La" + sRandStr;
					public  String sLastName = "La";
					//public String sEmailAddress = sFirstName + "@gmail.com";
					public String sEmailAddress = sFirstName + "@gmail.com";
					//public String sMobileNumber = "98955320";
					public String sMobileNumber = "98955320";
					public String sZipCode = "1201";
					
				
					
					
					//Method which will executed before the class loads
					//Browser Parameter received from TestNg.xml
					@Parameters({"Browser"})
					@BeforeClass
					public void BeforeNavigation(String sBrowser) throws MalformedURLException
					{
						try

						{

						//Read the application properties file
						//Load environment variable from properties file
						String sPath_AppProperties="";
						FileInputStream objFileInputStream = null;
						Properties objProperties = new Properties();
						
						//Set file path as per environment
						if (EnvironmentVariables.sEnv.equalsIgnoreCase("dev"))
						{
							sPath_AppProperties = ".//Resources//ApplicationProperties/DevApplication.properties";
						}
						else if (EnvironmentVariables.sEnv.equalsIgnoreCase("stage"))
						{
							sPath_AppProperties = ".//Resources//ApplicationProperties/StageApplication.properties";			
						}
						else if (EnvironmentVariables.sEnv.equalsIgnoreCase("lt"))
						{
							sPath_AppProperties = ".//Resources//ApplicationProperties/LtApplication.properties";			
						}
						else
						{
							sPath_AppProperties = ".//Resources//ApplicationProperties/TestApplication.properties";			
						}
						
						
						
						
						
						
////////////////////////////////////////////*********************************************////////////////////////////
						




////////////////////////////////////////////*********************************************////////////////////////////

						
						
						
						
						//Load the Application variable file into File Input Stream.
						File objFileApplication = new File(sPath_AppProperties);
						try
						{
							objFileInputStream = new FileInputStream(objFileApplication);
						}catch (FileNotFoundException ex)
						{
							ReportExtn.Fail("Unable to Read the Properties file" +  ex.getMessage());
						}
						
						//Load the File Input Stream into the Properties file
						try
						{
							objProperties.load(objFileInputStream);
							
						} catch (IOException ex) {

							ReportExtn.Fail("Unable to Read the Properties file" +  ex.getMessage());
						}
						
						
						//Edit Browser Capabilities as per project
						//Fire fox Profile		
						//FirefoxProfile profile = new FirefoxProfile();
						
						//profile.setPreference("network.automatic-ntlm-auth.trusted-uris",EnvironmentVariables.sTrusted_Uris);
						//Capability
						objBrowserMgr = new BrowserManagement(sBrowser);
						//objBrowserMgr.capability.setCapability(FirefoxDriver.PROFILE, profile);	
						
						
						  
						 
						try
						{	
							//System.setProperty("webdriver.ie.driver", "C:\\JAVA_PROJECTS\\Demo\\Libs\\IEDriverServer.exe");
							
							//System.setProperty("webdriver.ie.driver", "C:\\JAVA_PROJECTS\\Demo\\Libs\\IEDriverServer.exe");
							//driver= new InternetExplorerDriver(objBrowserMgr.capability);
							//driver=new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), objBrowserMgr.capability);
					    	//capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						    //driver= new InternetExplorerDriver(objBrowserMgr.capability);
								//driver.get("www.google.co.in");
							
							driver = new RemoteWebDriver(new URL("http://".concat(EnvironmentVariables.sHub).concat(":").concat(EnvironmentVariables.sHubPort).concat("/wd/hub")), objBrowserMgr.capability);
							
						}
						catch(Exception ex)
						{	
							ReportExtn.Fail("Unable to create the Remotedriver" +  ex.getMessage());			
						}
						driver.get(EnvironmentVariables.sTestnetthandelen_Url);
                        
						//driver.get("http://www.wikipedia.org/");
						
						//WebDriver driver = new SafariDriver();
						//driver.get("http://store.demoqa.com");
						
						driver.manage().window().maximize();
						
						uiRegistation_PageObject =new Registration_PageObject(driver) ;
						}
						catch (Exception e)
												
						{
						Reporter.log(e.getMessage());
						System.out.println(e.getMessage());
						System.out.println(e.getStackTrace());
						}
					}
					
					
					
					@AfterClass
					public void AfterNavigation()
					{
						try

						{
							
							
						//Quit the test after test class execution
						if(driver != null)
						{
							driver.quit();			
						}
					}
					catch (Exception e)
											
					{
					
					}
					}

					
				
				@Test
				public void RegistrationPage(Method objMethod) throws InterruptedException, ClassNotFoundException, SQLException
				{
					
					driver.manage().window().setSize(new Dimension(1024, 850));
					
					uiRegistation_PageObject =new Registration_PageObject(driver) ;
					//Thread.sleep(10000);
					
					//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					//driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
					
					System.out.println(1);
					uiRegistation_PageObject.googlesend.sendKeys("webdriver");
					
					uiRegistation_PageObject.googleCLICK.click();
					
					
					/*try{
						
						
					
					uiRegistation_PageObject =new Registration_PageObject(driver) ;
					//Thread.sleep(10000);
					
					System.out.println(1);
					uiRegistation_PageObject.googlesend.sendKeys("test12345");
					
					try{
						
						
						
						uiRegistation_PageObject.popMessage.click();
						
						//Click on Register Link
						
						uiRegistation_PageObject.lnkRegister.click();
					}
					
					catch (Exception e)
					
					{
					//Reporter.log(e.getMessage());
						uiRegistation_PageObject.lnkRegister.click();
					}
					
					
					
						
						
					
					//Enter Registration details
					
					uiRegistation_PageObject.txtFirstName.clear();
					
				
					uiRegistation_PageObject.txtFirstName.sendKeys(sFirstName);
					uiRegistation_PageObject.txtLastName.clear();
					
					uiRegistation_PageObject.txtLastName.sendKeys(sLastName);
					
					
					uiRegistation_PageObject.txtEmailAddress.clear();
					
					
					uiRegistation_PageObject.txtEmailAddress.sendKeys(sEmailAddress);
					
					uiRegistation_PageObject.txtNewPassword.clear();
					
					uiRegistation_PageObject.txtNewPassword.sendKeys("asdf1234");
					
					uiRegistation_PageObject.txtAddress.clear();
					
					uiRegistation_PageObject.txtAddress.sendKeys("Gurgaon1");
					
					uiRegistation_PageObject.txtHomeZipcode.clear();
					
					uiRegistation_PageObject.txtHomeZipcode.sendKeys(sZipCode);
					
					uiRegistation_PageObject.txtMobileNumber.clear();
					
					uiRegistation_PageObject.txtMobileNumber.sendKeys(sMobileNumber);
					
					Thread.sleep(10000);
					
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					 
					   js.executeScript("var evt = document.createEvent('MouseEvents');"+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					     + "arguments[0].dispatchEvent(evt);",uiRegistation_PageObject.btnRegister);
					
					
		
					
			System.out.println(driver.findElement(By.id("btn-register")).isEnabled());
					
				
					
					
					
					
				String RegistrationMessage=	uiRegistation_PageObject.txtRegistrationMessage.getText().trim();
				
				System.out.println(RegistrationMessage);
				
				Database data = new Database();
				String smsValue =data.verification();
			
				
				System.out.println("smsValue");

				Thread.sleep(10000);
			
				driver.findElement(By.id("txt-code")).sendKeys(smsValue);
				Thread.sleep(10000);
				

				//JavascriptExecutor js = (JavascriptExecutor) driver;
				 
				   js.executeScript("var evt = document.createEvent('MouseEvents');"+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				     + "arguments[0].dispatchEvent(evt);",uiRegistation_PageObject.btnRegisterAfterValidation);
				
				
				//uiRegistation_PageObject.btnRegisterAfterValidation.click();
				Thread.sleep(10000);
				
				
				
				
		        uiRegistation_PageObject.lnkMinSide.click();
				
				
		       
		       Thread.sleep(10000);
		       
		       js.executeScript("var evt = document.createEvent('MouseEvents');"+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					     + "arguments[0].dispatchEvent(evt);",uiRegistation_PageObject.lnkLogout);
				 
				 
					}
				catch (Exception e)
				
				{
				//Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
				*/}
				
				}
				
				
					
		
				
					
					
					
						
	
				
				
	

	

