package Mama_Day001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC01_Add_Nationalities_Data_Provider {
	
	WebDriver driver ;
	
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	
	//String UserName="Admin",Password="admin123";
	
	//String Nationality_Text="Indian101";
	
	
	//step1 copy the syntax
		 @DataProvider(name = "Orange2")
		  public static Object[][] Test1() throws Exception {
		 
		        return new Object[][] { 
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians127" },
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Indians128" }
		        	};
		  }
	
  @Test(dataProvider="Orange2") // connect with data provider
  public void Login(String TestURL,String UserName,String Password,String Nationality_Text) throws Exception {   //step3
	  
	  TC01_Add_Nationalities_Data_Provider T1= new TC01_Add_Nationalities_Data_Provider();
	  
	  T1.OpenChromeBroser();
	  T1.OrangeHRMLogin(TestURL,UserName,Password);
	  T1.AddNational(Nationality_Text);
	  T1.CloseBrowser();
				
  }
  
  
  
  
  public void OpenChromeBroser() throws Exception { 
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  
  }
  
  

  public void OrangeHRMLogin(String TestURL1,String UserName1,String  Password1) throws Exception { 
	  
	  	driver.get(TestURL1);
		findElement(By.id("txtUsername")).sendKeys(UserName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
  
  }
  
  
  

  public void AddNational(String Nationality_Text1) throws Exception { 
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality_Text1);
		findElement(By.id("btnSave")).click();
  }
  
  
  

  public void CloseBrowser() throws Exception { 
  
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
