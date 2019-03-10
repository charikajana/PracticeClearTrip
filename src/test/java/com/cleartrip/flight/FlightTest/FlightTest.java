package com.cleartrip.flight.FlightTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.ClearTirpObjectCreation.ClearTrip;

public class FlightTest {
	ClearTrip cleartrip;
	
	@BeforeMethod
	public void beforemethod() {
		cleartrip=new ClearTrip();
	}
	
	@Test(enabled = false) 
	public void searchFlightOnways() {
		cleartrip.flightscenarios.SearchwithOnewayFlight();
	}
	@Test
	public void SearchRoundTripFlight() {
		cleartrip.flightscenarios.SearchRoundTripFlight();
	}

}
