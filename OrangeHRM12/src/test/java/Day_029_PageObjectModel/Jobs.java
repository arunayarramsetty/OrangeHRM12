package  Day_029_PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Jobs
{
	
	WebDriver driver;
	
	public void Jobs(WebDriver driver)
	{
		this.driver = driver;
	}
	

	
	public void AddJobs() throws Exception {
		


		    findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']/b")).click();
		    findElement(By.id("menu_admin_Job")).click();
		    findElement(By.id("menu_admin_viewJobTitleList")).click();
		    findElement(By.id("btnAdd")).click();
		    
		    findElement(By.id("jobTitle_jobTitle")).click();
		    findElement(By.id("jobTitle_jobTitle")).clear();
		    findElement(By.id("jobTitle_jobTitle")).sendKeys("Sala36");
		    
		    findElement(By.id("jobTitle_jobDescription")).click();
		    findElement(By.id("jobTitle_jobDescription")).clear();
		    findElement(By.id("jobTitle_jobDescription")).sendKeys("Sala36556");
		    
		    
		    findElement(By.id("jobTitle_note")).click();
		    findElement(By.id("jobTitle_note")).clear();
		    findElement(By.id("jobTitle_note")).sendKeys("Sala36 fgsd");
		    
		    findElement(By.id("btnSave")).click();
	}
	
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	
	
	
	
}















