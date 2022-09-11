package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import java.io.IOException;

import org.testng.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{

		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		logger.info("entered username");
		lp.setUserPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
			
		}
		else
		{
			captureScreenshot( driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login failed");
			
		}
		
	}
		

}
