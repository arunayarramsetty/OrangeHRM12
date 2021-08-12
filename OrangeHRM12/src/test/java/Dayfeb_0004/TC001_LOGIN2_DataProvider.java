package Dayfeb_0004;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001_LOGIN2_DataProvider {
	
	WebDriver driver;
	
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UserName="Admin",Password="admin123";
	//String licence="driving1";
	
	//step1
	 @DataProvider(name = "Orange1")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","driving1" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","driving2" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","driving2" }
	        	};
	  }
	
	
  @Test(dataProvider="Orange1")//step2
  public void AddJobsTest(String TestURL,String UserName,String Password,String licence) throws Exception
  {
  
	
	  TC001_LOGIN2_DataProvider T1= new TC001_LOGIN2_DataProvider();
	  T1.OpenCHromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	  T1.AddQualifications(licence);
	  T1.CloseBrowser();
	  
	
  }
  
  
  public void OpenCHromeBrowser() throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM(String TestURl1) throws Exception
  {
		driver.get(TestURl1);
  }
  
  public void Login(String UNAME,String PWD) throws Exception
  {
	  System.out.println( " UNAME is : "+UNAME);
	  System.out.println( " PWD is : "+PWD);
	  
		findElement(By.id("txtUsername")).sendKeys(UNAME);
		findElement(By.id("txtPassword")).sendKeys(PWD);
		findElement(By.id("btnLogin")).click();
  }
  
  public void AddQualifications(String licence2) throws Exception
  {
	  
	  System.out.println( " License is : "+licence2);
		
	findElement(By.id("menu_admin_viewAdminModule")).click();
	
	 findElement(By.id("menu_admin_Qualifications")).click();
	 findElement(By.id("menu_admin_viewLicenses")).click();
	  findElement(By.id("btnAdd")).click();
	  
	  findElement(By.id("license_name")).sendKeys(licence2);
	  findElement(By.id("btnSave")).click();
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
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
		 
			}
			return elem;
		}

	
	

}
	
  
  
  

