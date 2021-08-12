package Mama_Day001;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Add_Skills2 {
	
	WebDriver driver;
	@DataProvider(name="skills1")
	public static Object[][] Test1() throws Exception {
		 
        return new Object[][] { 
        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","java","java_description"},
        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","selenium","selenium_description" }
        	};
  }
	
  @Test(dataProvider="skills1")
  public void Skills(String url,String username,String password,String skill_name,String skill_description) throws Exception {
	  
	  TC01_Add_Skills2 s1=new TC01_Add_Skills2();
	  s1.OpenBrowser();
	  s1.launch_url(url);
	  s1.login(username,password);
	  s1.addskills(skill_name,skill_description);
	  s1.close();


  }
  
  
  public void OpenBrowser()  throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  public void launch_url(String url) throws Exception{
	  driver.get(url);
		
  }
  public void login(String username,String password) throws Exception{
	  findElement(By.id("txtUsername")).sendKeys(username);
		findElement(By.id("txtPassword")).sendKeys(password);
		findElement(By.id("btnLogin")).click();
  }
  public void addskills(String skill_name,String skill_description) throws Exception{
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Qualifications")).click();
	  findElement(By.id("menu_admin_viewSkills")).click();
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("skill_name")).sendKeys(skill_name);
	  findElement(By.id("skill_description")).sendKeys(skill_description);
	   
  }
  public void close() throws Exception{
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
