package Day_feb_003;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Java_non_static {
	static WebDriver driver;
		
  @Test
  public  void Login_Test() throws Exception
  {
	  
	  
	  Java_non_static.OpenChromeBrowser();
	  Java_non_static.OpenOrangeHRM();
	  Java_non_static.Login();
	  Java_non_static.AddNationality();
	  
	  
	  
  }
  public static void OpenChromeBrowser() throws Exception
  {  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  public static void OpenOrangeHRM() throws Exception
  
  {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  
  }
  public static void Login() throws Exception
  {
	  findElement(By.name("txtUsername")).sendKeys("Admin");
	  findElement(By.name("txtPassword")).sendKeys("admin123");
	  findElement(By.id("btnLogin")).click();
  }
  public static void AddNationality() throws Exception
  {

		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys("Nuzland124");
		findElement(By.id("btnSave")).click();
  }

	 public   WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

  
}
