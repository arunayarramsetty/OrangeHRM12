package Java_drop_down12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Drop_down123 {
	
	WebDriver driver;
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UName="Admin",Password="admin123";
	String LocationName="Vijayawada",Citylocation="Rainbow city",CountryName="India";
	
	
  @Test
  public void LoginTest() throws Exception
  {
	  
	  Drop_down123 S38= new Drop_down123();
	  S38.OpenChromeBrowser();
	  S38.OpenOrangeHRM(TestURL);
	  S38.Login(UName,Password);
	  S38.AddLocations(LocationName,Citylocation,CountryName);
		
		
  }
  
  
  
  public void OpenChromeBrowser()throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
}
  
  
  
  public void OpenOrangeHRM(String testURL)throws Exception
  {
  
	  driver.get("testURL");
		
  }
  public void Login(String UName,String Password)throws Exception
  {
  
	  findElement(By.name("txtUsername")).sendKeys("UName");
	  findElement(By.name("txtPassword")).sendKeys("Password");
	  findElement(By.id("btnLogin")).click();
  }
  
  public void AddLocations(String LocationName,String Citylocation,String CountryName)throws Exception
  {
	  
	  findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Organization")).click();
		findElement(By.id("menu_admin_viewLocations")).click();
		findElement(By.id("searchLocation_name")).sendKeys("LocationName");
		findElement(By.id("searchLocation_city")).sendKeys("Citylocation");
		
		Select dropdown2 = new Select(driver.findElement(By.name("CountryName")));
		dropdown2.selectByVisibleText("searchLocation_country");
		findElement(By.id("btnAdd")).click();
		
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
