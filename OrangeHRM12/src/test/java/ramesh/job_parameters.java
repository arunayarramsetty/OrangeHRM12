package ramesh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DAY006.TC01_Add_Skills2_Parameter;

public class job_parameters {
	
	WebDriver driver;
	String TESTURL="https://opensource-demo.orangehrmlive.com/";
	String USERNAME="Admin", PASSWORD="admin123";
	String jobtitle="Sales222" ,jobDescription="Sales222 descr",jobTitle_note="Sales222Note";
	
	
	
  @Test
 public void job_parameters1() throws Exception{
	  
	  TC01_Add_Skills2_Parameter T1=new TC01_Add_Skills2_Parameter();
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TESTURL);
	  T1.Login(USERNAME,PASSWORD);
	  T1.addjobs(sales1);

  }	
	  
	  
	  
  
  public void OpenChromeBrowser() throws Exception{
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
 public void OpenOrangeHRM() throws Exception{
	//Open Orange HRM
			driver.get(TestURL);
  }
 public void Login(String UserName,String Password) throws Exception{
	//Login
	 findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		
 }
 public void addjobs(String sales1,  String sales1des, String sales1note ) throws Exception{
 
		//AddJobs
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(sales1);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(sales1des);
		findElement(By.id("jobTitle_note")).sendKeys(sales1note);
		findElement(By.id("btnSave")).click();
	  
  
  
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


}
