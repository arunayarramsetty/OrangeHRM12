package bharath;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_Excel_Test_xls {
	public FileInputStream fis = null;
	public HSSFWorkbook  workbook = null;
	public HSSFSheet sheet = null;
	public HSSFRow row = null;
	public HSSFCell cell = null;
	
	
	String TestURL ,UserName,Password;
	WebDriver driver;
	
  @Test
  public void hello1() throws Exception {
	  
	  TC01_Excel_Test_xls eat = new TC01_Excel_Test_xls();
	  TestURL = eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nation.xls","Sheet1",1,0);
	  TestURL = eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nation.xls","Sheet1",1,1);
	  TestURL = eat.getCellData("C://HTML Report//OrangeHRM6//TC01_Nation.xls","Sheet1",1,2);
	  
	  System.out.println("TestURL   :"+TestURL);
	  System.out.println("UserName:" +UserName);
	  System.out.println("Password:"+ Password);
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 driver =new ChromeDriver();
		 driver.manage().window().maximize() ;	
		 driver.get(TestURL);
		 
		 findElement(By.name("txtUsername")).sendKeys(UserName);
		 findElement(By.name("txtPassword")).sendKeys(Password);
		 findElement(By.name("btnLogin")).click();
		 
		 driver.quit();
  }
  public String getCellData(String xlFilepath,String sheetName,int rowNum,int column)throws Exception{
	  
	  fis = new FileInputStream(xlFilepath);
	  workbook = new HSSFWorkbook(fis);
	  sheet = workbook.getSheet(sheetName);
		 row =sheet.getRow(rowNum);
		 cell=row.getCell(column);
		 
		 if(cell.getCellTypeEnum() == CellType.STRING) {
			 
			 String str6 = cell.getStringCellValue();
			 System.out.println("str6 value:"+str6);
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

