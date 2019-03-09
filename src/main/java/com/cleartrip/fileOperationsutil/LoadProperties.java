package com.cleartrip.fileOperationsutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	static Properties prop=null;
	public static Properties loadProperties()throws IOException{
		if(prop==null){
			prop=new Properties();
			File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\");
			File[] fileArray=file.listFiles();
			for(int i=0;i<fileArray.length;i++){
				FileInputStream finput=new FileInputStream(fileArray[i]);
				prop.load(finput);
			}
		}
		return prop;		
	}
	public static String getDerivedProperty(String key) throws IOException{
		prop=loadProperties();
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(LoadProperties.getDerivedProperty("com.cleartrip.flight.oneway.radioButton"));
	}

}
