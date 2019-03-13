package com.cleartrip.webdriverintractions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.browserutils.BrowserFactory;

public class WebDriverIntialization {
	WebDriver driver;
	Logger log=Logger.getLogger("WebDriverInitialization");
	
	public WebDriver getCurrentDriver() {
		if (driver == null) {
			log.info("driver object is going to be create");
			
			try {
				driver = BrowserFactory.getdesiredbrowser();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

	public WebElement Find_Element(String key) {
		WebElement wb=null;
		try {
			log.info("Find element is:"+key);
            wb=getCurrentDriver().findElement(BY.getByObject(key));
		}catch(Exception e) {
			log.error(""+e.getMessage());
			e.printStackTrace();
		}
		return wb;
	}
	
	public List<WebElement> Find_Elements(String key) {
		List<WebElement> listofwebElements=null;
		try {
			log.info("Find elements is:"+key);
		 listofwebElements=getCurrentDriver().findElements(BY.getByObject(key));
		}catch(Exception e) {
			log.error(""+e.getMessage());
			e.printStackTrace();
		}
		return listofwebElements;
	}
	public void click(String key) {
		try {
			log.info("Click on Webelements is:"+key);
			Find_Element(key).click();
		}catch(Exception e) {
			log.error(""+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void Send_Keys(String key,String inputarg) {
		try {
			log.info("Sending the input data:"+key);
			Find_Element(key).sendKeys(inputarg);
		}catch(Exception e) {
			log.error(""+e.getMessage());
		}
			
		
	}
	public void implecitwait() {
		log.info("Wait for the webelement implecitwait :");
		getCurrentDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	public void ExlicitWait(String key) {
		log.info("Wait for the webelement ExlicitWait :"+key);
		WebDriverWait wait=new WebDriverWait(getCurrentDriver(), 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(BY.getByObject(key)));
		
	}
	
	
	
	

}
