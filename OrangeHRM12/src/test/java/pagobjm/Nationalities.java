package pagobjm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nationalities 

{
	WebDriver driver;
	public void Nationalitiesdriver (WebDriver driver) throws Exception
	{
		this .driver=driver;
		
	}
	public void addNationalities() throws Exception
	{
		 findElement(By.linkText("Admin")).click();
		 findElement(By.linkText("Nationalities")).click();
		 findElement(By.name("btnAdd")).click();
		 findElement(By.id("nationality_name")).sendKeys("122");
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
