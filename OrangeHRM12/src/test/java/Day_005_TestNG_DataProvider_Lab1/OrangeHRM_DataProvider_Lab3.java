package  Day_005_TestNG_DataProvider_Lab1;
import CommonUtil.*;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
public class OrangeHRM_DataProvider_Lab3
{
	static WebDriver driver;
	
	//if u want to execute u r test with multiple input test data , we can user Data Provider
	
	
	 
	 
	 @DataProvider
		public Object[][] getData()
		{
		 Object[][] data = new Object[2][4];

			// 1st row
			data[0][0] ="https://opensource-demo.orangehrmlive.com/";
			data[0][1] = "Admin";
			data[0][2] = "admin123";
			data[0][3] = "Indians327";

			// 2nd row
			data[0][0] ="https://opensource-demo.orangehrmlive.com/";
			data[0][1] = "Admin";
			data[0][2] = "admin123";
			data[0][3] = "Indians328";
			
			return data;

		
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
@Test(dataProvider = "getData") //step2 u r test will be connected to dataProvider 
public void Test1(String TestURL,String UserName,String Password,String Nationality) throws Exception {   
	//step3 ensure number of parameters
		
		
		//OpenChromeBrowser
		driver = TestBrowser.OpenChromeBrowser();
		
		//driver=driver1;

		//OpenUrl
		driver.get(TestURL);
		

		//SendKeys
		 findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
		
			  
		 findElement(By.linkText("Admin")).click();
		 findElement(By.linkText("Nationalities")).click();
		 findElement(By.name("btnAdd")).click();
		 findElement(By.id("nationality_name")).sendKeys(Nationality);
		 findElement(By.id("btnSave")).click();	
		 
		
		 WebElement Element1 = findElement(By.linkText(Nationality));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", Element1);
			
		 	  
		 driver.quit();	 
		 

	}
	

// Draws a red border around the found element. Does not set it back anyhow.
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
	
	
	
	
	
	
	 
	













