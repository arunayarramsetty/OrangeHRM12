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

public class TC05_Login_NonStatic_Paarameters {
	
	
	static WebDriver driver;
	
	
	@DataProvider(name = "Orange3")
	  public static Object[][] Test1() throws Exception {
	 
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM61//TC01_Nationality2.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
		
	  }
	
	@Test(dataProvider="Orange3")
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
				Thread.sleep(8000);
		}
		
		
	
		TC05_Login_NonStatic_Paarameters TN1=new TC05_Login_NonStatic_Paarameters();
		
		
		TN1.OpenOrangeHRM(TestURL);
		TN1.Login(UserName,Password);
		TN1.AddNationalities(Nationality);
		
		driver.quit();
	
	}


	public  void Login(String UserName1,String Password1) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UserName1);
		findElement(By.name("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
	}
	

	public    void AddNationalities(String Nationality1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_nationality")).click();
		findElement(By.name("btnAdd")).click();
		findElement(By.id("nationality_name")).sendKeys(Nationality1);
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
 
	
	
	
	
	
	public  void OpenOrangeHRM(String testURL) throws Exception
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public  void OpenChromeBrowser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	
	}
	
	
	
	
	
	
	
	

}
