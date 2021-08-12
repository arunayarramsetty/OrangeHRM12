package DAY01_FEB19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Test2_Methods_Parameter {
	
	WebDriver driver;
	
	//String TESTURL="https://opensource-demo.orangehrmlive.com/";
	//String USERNAME="Admin",PASSWORD="admin123";
	//String JOBTITLE="Sales5",JOBDESCR="Sales5 Descr",JOBNOTE="Sales5 Note";
	
	
	
	//step1
	 @DataProvider(name = "Orange1")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales5","Sales5 Descr","Sales5 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales6","Sales6 Descr","Sales6 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales7","Sales7 Descr","Sales7 Note" }
	        	};
	  }
	 
	
	
	
  @Test(dataProvider="Orange1")//Step2
  public void Test1_Login(String TESTURL,String USERNAME,
		  String PASSWORD,String JOBTITLE,String JOBDESCR,String JOBNOTE) throws Exception{
	  
	  TC01_Test2_Methods_Parameter T1= new TC01_Test2_Methods_Parameter();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TESTURL);	
	  T1.Login(USERNAME,PASSWORD);
	  T1.AddJobs(JOBTITLE,JOBDESCR,JOBNOTE);
		


	  
  }
  
  
  public void OpenChromeBrowser() throws Exception{
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception{
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  
  public void Login(String UserName,String Password) throws Exception{
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
  }
  
  
  public void AddJobs(String JobTitle,String JobDescr,String JobNote) throws Exception{
		
		//Add Jobs
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_Job")).click();
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		driver.findElement(By.id("jobTitle_note")).sendKeys(JobNote);
		driver.findElement(By.id("btnSave")).click();
  }
  
}
