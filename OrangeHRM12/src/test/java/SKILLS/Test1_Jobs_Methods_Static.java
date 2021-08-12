package SKILLS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Jobs_Methods_Static {
	
	static WebDriver driver;
	
  @Test
  public void AddJobs()throws Exception {
	  
	  Test1_Jobs_Methods_Static.OpenChromeBrowser();
	  Test1_Jobs_Methods_Static.OpenOrangeHRM();
	  Test1_Jobs_Methods_Static.Login();
	  Test1_Jobs_Methods_Static.AddJobs1();
	  Test1_Jobs_Methods_Static.CloseBrowser();
	
  }
  
  
  

  public static  void OpenChromeBrowser()throws Exception 
  {
	  	//Launch Brower
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  public static void OpenOrangeHRM()throws Exception 
  {
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
  
  public static  void Login()throws Exception 
  {
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  }
  
  
  public static void AddJobs1()throws Exception 
  {
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales4");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales4 descr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales4 Note");
		findElement(By.id("btnSave")).click();
  }
  
  public static void CloseBrowser()throws Exception 
  {
	  driver.quit();
  }
  
  
  
  
  
  
  public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

  
  
  
}
