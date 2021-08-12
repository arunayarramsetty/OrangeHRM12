package Day_002_Java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC02_Login_Static_Example {
	
	
	static WebDriver driver;
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String UName="Admin",Password="admin123";
	//String LocationName="Hyderabad13",CountryName="India";
	
	//step1
	@DataProvider(name="test1")
	  public static Object[][] Test1() throws Exception {
	 
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM6\\add_locationjs_excel.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
		
	  }
	@Test(dataProvider="test1")
	public  void AddLocationsTest(String Browser, String TestURL,String UName,String Password,String LocationName,String CountryName ) throws Exception
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
		
		//TC02_Login_Static_Example.OpenChromeBrowser();
		TC02_Login_Static_Example.OpenOrangeHRM(TestURL);
		TC02_Login_Static_Example.Login(UName,Password);
		TC02_Login_Static_Example.AddLocations(LocationName,CountryName);
	}
	
	
	public static  void OpenOrangeHRM(String TestURL) throws Exception
	{
		//driver.get("TestURL");//Wrong argument
		driver.get(TestURL);
		
	}
	
	
	
	public static void Login(String UName,String Password) throws Exception
	{
		findElement(By.name("txtUsername")).sendKeys(UName);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();

	}

	
	public static void AddLocations(String LocationName,String CountryName1) throws Exception
	{
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Organization")).click();
		findElement(By.id("menu_admin_viewLocations")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("location_name")).sendKeys(LocationName);
		Select dropdown1 = new Select(findElement(By.id("location_country")));
		dropdown1.selectByVisibleText(CountryName1);
		findElement(By.id("btnSave")).click();
		
	}
	
	
	
	
	
	
	 public static   WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

	
	

}
