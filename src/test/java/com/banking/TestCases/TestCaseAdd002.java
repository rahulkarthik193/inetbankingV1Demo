package com.banking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.PageObjects.AddCustomer;
import com.banking.PageObjects.LoginPage;

//import junit.framework.Assert;

public class TestCaseAdd002 extends BaseClass {

	//String cname,String cgender,String mm,String dd,String yy,String caddr,String ccity,String cstate,String cpin,String cphone,String cpass
	//dataProvider="LoginData"
	@Test()
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(1000);
		
		AddCustomer ac=new AddCustomer(driver);
		ac.clickNewCustomer();
		ac.customerName("rahul");
		ac.gender("female");
		ac.dOB("11","6","1986");
		Thread.sleep(5000);
		ac.address("india");
		ac.city("thrissur");
		ac.state("goa");
		
		String email=randomString()+"@gmail.com";
		
		ac.emailId(email);
		ac.pin("789456");
		ac.phneNo("7894561234");
		ac.password("dfdgd456");
		ac.submit();
		Thread.sleep(5000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("added successfully");
		}
		else
		{
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("not added");
		}
	}
/*@DataProvider(name="LoginData")
	
	String[][]getData() throws IOException
	{
		String path="G:/eclipse/InetbankingV1/src/test/java/com/banking/TestData/customerdetails.xlsx";
		
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
	}*/
	public String randomString()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
}
