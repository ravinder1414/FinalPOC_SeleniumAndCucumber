package Netthandelen.Utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Netthandelen.Config.Constants;

public class Authentication {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		driver= new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", Constants.DriverPath);
		//driver = new ChromeDriver();
		
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		
		driver.get("http://test.netthandelen.no:6100/1/Auction/AuctionSearch/");
		
		Runtime.getRuntime().exec("D:\\Authentication\\Auction.exe");
		
		
		//driver.get("http://test.netthandelen.no:6100/1/Auction/AuctionSearch/");
	
	
		
		
	}

}
