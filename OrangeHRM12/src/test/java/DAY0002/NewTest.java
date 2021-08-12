package DAY0002;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	
	WebDriver driver ;
	
  @Test
  public void loginpage() throws Exception {
	  
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		 
		
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//AddJobs
				findElement(By.id("menu_admin_viewAdminModule")).click();
				findElement(By.id("menu_admin_Job")).click();
				findElement(By.id("menu_admin_viewJobTitleList")).click();
				findElement(By.id("btnAdd")).click();
				findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales444");
				findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales444 descr");
				findElement(By.id("jobTitle_note")).sendKeys("Sales444 Note");
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
