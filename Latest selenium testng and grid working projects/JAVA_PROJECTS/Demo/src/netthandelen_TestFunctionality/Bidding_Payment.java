package netthandelen_TestFunctionality;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
import netthandelen_Utility.TestUtilN;
import netthandelen_Variables.EnvironmentVariables;
import reusableMethods_PageObject.Netthandelen_ReusableMethods;
import uiMap_Netthandelen.Bid_Order_PageObject;
import uiMap_Netthandelen.Login_PageObject;
import uiMap_Netthandelen.Registration_PageObject;

public class Bidding_Payment {

	// Remote Web driver for remote execution
	public RemoteWebDriver driver = null;


	// BrowseManagement to set the browser capabilities
	public BrowserManagement objBrowserMgr = null;

	public Login_PageObject uiLogin_PageObject;

	public Bid_Order_PageObject uiBid_Order_PageObject;

	public Registration_PageObject uiRegistation_PageObject;
	
	private String sBrowserType ="";

	// Static variable
	public static String UserNameIE;
	public static String UserName;

	public static String pwd1;

	public static String AuctionWeburl;

	public static String oderAmountValue;

	public static String EmailAddress = "espire11@testing.com";

	public static String OderIdfinal;

	public static String AuctionURL_IE = "http://test.netthandelen.no:6100/1/Auction/AuctionSearch/";
	
	public static String AuctionURL = "test.netthandelen.no:6100/1/Auction/AuctionSearch/";
	
	public static String PaymentURL_IE = "test.netthandelen.no:6100/1/Payments/PaymentFileManual/";
	public static String PaymentURL = "http://test.netthandelen.no:6100/1/Payments/PaymentFileManual/";

