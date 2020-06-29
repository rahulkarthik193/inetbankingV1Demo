package com.banking.Utilities;

//listener class used to generate extent report
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	 public void onStart(ITestContext testContext)
	 {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String repName = "Test-Report-"+timeStamp+".html";
		
		 htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent report/"+repName);
		 htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		 
		 
		 extent=new ExtentReports();
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Hostname","localhost");
		 extent.setSystemInfo("Environment","QA");
		 extent.setSystemInfo("User","Rahul");
		 
		 
		 htmlReporter.config().setDocumentTitle("InetbankingV1");
		 htmlReporter.config().setReportName("Functional Test Report");
		 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlReporter.config().setTheme(Theme.DARK);
	 }
	@Test
	 public void onTestSuccess(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		  
				 }
	@Test
	 public void onTestFailure(ITestResult tr)
	 {
		
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		 String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		 File f = new File(screenshotPath);
		 if(f.exists())
		 {
			 try {
				 logger.fail("Screenshot is below"+logger.addScreenCaptureFromPath(screenshotPath));
			 }
			 catch(IOException e)
			 {
				 e.printStackTrace();
			 }
			 }
			 }
	@Test
	 public void onTestSkipped(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	 }
	 @AfterClass
	 public void onFinish(ITestContext testContext)
	 {
		 extent.flush();
	 }
		 
}
