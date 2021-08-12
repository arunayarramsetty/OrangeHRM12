package Day_017_Multiple_Suites;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Bhavasri {
	
	//By Index  //driver.switchTo().frame(0); 	driver.switchTo().frame(1);
	//By Name or Id //	driver.switchTo().frame("iframe1");
	//By Web Element //driver.switchTo().frame("id of the element");
	

	
	static WebDriver driver;
	

	@Test
	public void Login_Test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;
	driver.get("http://www.bhavasri.com/Frames/AllContacts.html");
	
	
	
	String checkbox1="//*[@id='vehicle1']";
	String checkbox2="//*[@id='vehicle1']//following::input[1]";
	String checkbox3="//*[@id='vehicle1']//following::input[2]";
	
	findElement(By.xpath(checkbox1)).click();
	Thread.sleep(3);
	findElement(By.xpath(checkbox2)).click();
	Thread.sleep(3);
	findElement(By.xpath(checkbox3)).click();
	
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
