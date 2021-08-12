package pagobjm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class nation_test {
	
	WebDriver driver;
	
	
	
	
  @Test
  public void ajay() throws Exception{
	  login x1=new login();
	  x1.logindriver(driver);
	  x1.logintest();
	  
	  Nationalities b1=new Nationalities();
	  b1.Nationalitiesdriver(driver);
	  b1.addNationalities();
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
	  
	  
  }

  @AfterTest
  public void afterTest()throws Exception {
	  
	  driver.quit();
	  
  }

}
