package com.scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scroldownpage {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test

	public  void scrollpage() throws Exception{
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.softwaretestinghelp.com/selenium-interview-questions-answers/");
		
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,1500)");
		
	}
	

}
