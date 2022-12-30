package com.guru99Bank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99Bank.BaseClass.BaseClass;
import com.guru99Bank.pageObjects.LoginPage;

public class TC001_loginTest extends BaseClass{
	
	@Test
	public void LoginTestCase() throws InterruptedException, IOException{
		
		LoginPage lp =new LoginPage(driver);
		
		String uname = lp.EnterUserId(prop.getProperty("username"));
		String pwd = lp.EnterPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		logger.info("entered username and password is : " +uname+ " and "+pwd);
		Thread.sleep(5000);
		
		String pageTitle = driver.getTitle();
		logger.info("application login page title is: " + pageTitle);
		
		Assert.assertEquals("Guru99 Bank Manager HomePage", pageTitle, "Application login failed");
		logger.info("application logged in successfully");
		
		captureScreenshot(driver, "LoginTestCase");
		
		lp.clickLogout();
		logger.info("Clicked on logout link");
		Thread.sleep(5000);
		//lp.handleAlert();
		logger.info("application successfully logged out");
	}
	
}