package com.scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;

import org.apache.commons.io.FileUtils;

public class Teking_screensot {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	@AfterClass
	public void tearDown() {
		driver.close();
			
		}
	@Test
	public void screenspt1()throws Exception {
		try    {
			driver.navigate().to("http://localhost/orangehrm/orangehrm-2.6/login.php");
			driver.findElement(By.name("txtUserName")).sendKeys("admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin");
			driver.findElement(By.name("Submit")).click();
			System.out.println("login successfully");
			Thread.sleep(4000);
			WebElement el=driver.findElement(By.linkText("PIM"));
			Actions ac=new Actions(driver);
			ac.moveToElement(el).perform();
			System.out.println("navigate pim ");
			Thread.sleep(3000);
			driver.findElement(By.linkText("Add Employ")).click();
			System.out.println("click on submenu");
		}
		catch(Exception e){
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f1,new File( ""));
			
		}
		
			
		}
			
			
		}
