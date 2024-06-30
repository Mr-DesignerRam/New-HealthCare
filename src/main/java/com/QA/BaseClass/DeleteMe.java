package com.QA.BaseClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteMe {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.openmrs.org/openmrs/login.htm");
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		
		 
		 List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));
		 
		 for(WebElement ele:list) {
			 
			 System.out.println(ele.getText());
		 }
	}
}
