package  Day_011_Katalon_Recorder;
import CommonUtil.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;


public class TC01_Test3
{
	
	WebDriver driver;
	Reporter1 R1;
	
	
	//@Test
	  public void testTC01AddNationalities() throws Exception {
		 
		driver = TestBrowser.OpenChromeBrowser();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	    driver.findElement(By.id("txtUsername")).click();
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    
	    //driver.findElement(By.id("frmLogin")).click();
	    driver.findElement(By.id("txtPassword")).click();
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    
	    
	    //driver.findElement(By.id("frmLogin")).click();
	    driver.findElement(By.id("btnLogin")).click();
	    
	    
	    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    driver.findElement(By.id("menu_admin_nationality")).click();
	    driver.findElement(By.id("btnAdd")).click();
	    driver.findElement(By.id("nationality_name")).click();
	    driver.findElement(By.id("nationality_name")).clear();
	    driver.findElement(By.id("nationality_name")).sendKeys("Indian902");
	    driver.findElement(By.id("btnSave")).click();
	  }
	 
	 
	// @Test
	  public void testTC01AddSkills() throws Exception {
		 
		driver = TestBrowser.OpenChromeBrowser();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	   // driver.findElement(By.xpath("//div[@id='divUsername']/span")).click();
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    
	    //driver.findElement(By.id("frmLogin")).click();
	    driver.findElement(By.id("txtPassword")).click();
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	    
	    
	    driver.findElement(By.id("btnLogin")).click();
	    
	    
	    driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    driver.findElement(By.id("menu_admin_Qualifications")).click();
	    driver.findElement(By.id("menu_admin_viewSkills")).click();
	    driver.findElement(By.id("btnAdd")).click();
	    driver.findElement(By.id("skill_name")).click();
	    driver.findElement(By.id("skill_name")).clear();
	    driver.findElement(By.id("skill_name")).sendKeys("Java18");
	    driver.findElement(By.id("skill_description")).click();
	    driver.findElement(By.id("skill_description")).clear();
	    driver.findElement(By.id("skill_description")).sendKeys("java18 descr");
	    driver.findElement(By.id("btnSave")).click();
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Test
	  public void testTC01Skills() throws Exception {
		 
		 driver = TestBrowser.OpenChromeBrowser();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    //driver.findElement(By.xpath("//div[@id='divUsername']/span")).click();
	    findElement(By.id("txtUsername")).clear();
	    findElement(By.id("txtUsername")).sendKeys("Admin");
	    //findElement(By.id("frmLogin")).click();
	    findElement(By.id("txtPassword")).click();
	    findElement(By.id("txtPassword")).clear();
	    findElement(By.id("txtPassword")).sendKeys("admin123");
	    findElement(By.id("btnLogin")).click();
	    
	    
	    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
	    findElement(By.id("menu_admin_Qualifications")).click();
	    findElement(By.id("menu_admin_viewSkills")).click();
	    findElement(By.id("btnAdd")).click();
	    findElement(By.id("skill_name")).click();
	    findElement(By.id("skill_name")).clear();
	    findElement(By.id("skill_name")).sendKeys("Java56");
	    findElement(By.id("skill_description")).click();
	    findElement(By.id("skill_description")).clear();
	    findElement(By.id("skill_description")).sendKeys("java56 descr");
	    findElement(By.id("btnSave")).click();
	  }

	

	
	// Draws a red border around the found element. Does not set it back anyhow.
	public  WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		// draw a border around the found element
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}
			
		
	
	
	
	
	
	
	
	
	
	
	
	

}












