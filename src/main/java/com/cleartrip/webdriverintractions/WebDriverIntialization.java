package com.cleartrip.webdriverintractions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.browserutils.BrowserFactory;

public class WebDriverIntialization {
	WebDriver driver;
	
	
	public WebDriver getCurrentDriver() {
		if (driver == null) {
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
		WebElement wb=getCurrentDriver().findElement(BY.getByObject(key));
		return wb;
	}
	
	public List<WebElement> Find_Elements(String key) {
		List<WebElement> listofwebElements=getCurrentDriver().findElements(BY.getByObject(key));
		return listofwebElements;
	}
	public void click(String key) {
		Find_Element(key).click();
	}
	public void Send_Keys(String key,String inputarg) {
		Find_Element(key).sendKeys(inputarg);
	}
	public void implecitwait() {
		getCurrentDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	public void ExlicitWait(String key) {
		WebDriverWait wait=new WebDriverWait(getCurrentDriver(), 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(BY.getByObject(key)));
		
	}
	
	
	
	

}
