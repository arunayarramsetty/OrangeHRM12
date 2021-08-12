package Day02_Feb02_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC01_Add_Skills2_DataProvider2 {
	
	static WebDriver driver ;
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	String UserName="Admin",Password="admin123";
	String SkillName="Java79",SkillDescr="Java79 desc";
	
	
	
	
	//Step1
	@DataProvider(name = "TC01_Add_Skills")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://TC01_Skills_Data1.xlsx", "Sheet1");
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	
	
  @Test(dataProvider="TC01_Add_Skills")//Step2
  public void Add_Skills(String Browser,String TestURL,String UserName,String Password,String SkillName,String SkillDescr ) throws Exception {    //Step3
	  
	  TC01_Add_Skills2_DataProvider2 T1=new TC01_Add_Skills2_DataProvider2();
	  

		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver = TestBrowser.OpenChromeBrowser();
		 	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
				driver = TestBrowser.FirefoxBrowser();
				Thread.sleep(10000);
		}
		
		
	  
	  //T1.OpenCHromeBrowser();
	  T1.OpenOrangeHRM(TestURL);
	  T1.Login(UserName,Password);
	 // T1.AddSKills(SkillName,SkillDescr);
	  T1.CloseBrowser();
	
		
		
  }
  
  public void OpenCHromeBrowser() throws Exception
  {
	  
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
	  
  }
  
  public void OpenOrangeHRM(String TestURL1) throws Exception
  {

		//Open Orange HRM
		driver.get(TestURL1);
	  
  }
  
  
  public void Login(String UserName1,String Password1) throws Exception
  {
	  		//Login
			findElement(By.id("txtUsername")).sendKeys(UserName1);
			findElement(By.id("txtPassword")).sendKeys(Password1);
			findElement(By.id("btnLogin")).click();
  }
  
  
  public void AddSKills(String SkillName1,String SkillDescr1) throws Exception
  {
		//AddSKills
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName1);
		findElement(By.id("skill_description")).sendKeys(SkillDescr1);
		findElement(By.id("btnSave")).click();
  }
  
  public void CloseBrowser() throws Exception
  {
		
		//close browser
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
