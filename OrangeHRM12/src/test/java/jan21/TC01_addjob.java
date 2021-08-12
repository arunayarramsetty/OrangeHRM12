package jan21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_addjob {
	
	WebDriver driver;
  @Test
  public void addjobs()throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();	
		
		  
		  driver.findElement(By.id("menu_admin_viewAdminModule")).click();	
		  
		  
		 driver.findElement(By.id("menu_admin_Job")).click();	
		  driver.findElement(By.id("menu_admin_viewJobTitleList")).click();	
		 driver.findElement(By.id("searchSystemUser_userName")).sendKeys("aaaaaa");	
		  driver.findElement(By.id("btnAdd")).click();	
			
		
		
		
		
  }
  
  public void login1()throws Exception
  {
	  
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();	
		
  }
  public void addjobs34()throws Exception
  {
	
	  
	  
	  driver.findElement(By.id(" menu_admin_viewAdminModule")).click();	
	  driver.findElement(By.id(" menu_admin_Job")).click();	
	  driver.findElement(By.id(" menu_admin_Job")).click();	
	  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("jobadds3");	
	  driver.findElement(By.id(" btnAdd")).click();	
		
	  
	  
  }
  
}
  
