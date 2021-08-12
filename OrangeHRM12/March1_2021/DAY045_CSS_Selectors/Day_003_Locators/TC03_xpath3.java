package  Day_003_Locators;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC03_xpath3
{
	static WebDriver driver;
	
	@Test
	public void Test2() throws Exception {
		
		Properties obj=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//TestData//application.properties");
		obj.load(fis);
	
		driver = TestBrowser.OpenChromeBrowser();
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	
		String str=obj.getProperty("UserName");
		System.out.println("xpath is : "+str);
		
		findElement(By.xpath(obj.getProperty("UserName"))).sendKeys("Admin");
		findElement(By.xpath(obj.getProperty("Password"))).sendKeys("admin123");
		findElement(By.xpath(obj.getProperty("Loginbutton"))).click();
		
		findElement(By.xpath(obj.getProperty("Admin"))).click();
		findElement(By.xpath(obj.getProperty("Nationality"))).click();	
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












