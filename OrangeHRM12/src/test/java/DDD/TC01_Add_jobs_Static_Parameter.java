package DDD;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_jobs_Static_Parameter {
	
	static WebDriver driver;
	String TESTURL="https://opensource-demo.orangehrmlive.com/";
	String USERNAME="Admin", PASSWORD="admin123";
	String JOBTITLE="Sales17",JOBDESCR="Sales17 descr",JOBNOTE="Sales17 Note";
	
  @Test
  public void AddJobs()throws Exception {
	  


	  
	  TC01_Add_jobs_Static_Parameter.OpenChromeBrowser();
	  TC01_Add_jobs_Static_Parameter.OpenOrangeHRM(TESTURL);
	  TC01_Add_jobs_Static_Parameter.Login(USERNAME,PASSWORD);
	  TC01_Add_jobs_Static_Parameter.AddJobs1(JOBTITLE,JOBDESCR,JOBNOTE);
		
		
  }
  
  
  public static void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public static  void OpenOrangeHRM(String TestURL) throws Exception
  {
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  
  
  
  public static void Login(String UserName,String Passowrd) throws Exception
  {
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Passowrd);
		findElement(By.id("btnLogin")).click();
  }
  
  
  
  
  public static void AddJobs1(String JobTitle,String JobDescr,String JobNote) throws Exception
  {
		//AddJobs
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		findElement(By.id("btnSave")).click();
  }
  
  
  
  
  
  
  public static WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}



  
  
}
