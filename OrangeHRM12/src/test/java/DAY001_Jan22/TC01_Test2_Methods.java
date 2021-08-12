package DAY001_Jan22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Test2_Methods {
	
	WebDriver driver;
	
	
  @Test
  public void Test1_Login() throws Exception{
	  
	  TC01_Test2_Methods T1= new TC01_Test2_Methods();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM();	
	  T1.Login();
	  T1.AddJobs();
		


	  
  }
  
  
  public void OpenChromeBrowser() throws Exception{
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM() throws Exception{
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  
  public void Login() throws Exception{
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
  }
  
  
  public void AddJobs() throws Exception{
		
		//Add Jobs
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales57");
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales57 descr");
		driver.findElement(By.id("jobTitle_note")).sendKeys("Sales57 Note");
		driver.findElement(By.id("btnSave")).click();
  }
  
}
