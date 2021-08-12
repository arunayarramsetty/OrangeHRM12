package Day_025_ExcelUtil_Apache_POI;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class excel_read {
	
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
	
    String TestURL,UserName,Password;
    WebDriver driver;
  @Test
  public void Excel_read( )throws Exception {
	  
	  //FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//TestData//application.properties");
	  excel_read eat1=new excel_read();
	  TestURL = eat1.getCellData("C://HTMLReport//OrangeHRM6//Read_excel.xlsx","Sheet1",1,0);
	  UserName = eat1.getCellData("C://HTMLReport//OrangeHRM6//Read_excel.xlsx","Sheet1",1,1);
	  Password = eat1.getCellData("C://HTMLReport//OrangeHRM6//Read_excel.xlsx","Sheet1",1,2);
	  
	  System.out.println("TestURL : "+TestURL);
	  System.out.println("UserName : "+UserName);
	  System.out.println("Password : "+Password);
}
  public String getCellData(String xlFilePath, String sheetName,int rowNum,int column) throws Exception
  {
  	fis = new FileInputStream(xlFilePath);  //excel File path
      workbook = new XSSFWorkbook(fis);   // workbook open
      sheet = workbook.getSheet(sheetName); //Sheet1 open
      row = sheet.getRow(rowNum); // 1st will be highlighted
      cell = row.getCell(column); // 1th column will be highlited
     
      if(cell.getCellTypeEnum() == CellType.STRING)
      {	
      	String str6=cell.getStringCellValue();
      	System.out.println("Cell Value is :"+str6);
      	
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
}


