package commonfunctions;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;




public class BrowserManagement1 {
	
	
	public WebDriver driver;
	
	public DesiredCapabilities capability = null; 
	
	public BrowserManagement1(String sBrowser)
	{
		capability = new DesiredCapabilities();
		//Browser Capability
		
		//if(sBrowser.toLowerCase().contains("iexplore11".toLowerCase()))
		if(sBrowser.equalsIgnoreCase("chrome"))
		{
			capability = DesiredCapabilities.chrome();
			
		}
		else if(sBrowser.equalsIgnoreCase("ie"))
			
		{
			
			System.setProperty("webdriver.ie.driver", "C:\\JAVA_PROJECTS\\Demo\\Libs\\IEDriverServer.exe");
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			WebDriver driver = new InternetExplorerDriver(dc);
			//capability = DesiredCapabilities.internetExplorer();
			capability.setCapability("ignoreZoomSetting", true);
	    	//capability.setBrowserName("iexplore");
	     	
	      	//capability.setVersion("10");
	        //capability.setPlatform(Platform.WINDOWS);
	      	
	      	//capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	    	//capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    	//capability.setJavascriptEnabled(true);
	    	
	    	
	    	
	    	
	    	//capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		    driver= new InternetExplorerDriver(capability);
				
			

		}		
		else
		{
			capability = DesiredCapabilities.firefox();
			
		}		
	}
}
