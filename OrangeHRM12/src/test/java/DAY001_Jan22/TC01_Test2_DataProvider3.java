package DAY001_Jan22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC01_Test2_DataProvider3 {
	
	WebDriver driver;
	
	//String TESTURL="https://opensource-demo.orangehrmlive.com/";
	//String USERNAME="Admin",PASSWORD="admin123";
	//String JOBTITLE="Sales5",JOBDESCR="Sales5 Descr",JOBNOTE="Sales5 Note";
	
	//Step1
	@DataProvider(name = "TC01_Add_Nationality")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC03_Add_Jobs.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	 
	 	
	
  @Test (dataProvider="TC01_Add_Nationality" )//Step2
  public void Test1_Login(String Browser,String TESTURL,String USERNAME,String PASSWORD, 
		  String JOBTITLE,String JOBDESCR,String JOBNOTE) throws Exception{  //step3
	  
	  TC01_Test2_DataProvider3 T1= new TC01_Test2_DataProvider3();
	  
	 // T1.OpenChromeBrowser();
	  
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
		{
			
		  T1.OpenChromeBrowser();
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
			T1.OpenFireFOXBrowser();
		 	
		}
	  
	  
	  T1.OpenOrangeHRM(TESTURL);	
	  T1.Login(USERNAME,PASSWORD);
	 // T1.AddJobs(JOBTITLE,JOBDESCR,JOBNOTE);
	  T1.CloseBrowser();	


	  
  }
  
  
  public void OpenChromeBrowser() throws Exception{
	  
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public void OpenFireFOXBrowser() throws Exception{
	  
	     System.setProperty("webdriver.gecko.driver","C:\\FireFoxDriver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		 
		 Thread.sleep(6000);
		 driver.manage().window().maximize() ;	

  }
  
  
  public void OpenOrangeHRM(String TestURL) throws Exception{
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  
  public void Login(String UserName,String Password) throws Exception{
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  
  public void AddJobs(String JobTitle,String JobDescr,String JobNote) throws Exception{
		
		//Add Jobs
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote);
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
