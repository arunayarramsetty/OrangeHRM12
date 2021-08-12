package DAY001_Feb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Test2_Methods {
	
	
	WebDriver driver;
	
  @Test
  public void AddSkillsTest()throws Exception {
	  
	
	  TC01_Test2_Methods T1= new TC01_Test2_Methods();
	  
	  T1.OpenCHromeBrowser();
	  T1.OpenOrangeHRM();
	  T1.Login();
	  T1.AddSKills();
	  T1.CloseBrowser();

	  
  }
  

  
  public void AddSKills() throws Exception
  {
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Qualifications")).click();
	  findElement(By.id("menu_admin_viewSkills")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("skill_name")).sendKeys("Java12");
	  findElement(By.id("skill_description")).sendKeys("Java12 descr");
	  findElement(By.id("btnSave")).click();
  }
  
  public void OpenCHromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM() throws Exception
  {
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  
  public void Login() throws Exception
  {
		
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
  }
  
  public void CloseBrowser() throws Exception
  {
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
