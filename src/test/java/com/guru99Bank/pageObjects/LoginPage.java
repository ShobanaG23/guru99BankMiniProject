package com.guru99Bank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1
	public WebDriver driver;

	//2
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
		
	}
	
	//3
	@FindBy (name = "uid")
	WebElement txtLoginId;
	
	@FindBy (name = "password")
	WebElement txtPwd;
	
	@FindBy (name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	WebElement lnkLogout;
	
	
	//4
	public String EnterUserId(String uname) {
		txtLoginId.clear();
		txtLoginId.sendKeys(uname);
		return uname;
		
	}
	
	public String EnterPassword(String password) {
		txtPwd.clear();
		txtPwd.sendKeys(password);
		return password;
		
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
		driver.switchTo().alert().accept();
	}
	
	public void handleAlert() {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	
	
	
	
}
