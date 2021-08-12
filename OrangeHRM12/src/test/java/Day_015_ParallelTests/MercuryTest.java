package  Day_015_ParallelTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
public class MercuryTest
{
	WebDriver driver;

	

	@Test
	public void Open_Mercury() throws Exception {
		
		driver = TestBrowser.OpenChromeBrowser();
		
		//OpenUrl
		driver.get("http://gmail.com");

	
		//Close Browser		
		driver.quit();
	}
}                                                  












