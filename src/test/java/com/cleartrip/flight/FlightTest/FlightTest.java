package com.cleartrip.flight.FlightTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cleartrip.ClearTirpObjectCreation.ClearTrip;
import com.cleartrip.reportsutil.ReportsSetup;

public class FlightTest {
	ClearTrip cleartrip;
	
	@BeforeSuite
	public void beforemethod() {
		try {
			cleartrip=new ClearTrip();
			ReportsSetup.createExtentReport();
			ReportsSetup.TestSuite=ReportsSetup.reports.createTest("FlightTest");
			ReportsSetup.reportsfileCreation();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test() 
	public void searchFlightOnways() throws IOException {
		ReportsSetup.test=ReportsSetup.TestSuite.createNode("searchFlightOnways");
		cleartrip.flightscenarios.SearchwithOnewayFlight();
		ReportsSetup.test.log(Status.PASS, "Test Case Executed Successfully !");
					
		
	}
	//@Test()
	public void SearchRoundTripFlight() throws IOException {
		ReportsSetup.test=ReportsSetup.TestSuite.createNode("SearchRoundTripFlight");
		cleartrip.flightscenarios.SearchRoundTripFlight();
		ReportsSetup.test.log(Status.PASS, "Test Case Executed Successfully !");
		
	}
	//@Test
	public void SearchMulticityFlight() throws IOException {
		ReportsSetup.test=ReportsSetup.TestSuite.createNode("SearchMulticityFlight");
		cleartrip.flightscenarios.SearchMulticityFlight();
		ReportsSetup.test.log(Status.PASS, "Test Case Executed Successfully !");
		
	}
	
	@AfterSuite
	public void aftermethod() throws IOException {
		ReportsSetup.reports.flush();
		FileUtils.copyFileToDirectory(new File(ReportsSetup.htmlReport), new File(ReportsSetup.EmailableReportsPath));
	}

}
