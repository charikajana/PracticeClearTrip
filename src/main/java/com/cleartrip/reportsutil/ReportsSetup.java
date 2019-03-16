package com.cleartrip.reportsutil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class ReportsSetup {
		public static String EmailableReportsPath;
		public static String ScreenShotspath;
		
		public static String timeStamp,timeS;
		
		public static String htmlReport=System.getProperty("user.dir")+"/src/test/resources/EmailReport/AutomatoinExtentReport.html";
		public static ExtentTest test,TestSuite;		
		public static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlReport);
		public static ExtentReports reports;
		
		
		
		public static void createExtentReport() throws IOException {
			File f=new File(htmlReport);
			if(!f.exists()) {
				f.createNewFile();
			}
			reports= new ExtentReports();
			reports.attachReporter(htmlReporter);

		}
			
		
		public static void reportsfileCreation() {
			String pattern = "ddMMM";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			
			String pattern1 = "HH:mm:ss.S";
			simpleDateFormat = new SimpleDateFormat(pattern1);
			timeStamp = simpleDateFormat.format(new Date());
			timeStamp=timeStamp.replaceAll(":","_").replace(".","_");

			
			String ReportsFolder=System.getProperty("user.dir")+"\\Reports\\";
			File f=new File(ReportsFolder);
			if(!f.exists()) {
				f.mkdir();
			}
			f=new File(ReportsFolder+"/"+date);
			if(!f.exists()) {
				f.mkdir();
			}
			f=new File(ReportsFolder+"/"+date+"/AutomationReports_"+timeStamp);
			if(!f.exists()) {
				f.mkdir();
			}
			EmailableReportsPath=ReportsFolder+"/"+date+"/AutomationReports_"+timeStamp+"/EmailableReports";
			f=new File(EmailableReportsPath);
			if(!f.exists()) {
				f.mkdir();
			}
			ScreenShotspath=ReportsFolder+"/"+date+"/AutomationReports_"+timeStamp+"/Screenshots";
			f=new File(ScreenShotspath);
			if(!f.exists()) {
				f.mkdir();
			}
		}
		public static void main(String[] args) {
			String pattern = "ddMMM";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			String pattern1 = "HH:mm:ss.S";
			simpleDateFormat = new SimpleDateFormat(pattern1);
			timeStamp = simpleDateFormat.format(new Date());
			timeStamp=timeStamp.replaceAll(":","_").replace(".","_");
			System.out.println(timeStamp);
		}
		

	}


