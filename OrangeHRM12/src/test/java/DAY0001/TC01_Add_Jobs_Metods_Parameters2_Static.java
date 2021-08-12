package DAY0001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Jobs_Metods_Parameters2_Static {
	
	static WebDriver driver;
	
	//Step1
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String JobTitle="Sales80",JobDescr="Sales80 descr",JobNote="Sales80 Note";
	
  @Test
  public void Add_Jobs_test()throws Exception {
	  
	
	  
	  TC01_Add_Jobs_Metods_Parameters2_Static.OpenChromeBrowser();
	  TC01_Add_Jobs_Metods_Parameters2_Static.OpenOrangeHRM(TestURL);
	  TC01_Add_Jobs_Metods_Parameters2_Static.Login(UserName,Password);
	  TC01_Add_Jobs_Metods_Parameters2_Static.AddJobs(JobTitle,JobDescr,JobNote);  //Step2
	  TC01_Add_Jobs_Metods_Parameters2_Static.CloseBrowser();
			

  }
  
  
  
  
  
  
  
  
  public static void OpenChromeBrowser()throws Exception {
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	  
  }
  
  
  
  
  public  static void OpenOrangeHRM(String TestURL1)throws Exception {
	  
		//Open Orange HRM
		driver.get(TestURL1);
	  
  }
  
  
  
  
  public static void Login(String UserName1,String Password1)throws Exception {
	  
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
  }
  
  public static void AddJobs(String JobTitle,String JobDescr,String JobNote )throws Exception {
	  
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
  
  
 public static void CloseBrowser()throws Exception {
	  

		driver.quit();
	  
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
