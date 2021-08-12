package java_006;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class java_0068 {
	
	static WebDriver driver;
	
	
  @Test
  public void openChrome()throws Exception {
	//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			//Open Orange HRM
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			
			
		
	
			findElement(By.id("txtUsername")).sendKeys("Admin");
			findElement(By.id("txtPassword")).sendKeys("admin123");
			findElement(By.id("btnLogin")).click();
			
			
			
			
			
			
			
			findElement(By.id("menu_admin_viewAdminModule")).click();
			findElement(By.id("menu_admin_Job")).click();
			findElement(By.id("menu_admin_viewJobTitleList")).click();
			findElement(By.id("jobTitle_jobTitle")).sendKeys("java68");
			findElement(By.id("jobTitle_jobDescription")).sendKeys("jobdescr");
			findElement(By.id("jobTitle_note")).sendKeys("Admin");
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
  
  
