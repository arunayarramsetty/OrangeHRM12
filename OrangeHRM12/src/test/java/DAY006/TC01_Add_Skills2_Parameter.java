package DAY006;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Add_Skills2_Parameter {
	
	WebDriver driver;
	
	String TESTURL="https://opensource-demo.orangehrmlive.com/";
	String USERNAME="Admin", PASSWORD="admin123";
	String SKILLNAME="Java18",SKILLDESCR="Java18descr";
			
	
  @Test
  public void AddSkills() throws Exception{
	  
	  TC01_Add_Skills2_Parameter T1=new TC01_Add_Skills2_Parameter();
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TESTURL);
	  T1.Login(USERNAME,PASSWORD);
	  T1.AddSKills1(SKILLNAME,SKILLDESCR);

		
  }
  

  public void OpenChromeBrowser() throws Exception
  {
	  	//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  public  void OpenOrangeHRM(String TestURL) throws Exception
  {
		//Open Orange HRM
		driver.get(TestURL);
  }
  
  
  public void Login(String UserName,String Password) throws Exception
  {
		//Login
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
  }
  
  public void AddSKills1(String SkillName,String SkillDescr) throws Exception
  {
		//Add Skills		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
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
