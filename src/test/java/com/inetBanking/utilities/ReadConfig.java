package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
	  File src=new File("./Configuration/config.properties");
	 try {
	 FileInputStream fis=new FileInputStream(src);
	  pro=new Properties();
	   pro.load(fis);
	
	
	       }
	catch(Exception e)
	{
		
		System.out.println("Exception is"+e.getMessage());
	
		
	}

     }
	public String getUrl()
	{
		
		String url=pro.getProperty("Url");
		return url;
		
	}
	public String getuserName()
	{
		
		String username=pro.getProperty("Username");
		return username;
		
	}
	public String getpassword()
	{
		
		String Pwd=pro.getProperty("password");
		return Pwd;
		
	}
	public String getChromePath()
	{
		
		String ChromePath=pro.getProperty("chromepath");
		return ChromePath;
		
	}
	public String getFirefoxPath()
	{
		
		String firepath=pro.getProperty("firefoxpath");
		return firepath;
		
	}
	public String getIEDpath()
	{
		
		String IEpath=pro.getProperty("iepath");
		return IEpath;
		
	}
	
}