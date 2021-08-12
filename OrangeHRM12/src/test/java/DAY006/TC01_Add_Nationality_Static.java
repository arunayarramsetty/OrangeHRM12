package DAY006;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Nationality_Static {
	
	static WebDriver driver;
	
	
  @Test
  public void AddNationality() throws Exception {
	  
	  TC01_Add_Nationality_Static.OpenChromeBrowser();
	  TC01_Add_Nationality_Static.OpenOrangeHRM();
	  TC01_Add_Nationality_Static.Login();
	  TC01_Add_Nationality_Static.AddNationbality();
	  
		  
  }
  
  
  
  
  public static void OpenChromeBrowser() throws Exception
  {
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public static void OpenOrangeHRM() throws Exception
  {
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
				
  }
  
  public static void Login() throws Exception
  {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
  }
  
  
  public static void AddNationbality() throws Exception
  {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_nationality")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("nationality_name")).sendKeys("Indian7657");
		driver.findElement(By.id("btnSave")).click();
  }
  
  
}
