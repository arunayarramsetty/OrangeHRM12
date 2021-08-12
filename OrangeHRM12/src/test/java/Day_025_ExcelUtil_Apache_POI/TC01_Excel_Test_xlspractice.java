package Day_025_ExcelUtil_Apache_POI;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Excel_Test_xlspractice
{
	
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
   
	//String TestURL,Username,Password;
	WebDriver driver;
	
	//String TestURL,UserName,Password;
	
  @Test
  public void hello1(String TestURL,String Username,String Password) throws Exception {
	  
	  TC01_Excel_Test_xlspractice eat = new TC01_Excel_Test_xlspractice();
	  TestURL = eat.getCellData("C://HTMLReport//OrangeHRM6//Book6.xlsx","Sheet1",1,0);
	  TestURL = eat.getCellData("C://HTMLReport//OrangeHRM6//Book6.xlsx","Sheet1",1,1);
	  TestURL = eat.getCellData("C://HTMLReport//OrangeHRM6//Book6.xlsx","Sheet1",1,2);
	  
	  System.out.println("TestURL : "+TestURL);
	  System.out.println("UserName : "+Username);
	  System.out.println("Password : "+Password);
	  //System.out.println("Nationality :"+Nationality);
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
	
		 findElement(By.name("txtUsername")).sendKeys(Username);
		 findElement(By.name("txtPassword")).sendKeys(Password);
	     findElement(By.id("btnLogin")).click();
	     
		 driver.quit();
	  
	  
  }
public String getCellData(String xlFilepath, String sheetName, int rowNum, int column)throws Exception
 {
	fis = new FileInputStream(xlFilepath);
	workbook = new XSSFWorkbook(fis); 
    sheet = workbook.getSheet(sheetName); 
    row = sheet.getRow(rowNum); 
    cell = row.getCell(column); 
	
    if(cell.getCellTypeEnum() == CellType.STRING)
    {	
    	String str6=cell.getStringCellValue();
    	System.out.println(" str6 value : "+str6);
    	
    	workbook.close();
    	fis.close();
        return str6;
    }
    else if(cell.getCellTypeEnum() == CellType.NUMERIC)
    {	
    	
    	int i = (int)cell.getNumericCellValue(); 
    	String str6 = String.valueOf(i); 
    	workbook.close();
    	fis.close();
        return str6;
    }
    else 
    {
    	String str6=cell.getStringCellValue();
    	workbook.close();
    	fis.close();
        return str6;
    }
    
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
  
  
  
  
  

