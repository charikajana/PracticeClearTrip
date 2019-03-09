package com.cleartrip.webdriverintractions;

import org.openqa.selenium.By;

import com.cleartrip.fileOperationsutil.LoadProperties;

public class BY {
	
	static By by;
	public static By getByObject(String key) {
		try {
			String bylocator=LoadProperties.getDerivedProperty(key);
			String locator=bylocator.split(";")[0];
			String locatorValue=bylocator.split(";")[1];
			switch(locator.toUpperCase()) {
			
			case "ID":
				by=By.id(locatorValue);
				break;
			case "NAME":
				by=By.name(locatorValue);
				break;
			case "CLASSNAME":
				by=By.className(locatorValue);
				break;				
			case "TAGNAME":
				by=By.tagName(locatorValue);
				break;
			case "LINKTEXT":
				by=By.linkText(locatorValue);
				break;			
			case "PARTIALLINKTEXT":
				by=By.partialLinkText(locatorValue);
				break;
			case "XPATH":
				by=By.xpath(locatorValue);
				break;			
			case "CSSSELECOTR":
				by=By.cssSelector(locatorValue);
				break;		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return by;
		
	}
	
}
