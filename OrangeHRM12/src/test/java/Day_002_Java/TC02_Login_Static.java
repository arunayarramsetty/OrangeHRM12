package Day_002_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC02_Login_Static {
	
	
	static WebDriver driver;
	static String UserName="Admin", Password="admin123";
	static String Nationality="Canada";

	
	@Test
	public  void Login_Test() throws Exception
	{
		
		TC02_Login_Static.OpenChromeBrowser();
		TC02_Login_Static.OpenOrangeHRM();
		TC02_Login_Static.Login(UserName,Password);
		TC02_Login_Static.AddNationality(Nationality);
		TC02_Login_Static.closeBrowser();
	}
	
	
	

	
	public static void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	}
	
	
	public static void OpenOrangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
	
	
	public static void Login(String UserName1,String Password1) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();

	}
	
	
	public static void AddNationality(String Nationality1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
		findElement(By.id("btnSave")).click();
		
		
	}
	
	
	public static void closeBrowser() throws Exception
	{
		
		driver.quit();
	}
	
	
	
	 public static  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

	
	

}
