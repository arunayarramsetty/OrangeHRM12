package AADITYA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.*;
import ExcelUtil.ExcelApiTest4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day5 {
	WebDriver driver;
	
	
	 @DataProvider(name = "TC01_Add_Nationality")
	  public static Object[][] Test1() throws Exception {
	 
		 ExcelApiTest4 eat = new ExcelApiTest4();
			Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Nationality5.xlsx", "Sheet1");
			System.out.println(testObjArray.length);
			return (testObjArray);
		}
			
	
  @Test(dataProvider = "TC01_Add_Nationality")
  public void login(String TestURL,String UserName,String Password,String Nationality) throws Exception
   {
  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		findElement(By.name("txtUsername")).sendKeys(UserName);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();	
		
		  
			 findElement(By.linkText("Admin")).click();
			 findElement(By.linkText("Nationalities")).click();
			 findElement(By.name("btnAdd")).click();
			 findElement(By.id("nationality_name")).sendKeys(Nationality);
			 findElement(By.id("btnSave")).click();	
			 
  
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



