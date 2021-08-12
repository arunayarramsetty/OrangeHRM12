package  Day_003_Locators;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

public class TC03_xpath4
{
	
	TestData td= new TestData();
	
	static WebDriver driver;
	

	//*[@id='txtUsername']
	//*[@id='txtPassword']
	//*[@id='btnLogin']
	//*[@id="txtUsername"]
	
	public  String  UserName=td.getData().get("UserName");
	public  String  Password=td.getData().get("Password");
	public  String  LoginButton1=td.getData().get("LoginButton");
	
	
	
	public  String  Admin="//*[@id='menu_admin_viewAdminModule']/b";
	public  String  Nationality="//*[@id='menu_admin_nationality']";

	@Test
	public void Test2() throws Exception {
		
	
		driver = TestBrowser.OpenChromeBrowser();
		
		String TestURL = "https://opensource-demo.orangehrmlive.com/";
		driver.get(TestURL);
	
		findElement(By.xpath(UserName)).sendKeys("Admin");
		findElement(By.xpath(Password)).sendKeys("admin123");
		
		
		System.out.println("Login button Xpath is :"+LoginButton1);
		
		findElement(By.xpath(LoginButton1)).click();
		
		findElement(By.xpath(Admin)).click();
		findElement(By.xpath(Nationality)).click();
		
		
		
		

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












