package com.cleartrip.webdriverintractions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cleartrip.browserutils.BrowserFactory;
import com.cleartrip.reportsutil.ReportsSetup;

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
			ReportsSetup.test.log(Status.INFO,"Click on WebElement on ------> "+key);
			log.info("Click on Webelements is:"+key);
			Find_Element(key).click();
			ReportsSetup.test.log(Status.INFO, "" ,MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().toString()).build());			
			
		}catch(Exception e) {
			ReportsSetup.test.log(Status.FAIL,"Failed to Click on WebElement ------> "+key);
			try {
				ReportsSetup.test.log(Status.FAIL, "" ,MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().toString()).build());
			} catch (IOException e1) {
				e1.printStackTrace();
			}			
			log.error(""+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void Send_Keys(String key,String inputarg) {
		try {
			ReportsSetup.test.log(Status.INFO,"Sendig Test Data ------> "+inputarg);
			log.info("Sending the input data:"+key);
			Find_Element(key).sendKeys(inputarg);
		}catch(Exception e) {
			ReportsSetup.test.log(Status.FAIL,"Sendig Test Data ------> "+inputarg);
			log.error(""+e.getMessage());
		}
			
		
	}
	public void implecitwait() {
		ReportsSetup.test.log(Status.INFO,"Waiting for the Implecit wait until 60 Sec");
		log.info("Wait for the webelement implecitwait :");
		getCurrentDriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	public void ExlicitWait(String key) {
		try {
			ReportsSetup.test.log(Status.INFO,"Waiting for the Explicit wait until 60 Sec and looking for the webElement is "+key);
			log.info("Wait for the webelement ExlicitWait :"+key);
			WebDriverWait wait=new WebDriverWait(getCurrentDriver(), 60);
			wait.until(ExpectedConditions.presenceOfElementLocated(BY.getByObject(key)));
		}catch(Exception e) {
			ReportsSetup.test.log(Status.FAIL,"WebElement is not present for Explicit wait");
			e.printStackTrace();
		}
		
		
	}
	
	public String getScreenshot() {
		String pattern = "HH:MM:ss.S";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		simpleDateFormat = new SimpleDateFormat(pattern);
		String timeStamp = simpleDateFormat.format(new Date());
		timeStamp=timeStamp.replaceAll(":","_").replace(".","");
		File desitnation=new File (ReportsSetup.ScreenShotspath+"//"+timeStamp+".jpg");
		String currentScreenshotpath=desitnation.getAbsolutePath();
		try {
			File src=((TakesScreenshot)getCurrentDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,desitnation);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return currentScreenshotpath;
		
		
	}

	
	
	
	

}
