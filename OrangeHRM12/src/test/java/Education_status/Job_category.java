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

public class Job_category
{
	 WebDriver driver;
	
	@DataProvider(name = "TC01_Jobcategory")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://OrangeHRM6//Addingeducationstatus2.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
  @Test(dataProvider="TC01_Jobcategory")
  public void AADINGSTATUS(String Browser,String TestURL,String username,String password,String categoryname) throws Exception
  
  {
	  Job_category e1=new Job_category();
	  
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
	 // e1.categories(categoryname);
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
  public void categories(String categoryname)throws Exception
  {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_jobCategory")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobCategory_name")).sendKeys(categoryname);
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
