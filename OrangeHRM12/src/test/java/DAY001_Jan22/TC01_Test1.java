package DAY001_Jan22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Test1 {
	
	WebDriver driver;
	
	
  @Test
  public void Test1_Login() throws Exception{
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//Add Jobs
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales56");
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales56 descr");
		driver.findElement(By.id("jobTitle_note")).sendKeys("Sales56 Note");
		driver.findElement(By.id("btnSave")).click();
	  
  }
  
  
  
}
