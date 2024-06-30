package com.QA.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
	
	public static Properties prop;
	public static String projectPath=System.getProperty("user.dir"); 
	public static void getData() throws IOException {
		FileInputStream fis = new FileInputStream(projectPath+"\\src\\test\\resources\\Data.properties");
		prop= new Properties();
		 prop.load(fis);
		
	}

}
