package ADD_EX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ADD_SKILS {
	
	WebDriver driver;
	
	
	
  
 @Test
		public void login_test() throws Exception
		
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
	driver.findElement(By.id("menu_admin_Qualifications")).click();	
	driver.findElement(By.id("menu_admin_viewSkills")).click();	
	driver.findElement(By.id("btnAdd")).click();	
	driver.findElement(By.id("skill_name")).sendKeys("admin123");	
	driver.findElement(By.id("skill_description")).sendKeys("admin123");	
	driver.findElement(By.id("btnSave")).click();	
	  
	
	
	
	
	  
	  
  }
}
