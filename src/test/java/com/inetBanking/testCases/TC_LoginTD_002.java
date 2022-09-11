package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtil;

public class TC_LoginTD_002 extends BaseClass {
	@Test
	public void loginDDT(String user,String pwd)
	{
		
		LoginPage lp1=new LoginPage(driver);
		lp1.setUserName(user);
		logger.info("username provided");
		lp1.setUserPassword(pwd);
		logger.info("password provided");
		lp1.clickLogin();
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			lp1.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			
			return true;
		}
		catch(NoAlertPresentException e)
		{
			
			return false;
		}
		
		
	}
	
	
	
	
	@DataProvider(name="LoginData")
      String [][]getData() throws IOException
          {
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/TestLoginData.xlsx";
		
		int rownum=XLUtil.getRowCount(path,"Sheet1");
		int colcount=XLUtil.getCellCount(path,"Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for (int i=0;i<=rownum;i++)
		{
			for(int j=0;j<=colcount;j++)
			{
				
				
				logindata[i-1][j]=XLUtil.getCelldata(path, "Sheet1", i, j);
				
				
				
			}
			
			
		}
		return logindata;
		
		
		
          }
	
	
	
}
