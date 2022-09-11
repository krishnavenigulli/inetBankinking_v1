package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	 WebDriver ldriver;
	 public LoginPage(WebDriver rdriver )
	 {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	 
		 
	 }
	 @FindBy(name="uid")
	 WebElement textUserName;
	 @FindBy(name="password")
	 WebElement userPassword;
	 @FindBy(name="btnLogin")
	 WebElement login;
	 @FindBy(xpath="//a[contains(text(),'Log out')]")
	 WebElement logout;
	 public void setUserName(String uname)
	 {
		 
		 textUserName.sendKeys(uname);
		 
	 }
	 public void setUserPassword(String pwd)
	 {
		 
		 userPassword.sendKeys(pwd);
		 
	 }
	 public void clickLogin()
	 {
		 
		 login.click();
		 
	 }
	 public void clickLogout()
	 {
		 
		 logout.click();
		 
	 }
}
