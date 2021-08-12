package AADITYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Addskills {
	
	WebDriver driver;
	
	String UserName = "Admin", Password = "Admin123";
	String jobTitle = "Software Engineer" , jobDescription = "Selinium Tester";
	
	@Test
  
  public void f()  throws Exception {
		
		Addskills l1 = new  Addskills();
		
		l1.OpenBrowser();
		l1.OpenOrangeHrm();
		l1.Login();
		l1.Addskills1();
	}
	
	public void  OpenBrowser() throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	}
	
	public void OpenOrangeHrm() throws Exception {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	public void Login() throws Exception {
		
		driver.findElement(By.name("txtUsername")).sendKeys(UserName);
		//driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();	
	}
		
	public void  Addskills1() throws Exception {
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();	
		driver.findElement(By.id("menu_admin_Job")).click();	
		driver.findElement(By.id("menu_admin_viewJobTitleList")).click();	
		driver.findElement(By.id("btnAdd")).click();	
		driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(jobTitle);
		driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDescription);
		driver.findElement(By.id("btnSave")).click();
	}
		
		
		   }  
  
