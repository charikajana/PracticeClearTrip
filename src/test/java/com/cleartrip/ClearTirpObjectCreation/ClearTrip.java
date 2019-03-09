package com.cleartrip.ClearTirpObjectCreation;


import com.cleartrip.flight.reusableFunctions.FlightScenarios;
import com.cleartrip.webdriverintractions.WebDriverIntialization;

public class ClearTrip {
	public  WebDriverIntialization webdriverintialization;
	public  FlightScenarios flightscenarios;
	
	
	
	
	
	public ClearTrip(){
		webdriverintialization=new WebDriverIntialization();
		flightscenarios=new FlightScenarios();
		
		
		
		
		
	}

}
