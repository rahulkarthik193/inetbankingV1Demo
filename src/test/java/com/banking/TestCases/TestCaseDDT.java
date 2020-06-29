package com.banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;
import com.banking.Utilities.XlUtils;

//import junit.framework.Assert;

public class TestCaseDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String name,String pass) throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(name);
		lp.setPassword(pass);
		lp.clickSubmit();
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			captureScreenshot(driver,"loginDDT");
			Assert.assertTrue(false);
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	
	String[][]getData() throws IOException
	{
		String path="G:/eclipse/InetbankingV1/src/test/java/com/banking/TestData/datadriven.xlsx";
		
		int rownum = XlUtils.getRowCount(path, "Sheet1");
		int colcount=XlUtils.getCellCount(path, "Sheet1", 1);
		
		String loginValue[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginValue[i-1][j]=XlUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginValue;
	}

}
