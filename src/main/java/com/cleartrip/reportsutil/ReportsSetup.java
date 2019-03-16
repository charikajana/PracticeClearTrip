package com.cleartrip.reportsutil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

	public class ReportsSetup {
		public static String EmailableReportsPath;
		public static String ScreenShotspath;
		public static String timeStamp;
		public static void reportsfileCreation() {
			String pattern = "ddMMM";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			
			String pattern1 = "HH:MM:ss.S";
			simpleDateFormat = new SimpleDateFormat(pattern1);
			timeStamp = simpleDateFormat.format(new Date());
			timeStamp=timeStamp.replaceAll(":","_").replace(".","");

			
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
			reportsfileCreation();
		}

	}


