package Day_002_Java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Login {
	
	
	static WebDriver driver;
	
	@Test
	public void Login_Test() throws Exception
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.manage().window().maximize() ;	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	JavascriptExecutor js = (JavascriptExecutor)driver;	
    
    WebElement username=findElement(By.id("txtUsername"));
    js.executeScript("arguments[0].setAttribute('value','Admin')", username);
    WebElement password=findElement(By.name("txtPassword"));
    js.executeScript("arguments[0].setAttribute('value','admin123')", password);
    WebElement loginbutton =findElement(By.id("btnLogin"));
    
    js.executeScript("arguments[0].click();", loginbutton);
   
    WebElement pim1 =findElement(By.id("menu_pim_viewPimModule")); 
    js.executeScript("arguments[0].click();", pim1);
    
	
}
	
	
	
	 public  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
				((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", pim1);
		        
		 
			}
			return elem;
		}

	
	
	
	
	
	
	
	

}
