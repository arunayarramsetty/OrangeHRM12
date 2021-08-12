package subha;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class subha_login_nonstatic {
	
	static WebDriver driver;
	
  @Test
  public void loginnonstatic ()throws Exception {
	  
	  subha_login_nonstatic  SN1= new subha_login_nonstatic();
		SN1.OpenChromeBrowser();
		SN1.OpenOrangeHRM();
		SN1.Login();
		SN1.AddNationality();
	  
  }
  
  
  
  public  void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	}
	
	
	public  void OpenOrangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	
	
	public  void Login() throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys("Admin");
		findElement(By.name("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();

	}
	
	
	public  void AddNationality() throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Mexican90");
		findElement(By.id("btnSave")).click();
		
	}
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
}
