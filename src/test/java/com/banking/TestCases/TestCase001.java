package com.banking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.PageObjects.LoginPage;



public class TestCase001 extends BaseClass{

	
	@Test
	public void testCase() throws IOException
	{
		
		logger.info("Url is entered");

		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("Login clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage12"))
		{
			Assert.assertTrue(true);
			logger.info("loginpassed");
		}
		else
		{
			captureScreenshot(driver,"testCase");
			Assert.assertFalse(false);
			logger.info("login failed");
		}
	}
}
