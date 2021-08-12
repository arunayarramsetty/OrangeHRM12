package FEB02_Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Jobs {
	
	WebDriver driver;
	
  @Test
  public void Add_Jobs()throws Exception {
	  
	
	  TC01_Add_Jobs T2=new TC01_Add_Jobs();
	  
	  T2.OpenChromeBrowser();
	  T2.OpenOrangeHRM();
	  T2.Login();
	  T2.AddJobs();
	  T2.CloseBrowser();

		
	  
  }
  
  

  
  
	 public  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

  
	 
	 public void OpenChromeBrowser() throws Exception
	 {
		  	//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
		 
	 }
	 
	 public void OpenOrangeHRM() throws Exception
	 {
			//Open Orange HRM
			driver.get("https://opensource-demo.orangehrmlive.com/");
	 }
	 
	 
	 public void Login() throws Exception
	 {
			
			//Login
			findElement(By.id("txtUsername")).sendKeys("Admin");
			findElement(By.id("txtPassword")).sendKeys("admin123");
			findElement(By.id("btnLogin")).click();
		 
	 }
	 
	 
	 
	 public void AddJobs() throws Exception
	 {
			
			//AddJobs
			findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Job")).click();
			findElement(By.id("menu_admin_viewJobTitleList")).click();
			findElement(By.id("btnAdd")).click();
			findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales569");
			findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales569 descr");
			findElement(By.id("jobTitle_note")).sendKeys("Sales569 Note");
			findElement(By.id("btnSave")).click();
	 }
	 
	 
	 public void CloseBrowser() throws Exception
	 {
		 driver.quit();
	 }
	 
  
  
}
