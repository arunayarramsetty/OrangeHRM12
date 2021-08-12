package subha;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class subha_nonstaticparameter {
	
	
	
	static WebDriver driver;
	
	String UserName="Admin", Password="admin123";
	String Nationality="Kenyas123";

	
	
  @Test
  public void nonstaticparameter ()throws Exception {
	  
	  subha_nonstaticparameter SN1=new subha_nonstaticparameter();
		
		SN1.OpenChromeBrowser();
		SN1.OpenOrangeHRM();
		SN1.Login(UserName,Password);
		SN1.AddNationalities(Nationality);
		
		driver.quit();
	
	  
	  
  }
  
  
  public  void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public  void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
  
  public  void Login(String UserName,String Password) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	}
	

	public    void AddNationalities(String Nationality) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.name("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality);
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
