package Day_002_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC03_Login_Static_Paarameters {
	
	
	static WebDriver driver;
	
	//Global Variables
	//static String UserName="Admin", Password="admin123";
	//static String Nationality="Mexican9";

	@DataProvider(name = "Driver143")
	  public static Object[][] Test1() throws Exception {
	 
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM61//TC01_Nationality2_111.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
		
	  }
	
	
	@Test(dataProvider="Driver143")
	public void Login_Test(String Browser,String TestURL,String UserName,String Password,String Nationality) throws Exception
	
		{
			if(Browser.equalsIgnoreCase("Chrome"))
			{
				driver = TestBrowser.OpenChromeBrowser();
			 	
		    }

			if(Browser.equalsIgnoreCase("FireFox"))
			{
					driver = TestBrowser.FirefoxBrowser();
					Thread.sleep(10000);
			}
			
			
			if(Browser.equalsIgnoreCase("RemoteWebDriver1"))
			{
					driver = TestBrowser.RemoteWebDriver();
					Thread.sleep(6000);
			}
			
		
		TC03_Login_Static_Paarameters.OpenOrangeHRM();
		TC03_Login_Static_Paarameters.Login(UserName,Password);
		TC03_Login_Static_Paarameters.AddNationalities(Nationality);
		driver.quit();
	}
	
	//local variables
	public static void Login(String UserName1,String Password1) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
	}
	
	public static   void AddNationalities(String Nationality1) throws Exception
	{
		

		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
		findElement(By.id("btnSave")).click();
		
		
	}
	
	
	public static  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
 
	
	
	
	
	
	public static void OpenOrangeHRM() throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public static void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
