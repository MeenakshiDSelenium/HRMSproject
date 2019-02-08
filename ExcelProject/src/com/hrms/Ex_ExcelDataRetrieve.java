package com.hrms;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Ex_ExcelDataRetrieve {
	
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test 
	public void login() throws InterruptedException {
		driver.get("http://localhost/orangehrm/orangehrm-2.6/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		Thread .sleep(3000);
	
		/*
		WebElement element=driver.findElement(By.linkText("PIM"));
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(4000);*/
	}
		@Test   (dataProvider="AdminServantMaidList")
		public void pim(String LastName,String FirstName) throws Exception {
			WebElement element=driver.findElement(By.linkText("PIM"));
			Actions action=new Actions(driver);
			action.moveToElement(element).perform();
			driver.findElement(By.linkText("Add Employee")).click();
			Thread.sleep(4000);
		driver.switchTo().frame("rightMenu");
		
		driver.findElement(By.id("txtEmpLastName")).sendKeys(LastName);
		driver.findElement(By.name("txtEmpFirstName")).sendKeys(FirstName);
		driver.findElement(By.id("btnEdit")).click();
		driver.switchTo().defaultContent();
		
		
	}
	
	@DataProvider    (name = "AdminServantMaidList")	
	public static Object [][] AdminServantMaidList() throws BiffException, IOException{
		 File fss = new File("E:\\\\Book1.xls");
	        Workbook ws= Workbook.getWorkbook(fss);
	        Sheet s = ws.getSheet("Sheet1");
	        int rows = s.getRows();
	        System.out.println(rows);
	        int columns = s.getColumns();
	        System.out.println(columns);
	      	String inputdata [][]= new String [rows][columns]; 
	        for (int i=0; i<rows; i++){
	    	       for (int j=0; j<columns; j++){   
	                Cell cl = s.getCell(j,i);
	                inputdata [i][j] = cl.getContents();
	          	
		 

}}
			return inputdata;}}
