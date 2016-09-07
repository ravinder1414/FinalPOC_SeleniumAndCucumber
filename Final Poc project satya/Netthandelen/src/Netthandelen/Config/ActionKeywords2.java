package Netthandelen.Config;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import Netthandelen.Databse.Database;
import Netthandelen.ExecutionEngine.DriverScript;
import Netthandelen.Utility.ExcelUtils;
import Netthandelen.Utility.Log;

public class ActionKeywords2 {

	//private static final boolean True = false;

	public static WebDriver driver;

	public static String odr;
	public static String OderIdfinl;

	public static void openBrowser() {
		try {
			DriverScript.pass = 0;
			DriverScript.fail = 0;
			DriverScript.notexec = 0;
			
			//driver = new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver", Constants.DriverPath);
			driver = new ChromeDriver();
			Log.info("Opening Browser");

		} catch (Exception e) {
		} finally {
			String ScreenshotName = Scrnshot.takeScreen(1, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}

	}

	public static void navigate() throws InterruptedException 
	{
		try 
		{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.navigate().to(Constants.URL);
				driver.manage().window().maximize();
				Log.info("Navigating to URL");
	
				Thread.sleep(5000);
	
				driver.findElement(
						By.xpath("//img[@src='//s3.amazonaws.com/static.barilliance.com/img/close_buttons/close2_32.png']"))
						.click();
				Log.info("Closing Popup displayed on screen");
		} catch (Exception e) {} 
		finally {
				String ScreenshotName = Scrnshot.takeScreen(2, 3, Constants.Sheet_TestSteps);
				Screenshots.captureScreenshot(driver, ScreenshotName);
		}		
	}

	public static void click_Registrer() {

		try {
			driver.findElement(By.className("register-link")).click();

			Log.info("Click on Register Link to register new User");

		

			Thread.sleep(5000);
		
		} catch (Exception e) {}
		
		finally
		{
			String ScreenshotName = Scrnshot.takeScreen(3, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}

	}

		public static void registration_Details() throws Exception {
	
			try{
				ExcelUtils.setExcelFile(Constants.sPath);
		
				WebElement firstName = driver.findElement(By.id("txt-first-name"));
				WebElement lastName = driver.findElement(By.id("txt-last-name"));
				WebElement email = driver.findElement(By.id("txt-email"));
				WebElement address = driver.findElement(By.id("txt-address"));
				WebElement password = driver.findElement(By.id("txt-password"));
				WebElement postNumber = driver.findElement(By.id("txt-post-number"));
				WebElement mobileNumber = driver.findElement(By.id("txt-mobile-number"));
		
				firstName.sendKeys(ExcelUtils.getCellData(1, 1, Constants.Sheet_TestRegistration));
				lastName.sendKeys(ExcelUtils.getCellData(2, 1, Constants.Sheet_TestRegistration));
				email.sendKeys(ExcelUtils.getCellData(3, 1, Constants.Sheet_TestRegistration));
				password.sendKeys(ExcelUtils.getCellData(4, 1, Constants.Sheet_TestRegistration));
				address.sendKeys(ExcelUtils.getCellData(5, 1, Constants.Sheet_TestRegistration));
				postNumber.sendKeys(ExcelUtils.getCellData(6, 1, Constants.Sheet_TestRegistration));
				mobileNumber.sendKeys(ExcelUtils.getCellData(7, 1, Constants.Sheet_TestRegistration));
		
				Log.info("Filling all the user details to Register");
		
				Thread.sleep(3000);
	
			
			
			}catch(Exception e)
			{}finally
			{
				String ScreenshotName = Scrnshot.takeScreen(4, 3, Constants.Sheet_TestSteps);
				Screenshots.captureScreenshot(driver, ScreenshotName);
			}
		}

	public static void click_Registrerbtn() throws InterruptedException {
		try {

			Log.info("Checking Register button status");

			System.out.println(driver.findElement(By.id("btn-register")).isEnabled());

			driver.findElement(By.id("btn-register")).click();
			Log.info("Click on Register button and submitting details for Registration ");
			Thread.sleep(5000);

			
		} catch (InterruptedException e) {}
		
		finally
		{
			String ScreenshotName = Scrnshot.takeScreen(5, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
	}

	public static void click_Verify() throws ClassNotFoundException, SQLException, InterruptedException {

		try {
				String smsValue = Database.verification();
	
				Thread.sleep(10000);
	
				driver.findElement(By.id("txt-code")).sendKeys(smsValue);
	
				Log.info("Filling Verification code from Database");
				Thread.sleep(3000);
	
				driver.findElement(By.id("btn-validate")).click();
	
				Log.info("Click on Verification button and move to home page");
	
				Thread.sleep(5000);
		} catch (InterruptedException e) {} 
		 
		finally {
			String ScreenshotName = Scrnshot.takeScreen(6, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}

	}

	public static void click_MinSide() throws InterruptedException {
		try{
			WebElement min = driver.findElement(By.xpath("//ul[@class='nav-header nav-profile style-compact style-invert']/li[2]/a/span[contains(text(),'side')]"));
	
			
			Log.info("Goto My side page and checking for Logout button");
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
	
			js.executeScript("var evt = document.createEvent('MouseEvents');"+ "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
					+ "arguments[0].dispatchEvent(evt);", min);
		}catch(Exception e)
		{}finally
		{
			String ScreenshotName = Scrnshot.takeScreen(7, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
	}

	public static void click_LogoutBtn() {
		try {

			driver.findElement(By.xpath("//a[(@href='/logout')] ")).click();
			Log.info("Click on Logout button");
		}
		
		catch(Exception e)
		{}
		finally {
			String ScreenshotName = Scrnshot.takeScreen(8, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
	}

	public static void click_Login() throws Exception {

		try {
			driver.findElement(By.xpath("//a[@class='login-link loginPopup-modal']")).click();

			Log.info("Click on Login button and Login Pop up will appear");

			// Screenshots.captureScreenshot(driver,Constants.LoginPage);

			//ExcelUtils.setExcelFile(Constants.sPath);

			String Username = ExcelUtils.getCellData(1, 0, Constants.Sheet_TestLogin);
			String Password = ExcelUtils.getCellData(1, 1, Constants.Sheet_TestLogin);

			driver.findElement(By.id("Email")).sendKeys(Username);
			driver.findElement(By.id("Password")).sendKeys(Password);

			Log.info("Filling User credential Login and Password");

			Thread.sleep(5000);
			driver.findElement(By.id("LoginButton")).click();
			Log.info("Click on Login button");

		} catch (Exception e) {
		} finally {
			String ScreenshotName = Scrnshot.takeScreen(9, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
		// ExcelUtils.setExcelFile(Constants.sPath);

	}

	public static void waitFor() throws Exception {
		Thread.sleep(5000);
		Log.info("Wait for 5 seconds");
	}

	public static void bidItems() throws InterruptedException, AWTException {
		
		try{
			
		
			Thread.sleep(5000);
	
			Log.info("Home page is appear");
	
			WebElement bid = driver.findElement(By.xpath("//a[@class='button action']"));
	
			Log.info("Click on Bidding link");
	
			bid.click();
	
			Thread.sleep(5000);
	
			/*WebElement BidTimer = driver.findElement(By.xpath("//span[@id='auctioncountdown']"));
	
			String val = BidTimer.getText();
	
			System.out.println(val);
	
			
			 * int actualVal = Integer.parseInt(val);
			 * 
			 * System.out.println(actualVal);
			 
	
			// WebElement GiBid = driver.findElement(By.id("btnBid"));
	
			if (driver.findElement(By.id("btnBid")).isEnabled()) {
	
				Log.info("After select a biditem click on Bidding button");
	
				driver.findElement(By.id("btnBid")).click();
				// GiBid.click();
	
				
				 * Alert alert1 = driver.switchTo().alert();
				 * 
				 * if(alert1 != null){ alert1.accept(); }
				 
			}
	
			else {
	
				driver.navigate().back();
	
				driver.navigate().refresh();
	
				bid.click();
				driver.findElement(By.id("btnBid")).click();
			}
		*/
		/*	if(!driver.findElement(By.id("btnBid")).isEnabled()){
				
				driver.navigate().back();
				
				driver.navigate().refresh();
	
				bid.click();
			}*/
			
			if(driver.findElements(By.xpath("//span[text()='Velg']")).size() != 0){
			    
			    	  driver.findElement(By.xpath("//span[text()='Velg']")).getText().equalsIgnoreCase("Velg");
			    
			    
			    	  WebElement element =driver.findElement(By.cssSelector("span.select2-selection__arrow"));
			    
			    	  element.click();
			          Actions act = new Actions(driver);
			          act.sendKeys(Keys.chord(Keys.ENTER)).perform();
			          
			          WebElement GiBid = driver.findElement(By.id("btnBid"));
			          
			          GiBid.click();
			          
			           Alert alert = driver.switchTo().alert();
			           alert.accept();
			           
			           String actualText=driver.findElement(By.xpath(".//*[@id='auction-message']/div/p")).getText().trim();
			     
			           System.out.println(actualText);
			       } 
			    

			    else{
				WebElement BidTimer = driver.findElement(By.xpath("//span[@id='auctioncountdown']"));

				String val = BidTimer.getText();
				
				System.out.println(val);
				if (val.length() <= 6) {
					String str1 = val.substring(val.length() - 6, val.length() - 5);
					String str2 = val.substring(val.length() - 3, val.length() - 1);

					try {
						Integer x = Integer.valueOf(str1);
						if (x == 0) {

							Integer y = Integer.valueOf(str2);
							if (y <= 20) {
								Thread.sleep(5000);
								driver.navigate().back();
								
								driver.navigate().refresh();
								
								bid.click();
								
								Thread.sleep(10000);
								
								bidItems();
								
							}
						}

					} catch (NumberFormatException e) {

					}
				} else {

					/*
					 * int actualVal = Integer.parseInt(val);
					 * 
					 * System.out.println(actualVal);
					 */

					WebElement GiBid = driver.findElement(By.id("btnBid"));
					GiBid.click();

					try {
						Alert alert = driver.switchTo().alert();
						alert.accept();
					} catch (Exception e) {
					}

					/*
					 * if(isAlertpresent()){
					 * 
					 * driver.switchTo().alert().accept();
					 * 
					 * }
					 */

				}

			    }
			
		  

		}catch(Exception e){}
		
		finally
		{
			String ScreenshotName = Scrnshot.takeScreen(10, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
	}

	public static void createOrder() throws Exception {
		try{



		Log.info("Creating order from backend");

		String AuctionId = driver.getCurrentUrl();

		String AuctionIddone = AuctionId.substring(AuctionId.lastIndexOf('/', AuctionId.length()) + 1,
				AuctionId.length());

		Log.info("Opening new Tab to put backend URL");

		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		/*String uname = "venkata.rao";
		String pwd = "Yaswanth21";*/


		String AuctionWeb = Constants.AuctionURL;

		String AuctionWeburl = "http://" + Constants.UserName + ":" + Constants.Password + "@" + AuctionWeb;
		
		/*String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.cssSelector("body")).sendKeys(selectLinkOpeninNewTab);*/
		/*JavascriptExecutor jsx = (JavascriptExecutor) driver;

		jsx.executeScript("function newTab() {var form = document.createElement('form');form.method = 'GET';form.action = " +AuctionWeburl+" ;form.target = '_blank';document.body.appendChild(form);");
*/		
		//WebDriver driver = new FirefoxDriver();
		
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		WebElement link = driver.findElement(By.cssSelector("body"));
		Actions builder = new Actions(driver);
		Action openLinkInNewTab = builder
		         .moveToElement(link)
		         .sendKeys(link, Keys.CONTROL+"t")
		         .click(link)
		         .keyUp(Keys.CONTROL)
		         .build();

		
		
		//Executions.getCurrent().sendRedirect(url, "_blank");
		openLinkInNewTab.perform();		
		//Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
		String parentHandle = driver.getWindowHandle();

		Set<String> winHandles = driver.getWindowHandles();

		System.out.println(winHandles);

		Log.info("Handling window");

		for (String currentWindowHandle : winHandles) {

			if (!currentWindowHandle.equals(parentHandle)) {

				driver.switchTo().window(currentWindowHandle);
				driver.navigate().to(AuctionWeburl);

			}
		}
		
	/*	driver.navigate().to("http://test.netthandelen.no:6100/1/Auction/AuctionSearch/");
		
		Runtime.getRuntime().exec("D:\\Authentication\\Auction.exe");
*/
		/*String uname = "venkata.rao";
		String pwd = "Yaswanth21";

		String AuctionWeb = Constants.AuctionURL;

		String AuctionWeburl = "http://" + uname + ":" + pwd + "@" + AuctionWeb;*/

		Log.info("Opening Auction URL to create order");
		//driver.navigate().to(AuctionWeburl);

		Thread.sleep(5000);

		System.out.println(AuctionIddone);

		driver.findElement(By.id("ctl11_txtAuctionId")).sendKeys(AuctionIddone);

		driver.findElement(By.id("ctl11_rbPeriodNone")).click();

		Log.info("Filling orederId and searching created order");

		driver.findElement(By.id("ctl11_btnSearch")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='ctl11_lvAuctions_Image1_0']")).click();

		Thread.sleep(3000);

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));

		System.out.println(iframeElements);

		Log.info("New fram is appeared");
		driver.switchTo().frame(0);

		driver.findElement(By.id("ctl03_btnEnd")).click();

		Log.info("Closing running Auction");

		Alert alert = driver.switchTo().alert();
		alert.accept();

		Log.info("Closing popup after creating order");

		driver.switchTo().defaultContent();

		driver.switchTo().frame(0);

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='ctl03_btnCancel']")).click();

		Log.info("Closing Iframe");

		driver.switchTo().defaultContent();

		String ScreenshotName = Scrnshot.takeScreen(11, 3, Constants.Sheet_TestSteps);
		Screenshots.captureScreenshot(driver, ScreenshotName);

		Thread.sleep(3000);

		Log.info("Navigating to URL to search customer details ");

		driver.navigate().to("http://test.netthandelen.no:6100/1/Customer/CustomerSearch/");

		/*
		 * WebElement OrederCreat=
		 * driver.findElement(By.xpath(".//*[@id='mydroplinemenu']/ul/li[4]/a"))
		 * ;
		 * 
		 * WebElement Oreder= driver.findElement(By.xpath(
		 * ".//*[@id='mydroplinemenu']/ul/li[4]/ul/li/div/div[1]/h2[2]/a"));
		 */

		Thread.sleep(3000);


		String Emialid = ExcelUtils.getCellData(1, 0, Constants.Sheet_TestLogin);

		driver.findElement(By.id("ctl11_txtNameEmail")).sendKeys(Emialid);
		Thread.sleep(3000);

		driver.findElement(By.id("ctl11_btnSearch")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='Fakturer nå']")).click();
		Thread.sleep(3000);

		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		Log.info("Order is created");

		driver.close();

		Thread.sleep(3000);

		driver.switchTo().window(parentHandle);

		driver.findElement(By.xpath("//span[contains(text(),'Mine ordre')]")).click();
		Thread.sleep(3000);

		Log.info("Going to My order page");

		driver.navigate().refresh();

		driver.findElement(By.xpath(".//*[@id='table-orders']/tbody/tr/td[2]/a/span")).click();
		Thread.sleep(3000);

		Log.info("Click on Order created link");

		driver.findElement(By.xpath("//a[@class='button button-secondary button-large order-details']")).click();
		Thread.sleep(3000);

		Log.info("Click on Confirm order button");

		driver.findElement(By.xpath("//a[@class='button button-xlarge button-secondary style-block']")).click();
		Thread.sleep(3000);

		Log.info("Click on Submit order button");

		/*
		 * driver.findElement(By.xpath(
		 * "//a[@class='button button-secondary button-large order-details'][2]"
		 * )).click(); Thread.sleep(3000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//a[@class='button button-xlarge button-secondary style-block']"
		 * )).click(); Thread.sleep(3000);
		 */

		WebElement OderId = driver.findElement(By.xpath(".//*[@id='frm-checkout-success']/div/div/div/div[1]/div/h2/a/strong"));

		Log.info("Picking order id for payment");

		OderIdfinl = OderId.getText();

		System.out.println(OderIdfinl);

		OderId.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@class='button button-secondary button-large order-details'][2]")).click();

		Thread.sleep(3000);

		WebElement orderamount = driver.findElement(By.xpath("//span[@class='value text-success ng-binding']"));

		odr = orderamount.getText();

		Log.info("Picking order Amount");

		System.out.println(odr);

		driver.findElement(By.xpath("//a[@class='button button-xlarge button-secondary style-block']")).click();
		Thread.sleep(3000);

		Log.info("Click on Submit oder for delivery");
		
		}catch(Exception e)
		{String ScreenshotName=Scrnshot.takeScreen(11, 3,Constants.Sheet_TestSteps);			
		Screenshots.captureScreenshot(driver,ScreenshotName);}
		
		finally
		{
			String ScreenshotName=Scrnshot.takeScreen(11, 3,Constants.Sheet_TestSteps);			
			Screenshots.captureScreenshot(driver,ScreenshotName);
		}

	}

	public static void payment() throws Throwable {
		try{

		Log.info("Opening new tab to manual payment");

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		Thread.sleep(5000);

		String parentHandle1 = driver.getWindowHandle();

		Set<String> winHandles1 = driver.getWindowHandles();

		System.out.println(winHandles1);
		for (String currentWindowHandle1 : winHandles1) {
			if (!currentWindowHandle1.equals(parentHandle1)) {

				driver.switchTo().window(currentWindowHandle1);
				// System.out.println(sEmailAddress);

				//ExcelUtils.setExcelFile(Constants.sPath);

				String AppUserName = ExcelUtils.getCellData(0, 1, Constants.Sheet_LoginApp);
				String AppPassword = ExcelUtils.getCellData(1, 1, Constants.Sheet_LoginApp);

				/*
				 * String uname1 = "venkata.rao"; String pwd1 = "Yaswanth21" ;
				 */

				String PaymentLink = Constants.PaymentURL;

				String PaymentlinkOpen = "http://" + AppUserName + ":" + AppPassword + "@" + PaymentLink;

				Log.info("Navigate to payment URL");

				driver.navigate().to(PaymentlinkOpen);

				Thread.sleep(5000);

				driver.findElement(By.id("ctl11_txtOrderId")).sendKeys(OderIdfinl);

				Log.info("Filling orderId");

				driver.findElement(By.id("ctl11_txtFromAccount")).sendKeys("22112211221");

				Log.info("Filling Account number to payment");

				driver.findElement(By.id("ctl11_txtValue")).sendKeys(odr);

				driver.findElement(By.id("ctl11_txtFileName")).sendKeys("NH_" + odr);

				driver.findElement(By.id("ctl11_btnAdd")).click();

				Log.info("Click on submit button");

				
				driver.close();

				// Screenshots.captureScreenshot(driver,Constants.PaymentConfirmationorder);

			}

		}

		}catch(Exception e)
		{}finally
		{
			String ScreenshotName = Scrnshot.takeScreen(12, 3, Constants.Sheet_TestSteps);
			Screenshots.captureScreenshot(driver, ScreenshotName);
		}
	}

	public static boolean failed_Login() throws Exception {
		boolean flag = false;
		driver.findElement(By.xpath("//a[@class='login-link loginPopup-modal']")).click();

		Log.info("Click on Login button and Login Popup will appear");

		ExcelUtils.setExcelFile(Constants.sPath);

		String Username = ExcelUtils.getCellData(2, 0, Constants.Sheet_TestLogin);
		String Password = ExcelUtils.getCellData(2, 2, Constants.Sheet_TestLogin);

		driver.findElement(By.id("Email")).sendKeys(Username);
		driver.findElement(By.id("Password")).sendKeys(Password);
		flag = true;
		Log.info("Filling User credential Login and Password");

		Thread.sleep(5000);
		driver.findElement(By.id("LoginButton")).click();

		Log.info("User should not be Login button");

		return flag;

	}

	/*
	 * public static void report(){
	 * 
	 * 
	 * //driver=new FirefoxDriver();
	 * //driver.get("https://test.netthandelen.no:7014/register");
	 * 
	 * }
	 */
	public static void closeBrowser() {

		driver.quit();
		Log.info("Closing the browser");
	}

}
