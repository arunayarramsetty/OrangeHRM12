package SS;

import org.openqa.selenium.By;
import OORS.A1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A {
	WebDriver driver;
	
	
	
  @Test

  public void Login()throws Exception 
  
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		driver.findElement(By.xpath(A1.username)).sendKeys("Admin");
		driver.findElement(By.xpath(A1.password)).sendKeys("admin123");

		driver.findElement(By.xpath(A1.login)).click();


	  
  }
}
