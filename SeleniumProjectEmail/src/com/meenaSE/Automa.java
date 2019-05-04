package com.meenaSE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automa {

	public static void main(String[] args)throws InterruptedException {
		
	
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://gmail.com");
         Thread.sleep(2000);
         
        driver.findElement(By.xpath("//input[@id='identifierId']") ).sendKeys("mennakshi.dhanukula@gmail.com");
         Thread.sleep(4000);
         System.out.println("entered email");
         driver.findElement(By.xpath("//div[@id='identifierNext']") ).click();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         System.out.println("clicked Next");
     
         driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf'][@name='password']") ).sendKeys("9742609646");
         System.out.println("Entered password");

         Thread.sleep(3000);
         driver.findElement(By.xpath("//content[@class='CwaK9']")).click();
        	System.out.println("clicked Next");	 
        
        	}
	}
