package com.QA.Util;


import com.QA.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility extends BaseClass{

	public static ExtentReports extentReports;
	public static ExtentSparkReporter extentSparkReporter;
	
	public static ExtentTest logger;
	
	
	public static void initExtendReport() {
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter(projectPath+"\\ExtendReport\\HealthCareReport.html");
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void generateReport() {
		extentReports.flush();
	} 
	
	
	public static ExtentTest createReport(String testName) {
		return extentReports.createTest(testName);
	}  

}
