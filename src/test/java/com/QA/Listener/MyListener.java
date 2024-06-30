package com.QA.Listener;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.QA.Util.ExtendReportUtility;
import com.QA.Util.UtilityClass;

import com.aventstack.extentreports.Status;

public class MyListener implements ITestListener {

	public static String captureCurrentTime() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime currentTime = LocalDateTime.now();
		String formatedTime = currentTime.format(dateTimeFormatter);
		return formatedTime;

	}

	
	public void onTestStart(ITestResult result) {
	    

		  String testName = result.getMethod().getMethodName();
		  ExtendReportUtility.logger=  ExtendReportUtility.createReport(testName);
		  
		  ExtendReportUtility.logger.log(Status.INFO, testName + " is Started at :" + captureCurrentTime());
	  }

	  public void onTestSuccess(ITestResult result) {
	    
		  String testName = result.getMethod().getMethodName();
		  ExtendReportUtility.logger=  ExtendReportUtility.createReport(testName);
		  try {
				UtilityClass.getScreenShot(result.getTestName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  ExtendReportUtility.logger.log(Status.INFO, testName + " is Passed at :" + captureCurrentTime());
	  }

	  public void onTestFailure(ITestResult result) {
	    
		  String testName = result.getMethod().getMethodName();
		  ExtendReportUtility.logger=  ExtendReportUtility.createReport(testName);
		  try {
				UtilityClass.getScreenShot(result.getTestName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  ExtendReportUtility.logger.log(Status.INFO, testName + " is Failed at :" + captureCurrentTime());
			ExtendReportUtility.logger.log(Status.INFO, testName + " is Failed at :" + result.getThrowable());
	  }

	  public void onTestSkipped(ITestResult result) {
		  String testName = result.getMethod().getMethodName();
		  ExtendReportUtility.logger=  ExtendReportUtility.createReport(testName);
	    try {
			UtilityClass.getScreenShot(result.getTestName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ExtendReportUtility.logger.log(Status.INFO, testName + " is Skipped");
	  }

	  

	  

	  public void onStart(ITestContext context) {
	    ExtendReportUtility.initExtendReport();
	  }

	 
	  public void onFinish(ITestContext context) {
	   ExtendReportUtility.generateReport();
	  }
	
}