	// Method which will executed before the class loads
	// Browser Parameter received from TestNg.xml
	@Parameters({ "Browser" })
	@BeforeClass
	public void BeforeNavigation(String sBrowser) throws MalformedURLException {
		try

		{

			// Read the application properties file
			// Load environment variable from properties file
			
			this.sBrowserType = sBrowser;
			String sPath_AppProperties = "";
			FileInputStream objFileInputStream = null;
			Properties objProperties = new Properties();

			// Set file path as per environment
			if (EnvironmentVariables.sEnv.equalsIgnoreCase("dev")) {
				sPath_AppProperties = ".//Resources//ApplicationProperties/DevApplication.properties";
			} else if (EnvironmentVariables.sEnv.equalsIgnoreCase("stage")) {
				sPath_AppProperties = ".//Resources//ApplicationProperties/StageApplication.properties";
			} else if (EnvironmentVariables.sEnv.equalsIgnoreCase("lt")) {
				sPath_AppProperties = ".//Resources//ApplicationProperties/LtApplication.properties";
			} else {
				sPath_AppProperties = ".//Resources//ApplicationProperties/TestApplication.properties";
			}

			//////////////////////////////////////////// *********************************************////////////////////////////

			//////////////////////////////////////////// *********************************************////////////////////////////

			// Load the Application variable file into File Input Stream.
			File objFileApplication = new File(sPath_AppProperties);
			try {
				objFileInputStream = new FileInputStream(objFileApplication);
			} catch (FileNotFoundException ex) {
				ReportExtn.Fail("Unable to Read the Properties file" + ex.getMessage());
			}

			// Load the File Input Stream into the Properties file
			try {
				objProperties.load(objFileInputStream);

			} catch (IOException ex) {

				ReportExtn.Fail("Unable to Read the Properties file" + ex.getMessage());
			}

			// Edit Browser Capabilities as per project

			// Capability
			objBrowserMgr = new BrowserManagement(sBrowser);

			try {

				driver = new RemoteWebDriver(new URL("http://".concat(EnvironmentVariables.sHub).concat(":")
						.concat(EnvironmentVariables.sHubPort).concat("/wd/hub")), objBrowserMgr.capability);

			} catch (Exception ex) {
				ReportExtn.Fail("Unable to create the Remotedriver" + ex.getMessage());
			}
			driver.get(EnvironmentVariables.sTestnetthandelen_Url);

			driver.manage().window().maximize();
			uiLogin_PageObject = new Login_PageObject(driver);

			uiBid_Order_PageObject = new Bid_Order_PageObject(driver);

			uiRegistation_PageObject = new Registration_PageObject(driver);
		} catch (Exception e)

		{
			Reporter.log(e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

	@AfterClass
	public void AfterNavigation() {
		try

		{

			// Quit the test after test class execution
			if (driver != null) {
				driver.quit();
				Thread.sleep(10000);
				TestUtilN.zip("C:\\JAVA_PROJECTS\\Demo\\test-output\\html");
			}
		} catch (Exception e)

		{

		}
	}
	
	@Test
	public void Login(Method objMethod) throws InterruptedException, ClassNotFoundException, SQLException {
		try {
			uiLogin_PageObject = new Login_PageObject(driver);

			uiBid_Order_PageObject = new Bid_Order_PageObject(driver);

			uiRegistation_PageObject = new Registration_PageObject(driver);
			Thread.sleep(10000);

			try {
				uiRegistation_PageObject.popMessage.click();

				// Click on Login Link

				uiLogin_PageObject.lnkLoggin.click();
			}catch (Exception e){
				Thread.sleep(10000);
				uiLogin_PageObject.lnkLoggin.click();
			}

			uiLogin_PageObject.txtEmailAddress.clear();

			uiLogin_PageObject.txtEmailAddress.sendKeys(EmailAddress);

			Thread.sleep(5000);

			uiLogin_PageObject.txtPassword.clear();

			uiLogin_PageObject.txtPassword.sendKeys("Espire@124");

			uiLogin_PageObject.btnLogin.click();

		}catch (Exception e){
			Reporter.log(e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}


	@Test(dependsOnMethods = {"Login" })
	public void bidding(Method objMethod) throws InterruptedException, ClassNotFoundException, SQLException {

		
		// Bidding

		// click on bidding item

		Thread.sleep(10000);

				

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("var evt = document.createEvent('MouseEvents');"
				+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
				+ "arguments[0].dispatchEvent(evt);", uiBid_Order_PageObject.btnBidSelection);

		boolean recCall = false;
		
		// Code by sajid start
		//WebElement BidTimer = driver.findElement(By.xpath("//span[@id='auctioncountdown']"));
		if (uiBid_Order_PageObject.bidTimer == null) {
			Thread.sleep(5000);
			driver.navigate().back();
			driver.navigate().refresh();
			// bid.click();
			Thread.sleep(10000);
			recCall = true;
		}

		String val = uiBid_Order_PageObject.bidTimer.getText();

		System.out.println(val);
		if (val.length() <= 6) {
			String str1 = "0";
			String str2 = "0";

			if (val.length() == 6) {
				str1 = val.substring(val.length() - 6, val.length() - 5);
				str2 = val.substring(val.length() - 3, val.length() - 1);
			} else {
				str1 = "0";
				if (val.length() <= 5 && val.length() > 2) {
					str2 = val.substring(val.length() - 3, val.length() - 1);
				} else if (val.length() >= 2) {
					str2 = val.substring(val.length() - 3, val.length() - 1);
				}
			}

			try {
				Integer x = Integer.valueOf(str1);
				if (x == 0) {
					Integer y = Integer.valueOf(str2);
					if (y <= 20) {
						Thread.sleep(5000);

						driver.navigate().back();

						driver.navigate().refresh();

						// bid.click();

						Thread.sleep(10000);
						recCall = true;
					}
				}

			} catch (NumberFormatException e) {

			}

		}

		// uiBid_Order_PageObject.btnBidSelection.click();
		if(recCall){
			bidding(objMethod);
		}else if (driver.findElements(By.xpath("//span[text()='Velg']")).size() != 0) {

			driver.findElement(By.xpath("//span[text()='Velg']")).getText().equalsIgnoreCase("Velg");

			WebElement element = driver.findElement(By.cssSelector("span.select2-selection__arrow"));

			element.click();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.chord(Keys.ENTER)).perform();
			
			if (driver.findElements(By.xpath("//ins[@class='iCheck-helper']")).size() != 0)
			{  driver.findElement(By.xpath("//ins[@class='iCheck-helper']")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Velg']")).getText().equalsIgnoreCase("Velg");

			WebElement element2 = driver.findElement(By.xpath(".//*[@id='attributesWrapper']/div[3]/div/div/label/span/span[1]/span/span[2]"));

			element2.click();
			
			Thread.sleep(5000);
			act.sendKeys(Keys.chord(Keys.ENTER)).perform();
			}
			
			

			js.executeScript("var evt = document.createEvent('MouseEvents');"
					+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					+ "arguments[0].dispatchEvent(evt);", uiBid_Order_PageObject.btnBid);

			// WebElement GiBid = driver.findElement(By.id("btnBid"));

			// GiBid.click();

			try {

				Alert alert = driver.switchTo().alert();
				alert.accept();
			}

			catch (Exception e) {
			}
		 }else {
			
			
			Thread.sleep(3000);

			js.executeScript("var evt = document.createEvent('MouseEvents');"
					+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					+ "arguments[0].dispatchEvent(evt);", uiBid_Order_PageObject.btnBid);

			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();

			} catch (Exception e) {

			}
		}
	}

	@Test(dependsOnMethods = {"bidding"})
	// @Test
	public void createOrder(Method objMethod) throws InterruptedException

	{
		try

		{
			uiLogin_PageObject = new Login_PageObject(driver);

			uiBid_Order_PageObject = new Bid_Order_PageObject(driver);

			uiRegistation_PageObject = new Registration_PageObject(driver);

			Thread.sleep(10000);
	

			String AuctionId = driver.getCurrentUrl();

			String AuctionIddone = AuctionId.substring(AuctionId.lastIndexOf('/', AuctionId.length()) + 1,
					AuctionId.length());

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

			Thread.sleep(5000);

			String parentHandle = driver.getWindowHandle();

			Set<String> winHandles = driver.getWindowHandles();

			System.out.println(winHandles);

			for (String currentWindowHandle : winHandles) {

				if (!currentWindowHandle.equals(parentHandle)) {

					driver.switchTo().window(currentWindowHandle);
					
				}}

					// UserName1 ="venkata.rao";
					
					//
					
					if (sBrowserType.equalsIgnoreCase("firefox")){
						
						driver.get(AuctionURL_IE);
						
						Thread.sleep(10000);
						
						Runtime.getRuntime().exec("C:\\Users\\ravinder.kumar\\Desktop\\autoit\\Auction.exe");
						
						
						

					}else if(sBrowserType.equalsIgnoreCase("ie")){
						
						// working code in IE
						
						driver.navigate().to(AuctionURL_IE);
						
						//driver.get(AuctionURL_IE);
						
						UserNameIE = "Netthandelen\\venkata.rao";
						pwd1 = "Yaswanth21";
						
						

						
						  StringSelection stringSelection = new
						  StringSelection(pwd1);
						  Toolkit.getDefaultToolkit().getSystemClipboard().
						  setContents(stringSelection, null); Robot robot = new
						  Robot(); Alert alert=driver.switchTo().alert();
						  
						  Thread.sleep(10000);
						 
						  alert.sendKeys(UserNameIE);
						  robot.keyPress(KeyEvent.VK_TAB);
						  robot.keyRelease(KeyEvent.VK_TAB);
						  robot.keyPress(KeyEvent.VK_CONTROL);
						  robot.keyPress(KeyEvent.VK_V);
						  robot.keyRelease(KeyEvent.VK_V);
						  robot.keyRelease(KeyEvent.VK_CONTROL);
						  
						  
						  try { (new
						  Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER); (new
						  Robot()).keyRelease(java.awt.event.KeyEvent.VK_ENTER); }
						  catch (AWTException e) {
						  
						 e.printStackTrace();
						 
		
						  }
						
						
						
					}else{
						
						String uname = "venkata.rao"; String pwd = "Yaswanth21";
						 
						 String AuctionWeb =AuctionURL;
						 
						 String AuctionWeburl = "http://" + uname + ":" + pwd + "@" +
						 AuctionWeb;
						 
						 driver.navigate().to(AuctionWeburl);
						
						
						
						
						
						
					}
					


					// WebDriverWait wait = new WebDriverWait(driver, 10);

					Thread.sleep(5000);

					uiBid_Order_PageObject.txtAuctionId.sendKeys(AuctionIddone);

					// driver.findElement(By.id("ctl11_txtAuctionId")).sendKeys();

					uiBid_Order_PageObject.txtAuctionIdPeriodNone.click();

					// driver.findElement(By.id("ctl11_rbPeriodNone")).click();

					uiBid_Order_PageObject.btnSearch.click();

					// driver.findElement(By.id("ctl11_btnSearch")).click();

					Thread.sleep(3000);

					// driver.findElement(By.xpath(".//*[@id='ctl11_lvAuctions_Image1_0']")).click();

					uiBid_Order_PageObject.imgAuctions.click();

					Thread.sleep(3000);

					List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));

					System.out.println(iframeElements);

					System.out.println(12);

					driver.switchTo().frame(0);

					uiBid_Order_PageObject.btnEnd.click();
					
					Thread.sleep(10000);

					// driver.findElement(By.id("ctl03_btnEnd")).click();

					// System.out.println(1);

					try {

						WebDriverWait wait1 = new WebDriverWait(driver, 20);

						Alert alert1 = driver.switchTo().alert();
						wait1.until(ExpectedConditions.alertIsPresent());

						alert1.accept();
					} catch (Exception e)

					{

					}

					System.out.println(2);

					driver.switchTo().defaultContent();

					driver.switchTo().frame(0);

					Thread.sleep(3000);

					driver.findElement(By.xpath(".//*[@id='ctl03_btnCancel']")).click();

					driver.switchTo().defaultContent();

					Thread.sleep(10000);

					driver.navigate().to("http://test.netthandelen.no:6100/1/Customer/CustomerSearch/");

					uiBid_Order_PageObject.txtOrderEmailAddress.sendKeys(EmailAddress);

					Thread.sleep(5000);

					uiBid_Order_PageObject.btnOrderSearch.click();

					// Click on search order

					uiBid_Order_PageObject.lnkSearchOrder.click();

					Thread.sleep(10000);
					Alert alert1 = driver.switchTo().alert();
					alert1.accept();

					// driver.close();

					// driver.switchTo().window(tabs2.get(0));

					Thread.sleep(10000);

					driver.navigate().to("https://test.netthandelen.no:7014");

					// driver.switchTo().window(parentHandle);

					// System.out.println(parentHandle);

					Thread.sleep(10000);

					uiBid_Order_PageObject.lnkMineorder.click();

					Thread.sleep(3000);

					// Order Button click

					uiBid_Order_PageObject.lnkOrderNumbers.click();

					Thread.sleep(10000);

					uiBid_Order_PageObject.btnBetalOrdern.click();

					Thread.sleep(10000);

					uiBid_Order_PageObject.btnBreaklinebaseline.click();

					// driver.findElement(By.xpath(".//*[@id='main']/div[1]/div/div[1]/div[2]/a/span")).click();

					// driver.findElement(By.xpath("//a[@class='button
					// button-secondary button-large
					// order-details'][2]")).click();
					Thread.sleep(3000);

					// driver.findElement(By.xpath("//a[@class='button
					// button-xlarge button-secondary style-block']")).click();
					Thread.sleep(3000);

					WebElement OderId = driver.findElement(
							By.xpath(".//*[@id='frm-checkout-success']/div/div/div/div[1]/div/h2/a/strong"));

					OderIdfinal = OderId.getText();

					System.out.println(OderIdfinal);

					OderId.click();
					Thread.sleep(3000);

					driver.findElement(By.xpath(".//*[@id='main']/div[1]/div/div[1]/div[2]/a[2]")).click();
					Thread.sleep(3000);

					WebElement orderamount = driver
							.findElement(By.xpath("//span[@class='value text-success ng-binding']"));

					oderAmountValue = orderamount.getText();

					System.out.println(oderAmountValue);

					driver.findElement(By.xpath("//a[@class='button button-xlarge button-secondary style-block']"))
							.click();
					Thread.sleep(3000);

				
			
		} catch (Exception e)

		{
			Reporter.log(e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

		@Test(dependsOnMethods={"createOrder"})
		public void Payment(Method objMethod) throws InterruptedException

		{
			try

			{
				uiLogin_PageObject = new Login_PageObject(driver);

				uiBid_Order_PageObject = new Bid_Order_PageObject(driver);

				uiRegistation_PageObject = new Registration_PageObject(driver);

				Thread.sleep(10000);
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

				Thread.sleep(5000);
				
				String PaymentLink = PaymentURL;

				driver.get(PaymentURL);

				Thread.sleep(5000);

				String parentHandle1 = driver.getWindowHandle();

				Set<String> winHandles1 = driver.getWindowHandles();

				System.out.println(winHandles1);
				for (String currentWindowHandle1 : winHandles1) {
					if (!currentWindowHandle1.equals(parentHandle1)) {

						driver.switchTo().window(currentWindowHandle1);
						
					}}
						
						if (sBrowserType.equalsIgnoreCase("firefox")){
							
							driver.get(PaymentURL_IE);
							
							Thread.sleep(10000);
							
							Runtime.getRuntime().exec("C:\\Users\\ravinder.kumar\\Desktop\\autoit\\Auction.exe");
							
							
							

						}else if(sBrowserType.equalsIgnoreCase("ie")){
							
							// working code in IE
							
							driver.navigate().to(PaymentURL_IE);
							
							//driver.get(AuctionURL_IE);
							
							UserNameIE = "Netthandelen\\venkata.rao";
							pwd1 = "Yaswanth21";
							
							

							
							  StringSelection stringSelection = new
							  StringSelection(pwd1);
							  Toolkit.getDefaultToolkit().getSystemClipboard().
							  setContents(stringSelection, null); Robot robot = new
							  Robot(); Alert alert=driver.switchTo().alert();
							  
							  Thread.sleep(10000);
							 
							  alert.sendKeys(UserNameIE);
							  robot.keyPress(KeyEvent.VK_TAB);
							  robot.keyRelease(KeyEvent.VK_TAB);
							  robot.keyPress(KeyEvent.VK_CONTROL);
							  robot.keyPress(KeyEvent.VK_V);
							  robot.keyRelease(KeyEvent.VK_V);
							  robot.keyRelease(KeyEvent.VK_CONTROL);
							  
							  
							  try { (new
							  Robot()).keyPress(java.awt.event.KeyEvent.VK_ENTER); (new
							  Robot()).keyRelease(java.awt.event.KeyEvent.VK_ENTER); }
							  catch (AWTException e) {
							  
							 e.printStackTrace();
							 
			
							  }
							
							
							
						}else{
							
							String uname = "venkata.rao"; String pwd = "Yaswanth21";
							 
							 String AuctionWeb =PaymentURL;
							 
							 String AuctionWeburl = "http://" + uname + ":" + pwd + "@" +
							 AuctionWeb;
							 
							 driver.navigate().to(AuctionWeburl);
							
							
							
							
							
							
						}

						
						Thread.sleep(5000);

						uiBid_Order_PageObject.txtPaymentOrderID.clear();

						uiBid_Order_PageObject.txtPaymentOrderID.sendKeys(OderIdfinal);

						// Payment Account details

						uiBid_Order_PageObject.txtPaymentAccount.sendKeys("22112211221");

						// Order Value

						uiBid_Order_PageObject.txtPaymentOrderValue.sendKeys(oderAmountValue);

						// Payment File value

						uiBid_Order_PageObject.txtPaymentFileName.sendKeys("NH_" + oderAmountValue);

						// Button Add

						uiBid_Order_PageObject.btnPaymentAdd.click();

					
				}
			

			catch (Exception e)

			{
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			
			

		}
	}

