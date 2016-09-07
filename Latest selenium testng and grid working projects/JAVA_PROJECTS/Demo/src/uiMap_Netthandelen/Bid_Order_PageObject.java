package uiMap_Netthandelen;

	 

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	//Import files
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;



	public class Bid_Order_PageObject {
			
	public Bid_Order_PageObject(WebDriver driver) {
				
				//Initialize A Bid_orderPageObjects.
				PageFactory.initElements(driver, this);
			}
			
		
			//Bid selection button
			@FindBy(how=How.XPATH, using="//a[@class='button action']")
			
			public WebElement btnBidSelection;
			
			
			//Bid Timer
			
          @FindBy(how=How.XPATH, using="//span[@id='auctioncountdown']")
			
			public WebElement bidTimer;
			
			
			
			
			//Bid button
			
			
					@FindBy(how=How.XPATH, using=".//*[@id='btnBid']")
					public WebElement btnBid;
			
			//@FindBy(how=How.LINK_TEXT, using="Register")
			//public WebElement lnkRegister;
		                                               

			//Bid Added successful message
			@FindBy(how=How.XPATH, using=".//*[@id='auction-message']/div/p")
			public WebElement txtBidAddedSuccessful;
			
               //Order Details
			
			// Text box Auction id 
			@FindBy(how=How.ID, using= "ctl11_txtAuctionId")
			public WebElement txtAuctionId;
			
			//Auction id period none
			@FindBy(how=How.ID, using="ctl11_rbPeriodNone")
			public WebElement txtAuctionIdPeriodNone;
					
			//Button search
			@FindBy(how=How.ID, using="ctl11_btnSearch")
			public WebElement btnSearch;
			
			//Auction Images
			@FindBy(how=How.XPATH, using=".//*[@id='ctl11_lvAuctions_Image1_0']")
			public WebElement imgAuctions;
			
			//Button END
			@FindBy(how=How.ID, using="ctl03_btnEnd")
			public WebElement btnEnd;
			
			
			//Order Email address Text
			@FindBy(how=How.ID, using="ctl11_txtNameEmail")
			public WebElement txtOrderEmailAddress;
			
			
			// Order button search
			
			@FindBy(how=How.ID, using= "ctl11_btnSearch")
			public WebElement btnOrderSearch;
			
			
			
			//Search order
					@FindBy(how=How.XPATH, using= "//input[@value='Fakturer nå']")
					public WebElement lnkSearchOrder;
					
					
					//Mine Order Link
					
					@FindBy(how=How.XPATH, using= "//span[contains(text(),'Mine ordre')]")
					public WebElement lnkMineorder;
					
					
					
					//Order Link click
					
					@FindBy(how=How.XPATH, using=".//*[@id='table-orders']/tbody/tr[1]/td[2]/a/span")
					public WebElement lnkOrderNumbers;
					
					
					//Betal Ordern button
					
					
					
					@FindBy(how=How.XPATH, using="//a[@class='button button-secondary button-large order-details'][2]")
					public WebElement btnBetalOrdern;
					
					//Breakline baselie button
					@FindBy(how=How.XPATH, using=".//*[@id='main']/div[1]/div/div[2]/div[4]/a/span")
					public WebElement btnBreaklinebaseline;
					
					
					
					
					
					
					
					//Payment UI WebElement
					
					
					
					@FindBy(how=How.ID, using="ctl11_txtOrderId")
					public WebElement txtPaymentOrderID;
					
					
					
					
					
					//Payment Account
					
					@FindBy(how=How.ID, using="ctl11_txtFromAccount')]")
					public WebElement txtPaymentAccount;
					
					
					//Payment order value
					
					@FindBy(how=How.ID, using="ctl11_txtValue')]")
					public WebElement txtPaymentOrderValue;
					
					//Payment file name
					
					@FindBy(how=How.ID, using="ctl11_txtFileName')]")
					public WebElement txtPaymentFileName;
					
					//Payment Button Add
					
					@FindBy(how=How.ID, using="ctl11_btnAdd')]")
					public WebElement btnPaymentAdd;
					
					
					
					
					
					
					
					
					
					
		}




