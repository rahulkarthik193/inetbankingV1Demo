package com.banking.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.Utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setUp(String br)
	{
		
		logger=Logger.getLogger("InetbankingV1");
		
		PropertyConfigurator.configure("log4j.properties");
	
		
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver2.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();*/
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.chromeDriver());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", readconfig.firefoxDriver());
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseUrl);
		 
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
