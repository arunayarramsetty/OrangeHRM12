package  Day_003_Locators;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC02_xpath2
{
	

	
	private static final int India5544 = 0;
	static WebDriver driver;
	

	@Test
	public void Test2() throws Exception {
		
		

	
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	
			
		
		findElement(By.xpath(OR.UserName)).sendKeys("Admin");
		findElement(By.xpath(OR.Password)).sendKeys("admin123");
		findElement(By.xpath(OR.Loginbutton)).click();
		
		
		
		/*findElement(By.xpath(OR.Admin1)).click();
		findElement(By.xpath(OR.Nationality)).click();
		findElement(By.xpath(OR.btnAdd1)).click();
		findElement(By.xpath(OR.nationality_name)).sendKeys("india5540");
		findElement(By.xpath(OR.savebutton1)).click();*/
		
		
		findElement(By.id ("menu_admin_viewAdminModule")).click();
		findElement(By.id ("menu_admin_nationality")).click();
		findElement(By.id ("btnAdd")).click();
		findElement(By.id ("nationality[name]")).sendKeys("USA");
		findElement(By.id ("savebutton")).click();
		
		
			

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












