package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng_webdriver {
private WebDriver driver;
@BeforeMethod
public void setUP() {
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	}
@Test(description="OrangeHRM Login")
public void login() {
	Reporter.log("test case steps");
	driver.navigate().to("http://localhost/orangehrm/orangehrm-2.6/login.php");
	Reporter.log("Appliceton opend");
	driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("admin");
	Reporter.log("enter userName");
	driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("admin");
	Reporter.log("enter password");
	driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input")).click();
	Reporter.log("successfull login");
}
@AfterClass
public void cose() {
	driver.quit();
}


}


