package Education_status;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class work_shift
{
	 WebDriver driver;
	
	@DataProvider(name = "TC01_Workshift")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://Users//USER//Desktop//Workshift.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
  @Test(dataProvider="TC01_Workshift")
  public void AADINGSTATUS(String Browser,String TestURL,String username,String password,String workshiftname) throws Exception
  
  {
	  work_shift e1=new work_shift();
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
		{
			
		  e1.openingchrome(TestURL);
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
			e1.openingfirefox(TestURL);
		 	
		}
	  
	 // e1.openingchrome(TestURL);
	 // e1.openingfirefox(TestURL);
		e1.openingorangeHrm(TestURL);
	  e1.login(username, password);
	 e1.categories(workshiftname);
	  e1.CloseBrowser();
	  
  }
  public void openingchrome(String TestURL)throws Exception
  {
	//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;	
			
	  
  }
  
  public void openingfirefox(String TestURL)throws Exception
  {
	//Launch Browser
			System.setProperty("webdriver.gecko.driver","C:\\FireFoxDriver\\geckodriver.exe");
			driver =new FirefoxDriver();
			driver.manage().window().maximize() ;	
			
	  
  }
  public void openingorangeHrm(String TestURL)
  {
	  driver.get(TestURL);
  }
  public void login(String username,String password)throws Exception
  {
	  	findElement(By.id("txtUsername")).sendKeys(username);
		findElement(By.id("txtPassword")).sendKeys(password);
		findElement(By.id("btnLogin")).click();
  }
  public void categories(String workshiftname)throws Exception
  {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_workShift")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("workShift_name")).sendKeys(workshiftname);
		findElement(By.id("btnSave")).click();


	  
  }
  
  public void CloseBrowser() throws Exception
  {
	  driver.quit();
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
