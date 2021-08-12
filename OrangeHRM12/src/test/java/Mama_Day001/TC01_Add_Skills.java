package Mama_Day001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Skills {
	
	WebDriver driver;
	
  @Test
  public void Skills() throws Exception {
	  TC01_Add_Skills s1=new TC01_Add_Skills();
	  s1.OpenBrowser();
	  s1.launch_url();
	  s1.login();
	  s1.addskills();
	  s1.close();


  }
  
  
  public void OpenBrowser()  throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  public void launch_url() throws Exception{
	  driver.get("https://opensource-demo.orangehrmlive.com/");
		
  }
  public void login() throws Exception{
	  findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  }
  public void addskills() throws Exception{
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Qualifications")).click();
	  findElement(By.id("menu_admin_viewSkills")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("skill_name")).sendKeys("java");
	  findElement(By.id("skill_description")).sendKeys("java description");
	   
  }
  public void close() throws Exception{
	  driver.quit();
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
