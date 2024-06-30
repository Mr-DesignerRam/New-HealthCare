package com.QA.Util;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.QA.BaseClass.BaseClass;

public class UtilityClass extends BaseClass {

	public static void setText(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void clickWebElement(WebElement ele) {
		ele.click();
	}
	
	public static void getScreenShot(String Testname) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(projectPath+"\\Screenshots\\"+Testname+"\\.png");
		 FileUtils.copyFile(src, dest);
		
		
	}
	
	
	
	public static Object[][] fetchDataFromExcel() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(projectPath + "\\src\\test\\resources\\LoginCrediential.xlsx");
		Sheet sheet = WorkbookFactory.create(fis).getSheet("LoginDetails");
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		
		Object obj[][] = new Object[lastRow][1];

		for (int i = 0; i < lastRow; i++) {
			
			HashMap<String, Object> data = new HashMap<String, Object>();

			int lastCol = sheet.getRow(i).getLastCellNum();
			System.out.println(lastCol);
			for (int j = 0; j < lastCol; j++) {

				String Heading = sheet.getRow(0).getCell(j).getStringCellValue();
				
				CellType ct = sheet.getRow(i+1).getCell(j).getCellType();
				
				if (ct.toString().equalsIgnoreCase("String")) {
					
					data.put(Heading, sheet.getRow(i+1).getCell(j).toString());
					
				} else {
					
					data.put(Heading, sheet.getRow(i+1).getCell(j).getNumericCellValue());
					
				}
			}
			obj[i][0]=data;
		}
		return obj;

		
	}
	
	
	

}
