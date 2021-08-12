package rsr;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC01_Add_jobs_DataProvider2 {
	
	WebDriver driver;
	//String TESTURL="https://opensource-demo.orangehrmlive.com/";
	//String USERNAME="Admin", PASSWORD="admin123";
	//String JOBTITLE="Sales17",JOBDESCR="Sales17 descr",JOBNOTE="Sales17 Note";
	
	
	
	//step1
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Add_Jobs.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	 	
	
  @Test(dataProvider="Orange2")//Step2
  public void AddJobs(String TESTURL,String USERNAME,String PASSWORD, 
		  String JOBTITLE,String JOBDESCR,String JOBNOTE )throws Exception {  //step3
	  

	  TC01_Add_jobs_DataProvider2 T1= new TC01_Add_jobs_DataProvider2();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TESTURL);
	  T1.Login(USERNAME,PASSWORD);
	  T1.AddJobs1(JOBTITLE,JOBDESCR,JOBNOTE);
		
		
  }
  
  
  public void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception
  {
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  
  
  
  public void Login(String UserName,String Passowrd) throws Exception
  {
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Passowrd);
		findElement(By.id("btnLogin")).click();
  }
  
  
  
  
  public void AddJobs1(String JobTitle,String JobDescr,String JobNote) throws Exception
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
