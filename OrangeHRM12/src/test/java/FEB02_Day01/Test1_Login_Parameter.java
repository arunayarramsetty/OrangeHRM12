package FEB02_Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_Login_Parameter {
	
	WebDriver driver;
	
	String UserName="Admin",Password="admin123";
	String NationalityText="Indian78650";
	
	
  @Test
  public void Login1() throws Exception {
	  
	  Test1_Login_Parameter T1= new Test1_Login_Parameter();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM();
	  T1.Login(UserName,Password);
	  T1.AddNationality(NationalityText);
	  T1.CloseBrowser();
  
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
  
  
  public void OpenChromeBrowser() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
 public void OpenOrangeHRM() throws Exception {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  
  public void Login(String UserName,String Password) throws Exception {
		
	findElement(By.id("txtUsername")).sendKeys(UserName);
	findElement(By.id("txtPassword")).sendKeys(Password);
	findElement(By.id("btnLogin")).click();
  }
  
  public void AddNationality(String NationalityText1) throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(NationalityText1);
		findElement(By.id("btnSave")).click();
  }
  
  public void CloseBrowser() throws Exception {
		
		driver.quit();	
  }
  
  
  
  
}
