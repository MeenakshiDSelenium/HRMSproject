package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Pagedown {
	 WebDriver dr;
		
		@Test

		public  void scrollpage() throws Exception{
			
			
			dr.manage().window().maximize();
			
			dr.get("https://www.google.com/search?q=selenium+interview+questions&oq=selenium+&aqs=chrome.1.69i57j0l4j69i65.11439j0j7&sourceid=chrome&ie=UTF-8");
			
			Thread.sleep(5000);
			((JavascriptExecutor)dr).executeScript("scroll(0,500)");
			
		}
		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
			 dr= new ChromeDriver();
		}

}
