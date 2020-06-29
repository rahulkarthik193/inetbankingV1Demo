package com.banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

WebDriver lDriver;
	
	public AddCustomer(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	WebElement txtUserName;
	@FindBy(xpath="//tr[5]//td[2]//input[1]")
	WebElement rdMale;
	@FindBy(xpath="//tr[5]//td[2]//input[2]")
	WebElement rdFemale;
	
	@FindBy(name="dob")
	WebElement txtDOB;
	@FindBy(name="addr")
	WebElement txtAddress;	
	@FindBy(name="city")
	WebElement txtCity;
	@FindBy(name="state")
	WebElement txtState;
	@FindBy(name="pinno")
	WebElement  txtPin;
	@FindBy(name="telephoneno")
	WebElement txtMobileNo;
	@FindBy(name="emailid")
	WebElement txtEmail;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	public void customerName(String cname)
	{
		txtUserName.sendKeys(cname);
	}
	public void gender(String cgender)
	{
		if(cgender=="male")
		{
			rdMale.click();
		}
		else
		{
			rdFemale.click();
		}
	}
		
	
	public void dOB(String mm,String dd,String yy)
	{
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
    public void address(String caddr)
    {
    	txtAddress.sendKeys(caddr);
    }
    public void city(String ccity)
    {
    	txtCity.sendKeys(ccity);
    }public void state(String cstate)
    {
    	txtState.sendKeys(cstate);
    }
    public void pin(String cpin)
    {
    	txtPin.sendKeys(cpin);
    }
    public void phneNo(String cmobile)
    {
    	txtMobileNo.sendKeys(cmobile);
    }
    public void emailId(String cemail)
    {
    	txtEmail.sendKeys(cemail);
    }
    public void password(String cpass)
    {
    	txtPassword.sendKeys(cpass);
    }
    public void submit()
    {
    	btnSubmit.click();
    }
}
