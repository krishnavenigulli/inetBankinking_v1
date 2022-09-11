package com.inetBanking.testCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {
	ReadConfig read=new ReadConfig();
	public String Url=read.getUrl();
	public String  Username=read.getuserName();
	public String   password=read.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	
	{
		 logger=Logger.getLogger("ebanking");
			PropertyConfigurator.configure("log4j.properties");
			if(br.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver",read.getChromePath());
		
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
			}
			else if(br.equals("firefox"))
			{
		System.setProperty("webdriver.gecko.driver",read.getFirefoxPath());
		
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
			}
		
			else if(br.equals("ie"))
			{
		System.setProperty("webdriver.ie.driver",read.getIEDpath());
		
		 driver=new InternetExplorerDriver();
		 driver.manage().window().maximize();
			}
			driver.get(Url);
		
		
	}
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
		
	}
	public void captureScreenshot(WebDriver driver,String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+name+".png");
		FileUtils.copyFile(src,target);
		
		System.out.println("Screenshot taken");
		
	}
	
}
