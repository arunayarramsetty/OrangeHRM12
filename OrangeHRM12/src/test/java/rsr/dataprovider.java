package rsr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	
	WebDriver driver;
	
	 @DataProvider(name = "Orange2")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales20","Sales20 Descr","Sales10 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales21","Sales21 Descr","Sales21 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales22","Sales22 Descr","Sales22 Note" }
	        	};
	  }

	
	
	
  @Test
 public void dataprovider1() throws Exception {
	  
	  
	  
  }
  
public void Launcrowser() throws Exception {
	
	//Launch Browser
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;	
	  
  }
public void OpenOrangeHRM(String TestURL) throws Exception {
	//Open Orange HRM
	driver.get(TestURL);

	  
	  
}


public void AddJobs(String JobTitle,String JobDescr,String JobNote) throws Exception{
	
	//Add Jobs
	driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	driver.findElement(By.id("menu_admin_Job")).click();
	driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
	driver.findElement(By.id("btnAdd")).click();
	driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
	driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
	driver.findElement(By.id("jobTitle_note")).sendKeys(JobNote);
	driver.findElement(By.id("btnSave")).click();
}

public void login(String UserName,String Password) throws Exception {
	//Login
			findElement(By.id("txtUsername")).sendKeys(UserName);
			findElement(By.id("txtPassword")).sendKeys(Password);
			findElement(By.id("btnLogin")).click();
	  
			 public  WebElement findElement(By by) throws Exception 
				{

					WebElement elem = driver.findElement(by);  
					
					if (driver instanceof JavascriptExecutor) 
					{
					 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
				 
					}
					return elem;
				}


}
