package Day_002_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class TC01_Login2 extends TestBrowser {
	
	
	static WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
		driver=TestBrowser.OpenChromeBrowser();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	findElement(By.name("txtUsername")).sendKeys("Admin");
	findElement(By.name("txtPassword")).sendKeys("admin123");
	findElement(By.name("Submit")).click();
		
	}
	
	
	
	

}
