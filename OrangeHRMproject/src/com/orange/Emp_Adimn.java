package com.orange;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;
public class Emp_Adimn {
	public static String un="admin";
	public static String pw="admin";

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://localhost/orangehrm/orangehrm-2.6/login.php");
		System.out.println("Application opend");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("admin");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		//creating Alert oject to get popup message text
		Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		//a.accept()clicked or accepted ok button
		a.accept();
		System.out.println("geting popup message text");
		driver.findElement(By.name("clear")).click();
		System.out.println("clear all fields");
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		//perform tab and enter keyboard actions
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
	
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_M);
		
		System.out.println("entered password");
		driver.findElement(By.name("Submit")).click();
		System.out.println("login completed");
		if(driver.getTitle().equals("OrangeHRM")) {
			System.out.println("title is matched to : "+driver.getTitle());
		}
		else {
			System.out.println("title not matched to"+driver.getTitle());
		}
		Thread.sleep(4000);
		//verifying text
		assertTrue(driver.findElement(By.xpath("//ul[@id='option-menu']/li")).getText().matches("Welcome admin"));
		System.out.println("welcome admin text verifyed");
		driver.switchTo().frame("rightMenu");
		driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
		System.out.println("clicked add button");
		
		//to retrive the data from empid textbox
		String empid=driver.findElement(By.xpath("//*[@id='txtEmployeeId']")).getAttribute("value");
		System.out.println(empid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='txtEmpLastName']")).sendKeys("F");
		System.out.println("last name entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='txtEmpFirstName']")).sendKeys("Gdvds");
		System.out.println("first name entered");
		Thread.sleep(3000);
		//file upload using webdriver
		WebElement fi=driver.findElement(By.xpath("//*[@id='photofile']"));
		fi.sendKeys("C:\\Users\\hp\\Downloads\\meenuakka.png");
		Thread.sleep(2000);
		System.out.println("photo uploaded successfilly");
		driver.findElement(By.xpath("//*[@id='btnEdit']")).click();
		System.out.println("new employee added");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//mouseover on pim mainmenu
		WebElement element=driver.findElement(By.linkText("PIM"));
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
		Thread.sleep(3000);
		System.out.println("fined pim mainmenu");
		driver.findElement(By.linkText("Add Employee")).click();
		System.out.println("clicked add Employee");
		Thread.sleep(4000);
		driver.navigate().back();
		
		WebElement element1=driver.findElement(By.linkText("Admin"));
		Actions ac2=new Actions(driver);
		ac2.moveToElement(element1).perform();
		Thread.sleep(1000);
		System.out.println("find admin main menu");
		WebElement em1=driver.findElement(By.linkText("Data Import/Export"));
		Actions act=new Actions(driver);
		act.moveToElement(em1).perform();
		Thread.sleep(4000);
		System.out.println("navigated Data Import/Export");
		driver.findElement(By.linkText("Export")).click();
		System.out.println("cliked Export");
		driver.switchTo().frame(0);
		//select dropdown list
		Select dw=new Select(driver.findElement(By.xpath("//*[@id='cmbExportType']")));
		dw.selectByIndex(1);
		System.out.println("selected millenium payroll export ");
		Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id='btnExport']")).click();
		//System.out.println("clicked export button");
		//Thread.sleep(5000);
		//driver.navigate().back();
		
		//using JavascriptExecutor 
		driver.switchTo().defaultContent();
		WebElement logout1=driver.findElement(By.linkText("Logout"));
		JavascriptExecutor exec=(JavascriptExecutor)driver;
		exec.executeScript("arguments[0].click();", logout1);
		System.out.println("logout completed");
		
		if(driver.getTitle().equals("OrangeHRM - New Level of HR Menagement")) {
			System.out.println("title matched :"+driver.getTitle());
		}
		else {
			System.out.println("title not matched :"+driver.getTitle());
		}
		
		//explicit wait for element to be clickable
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtUserName")));
		driver.findElement(By.name("txtUserName")).sendKeys("admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin");
		//impplicit wait
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//using JavascriptExecutor
		
		WebElement login=driver.findElement(By.name("Submit"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", login);
		System.out.println("login completed");
		//select dropdown list
     	driver.switchTo().frame(0);
		Select drpdwn=new Select(driver.findElement(By.name("loc_code")));
		drpdwn.selectByIndex(1);
		System.out.println("selected empID");
		driver.findElement(By.name("loc_name")).sendKeys("0002");
		System.out.println("entered emp id");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		System.out.println("clicked search button");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		WebElement table=driver.findElement(By.xpath("//table[@class='data-table']"));
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for(int i=1;i<=4;i++) {
			driver.findElement(By.xpath("//*[@id=\'standardView\']/table/tbody/tr["+i+"]/td[1]/input")).click();
		//clicked multiple checkboxs
		/*List<WebElement> tbody=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(tbody.size());
		for(int i=0;i<tbody.size()-3;i++) {
			tbody.get(i).click();*/
			
		}
		/*driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[2]")).click();
		System.out.println("deleted successfully");
		//driver.findElement(By.xpath("//*[@id='allCheck']")).click();
				driver.findElement(By.xpath("//ul[@id='option-menu']/li[3]/a")).click();
				System.out.println("logout completed");
				
		
		
		/*driver.findElement(By.xpath("//*[@id='Table_01']/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input")).sendKeys(un);
		Thread.sleep(1000);
		System.out.println("enterd un by calling variable");
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys(pw);
		System.out.println("enterd pw by calling variable");
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input")).click();
		//login using robot class
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_TAB);
		r1.keyRelease(KeyEvent.VK_TAB);
		
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("login");
		Thread.sleep(3000);
		*/
		
		
		
		
		
}}
