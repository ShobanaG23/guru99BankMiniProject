package com.guru99Bank.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	
	@BeforeClass
	public void setup() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\rarav\\eclipse-workspace\\guru99BankMiniProject\\resources\\config.properties");
		prop.load(fis);
		
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		logger.info("driver openened successfuly");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("application homepage opened");		
	}
	
	
	@AfterClass
	public void teardown(){
		driver.quit();
		logger.info("driver is closed successfully");
		
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshot\\"+testName+".png");
		FileUtils.copyFile(source, target);
		logger.info("captured scrrenshot");
		
		
		
		
		
	}
	

}
