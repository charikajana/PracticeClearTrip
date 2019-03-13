package com.cleartrip.browserutils;




import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cleartrip.applicationConstants.ApplicationConstants;
import com.cleartrip.fileOperationsutil.LoadProperties;


public class BrowserFactory {	
	public static WebDriver driver;
	static Logger log=Logger.getLogger("BrowserFactory");
	
	public static WebDriver getdesiredbrowser() throws IOException{
		try{
			switch(LoadProperties.getDerivedProperty(ApplicationConstants.BROWSER).toUpperCase()){
			case"CHROME":
				log.info("Chrome Browser is going to launch");
				driver=BrowserFactory.chrome();
				break;
			case"FIREFOX":
				log.info("FIREFOX Browser is going to launch");
				driver=BrowserFactory.firefox();
				break;
			case"IE":
				log.info("IE Browser is going to launch");
				driver=BrowserFactory.IE();
				break;
				default:
					driver=BrowserFactory.chrome();
					break;		
			}
		}catch(Exception exception){
			
		}
		driver.get(LoadProperties.getDerivedProperty(ApplicationConstants.URL));
		return driver;
		
	}
	public static WebDriver chrome(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ();      
		handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);		
		driver=new ChromeDriver();
		log.info("Opening the browser");
		driver.manage().window().maximize();
		log.info("Maximize the Browser");
		return driver;
	}
	public static WebDriver firefox(){
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		driver = new FirefoxDriver();
		log.info("Opening the browser");	
		driver.manage().window().maximize();
		log.info("Maximize the Browser");
		return driver;
		
	}
	public static WebDriver IE(){
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		
		driver = new InternetExplorerDriver();	
		log.info("Opening the browser");
		driver.manage().window().maximize();
		log.info("Maximize the Browser");
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		driver.findElement(By.id("overridelink")).click();
		
	
		return driver;
		
	}
	


}
