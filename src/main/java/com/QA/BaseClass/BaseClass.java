package com.QA.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static String projectPath=System.getProperty("user.dir"); 
	
	public static void launchBrowser() throws IOException {
	
		FileInputStream fis = new FileInputStream(projectPath+"\\src\\test\\resources\\Data.properties");
		prop= new Properties();
		 prop.load(fis);

		 driver = new ChromeDriver();
		 driver.get(prop.getProperty("WebsiteUrl"));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 
		 
		 
	}
	
}
