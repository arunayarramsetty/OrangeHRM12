package Day_004_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_Locations_DataProvider {
	
	WebDriver driver;
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UName="Admin",Password="admin123";
	String LocationName="Hyderabad13",CountryName="India";
	
	//step1
		 @DataProvider(name = "Orange1")
		  public static Object[][] Test1() throws Exception {
		 
		        return new Object[][] { 
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Hyderabad15","India" },
		        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Hyderabad16","India" }
		        	};
		  }
	
  @Test(dataProvider="Orange1")//Step2
  public void AddLocationsTest(String TestURL,String UName,String Password,String LocationName,String CountryName ) throws Exception {
	  
		
	  TC01_Add_Locations_DataProvider T1=new TC01_Add_Locations_DataProvider();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UName,Password);
	  T1.AddLocations(LocationName,CountryName);
	  T1.CloseBrowser();

		
		
		
  }
  
  
  
  public void OpenChromeBrowser()throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  public void OpenOrangeHRM(String TestURL1)throws Exception {

		driver.get(TestURL1);
  }
  
  public void Login(String UName1,String Password1)throws Exception {
		findElement(By.id("txtUsername")).sendKeys(UName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
		
  }
  
  public void AddLocations(String LocationName1,String CountryName1)throws Exception {
	  
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Organization")).click();
		findElement(By.id("menu_admin_viewLocations")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("location_name")).sendKeys(LocationName1);
		
		Select dropdown1 = new Select(findElement(By.id("location_country")));
		dropdown1.selectByVisibleText(CountryName1);
		
		findElement(By.id("btnSave")).click();
  }
  
  
 public void CloseBrowser()throws Exception {
	
		driver.quit();
  }
 
 
 
 
 
  
  public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	        
	  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
	        
	    }
	    return elem;
	}
	

  
}
