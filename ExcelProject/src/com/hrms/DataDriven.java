package com.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class DataDriven {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="AdminServantMaidList")
	public void login(String UserName,String password) {
		driver.get("http://localhost/orangehrm/orangehrm-2.6/login.php");
		driver.findElement(By.name("txtUserName")).sendKeys(UserName);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		
	}
	
	@DataProvider    (name = "AdminServantMaidList")	
	public static Object [][] AdminServantMaidList() throws BiffException, IOException{
		 File fs = new File("E:\\Book1.xls");
	        Workbook ws= Workbook.getWorkbook(fs);
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
	                       
	            }
	        }
	                return inputdata;
	
	}	

}
