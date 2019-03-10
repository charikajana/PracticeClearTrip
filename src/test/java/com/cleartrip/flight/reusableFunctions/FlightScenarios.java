package com.cleartrip.flight.reusableFunctions;


import com.cleartrip.webdriverintractions.WebDriverIntialization;

public class FlightScenarios {
	public WebDriverIntialization webDriverIntialization;
	public FlightScenarios(){
		webDriverIntialization=new WebDriverIntialization();
	}
	
	public void SearchwithOnewayFlight() {		
		webDriverIntialization.click("com.cleartrip.flight.oneway.radioButton");	
		webDriverIntialization.implecitwait();
		webDriverIntialization.Send_Keys("com.cleartrip.flight.oneway.FromTag", "Bangalore, IN - Kempegowda International Airport (BLR)");			
		webDriverIntialization.Send_Keys("com.cleartrip.flight.oneway.ToTag", "Hyderabad, IN - Rajiv Gandhi International (HYD)");
		webDriverIntialization.click("com.cleartrip.flight.oneway.DepartDate");	
		webDriverIntialization.ExlicitWait("com.cleartrip.flight.oneway.CalenderDate");
		webDriverIntialization.click("com.cleartrip.flight.oneway.CalenderDate");
		webDriverIntialization.implecitwait();
		webDriverIntialization.click("com.cleartrip.flight.oneway.SearchBtn");	
	}
	public void SearchRoundTripFlight() {		
		webDriverIntialization.click("com.cleartrip.flight.roundtrip.radioButton");	
		webDriverIntialization.implecitwait();
		webDriverIntialization.Send_Keys("com.cleartrip.flight.roundtrip.FromTag", "Bangalore, IN - Kempegowda International Airport (BLR)");			
		webDriverIntialization.Send_Keys("com.cleartrip.flight.roundtrip.ToTag", "Hyderabad, IN - Rajiv Gandhi International (HYD)");
		webDriverIntialization.click("com.cleartrip.flight.roundtrip.DepartDate");	
		webDriverIntialization.ExlicitWait("com.cleartrip.flight.roundtrip.CalenderDate");
		webDriverIntialization.click("com.cleartrip.flight.roundtrip.CalenderDate");
		webDriverIntialization.implecitwait();
		webDriverIntialization.click("com.cleartrip.flight.roundtrip.ReturnDate");	
		webDriverIntialization.ExlicitWait("com.cleartrip.flight.roundtrip.ReturnCalenderDate");
		webDriverIntialization.click("com.cleartrip.flight.roundtrip.ReturnCalenderDate");
		webDriverIntialization.implecitwait();
		webDriverIntialization.click("com.cleartrip.flight.oneway.SearchBtn");	
	}
	
	

	

	

	
	
	
	
	
	
	
	

}
