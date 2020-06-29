package com.banking.Utilities;

//import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig()
	{
		
	
	try
	{
		//FileInputStream fis=new FileInputStream("./Configuration/config.properties");
		FileReader fr=new FileReader("./Configuration/config.properties");
		pro=new Properties();
		pro.load(fr);
		
	}
	catch(Exception e)
	{
		System.out.println("Exception is"+""+e.getMessage());
	}

}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getUsername()
	{
		String name=pro.getProperty("username");
		return name;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String chromeDriver()
	{
		String driver=pro.getProperty("chromepath");
		return driver;
	}
	public String firefoxDriver()
	{
		String driver=pro.getProperty("firefox");
		return driver;
	}
}
