package  Day_017_Multiple_Suites;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.testng.annotations.*;
public class Amazon
{
	WebDriver driver;
	
	@Test
	public void Open_OrangeHRM() throws Exception {
		//OpenChromeVrowser
		driver = TestBrowser.OpenChromeBrowser();
		
		//OpenUrl
		driver.get("https://www.amazon.in/");
		
		//driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.quit();
	}
	
}                                                  












