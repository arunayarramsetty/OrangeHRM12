package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Skills_Static {
	
	static WebDriver driver;
	
  @Test
  public void AddSkillsTest()throws Exception {
	  
	  
	  
	  TC01_Add_Skills_Static.OpenChromeBrowser();
	  TC01_Add_Skills_Static.OpenOrangeHRM();
	  TC01_Add_Skills_Static.Login();
	  TC01_Add_Skills_Static.AddSkills();
	 // T1.CloseBrowser();
		
  }
  
  
  
  public static void OpenChromeBrowser()throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
 public static void OpenOrangeHRM()throws Exception {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
  
  
 public static void Login()throws Exception {
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
	  
 }
 
 public static void AddSkills()throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys("Java13");
		findElement(By.id("skill_description")).sendKeys("Java13 descr");
		findElement(By.id("btnSave")).click();
 }  
  
 
 public static  void CloseBrowser()throws Exception {
	  
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
