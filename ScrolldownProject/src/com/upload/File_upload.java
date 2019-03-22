package com.upload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_upload {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.naukri.com/nlogin/logout");
		System.out.println("open application");
		driver.findElement(By.id("usernameField")).sendKeys("meenakshi.dhanikula@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("7676571150");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
		System.out.println("login complete");
		Thread.sleep(4000);
		driver.findElement(By.linkText("UPDATE PROFILE")).click();
		System.out.println("update profile successfully");
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,1700)");
		System.out.println("page scroll down successfully");
		Thread.sleep(3000);
		WebElement file=driver.findElement(By.id("attachCV"));
		Thread.sleep(4000);
		file.sendKeys("C:\\Users\\hp\\Desktop\\Meenakshi _Test Engineer.docx");
		System.out.println("File uploaded successfully");

	}

}
