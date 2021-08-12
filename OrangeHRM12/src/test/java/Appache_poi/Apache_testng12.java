package Appache_poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.testng.annotations.Test;




public class Apache_testng12 {
	
	public FileInputStream fis = null;
    public FileOutputStream fout=null;
    
    public HSSFWorkbook workbook = null;
    public HSSFSheet sheet = null;
    public HSSFRow row = null;
    public HSSFCell cell = null;

	
  @Test
  public void hello()throws Exception
  {
  	
	  Apache_testng12 eat=new Apache_testng12();
  	
  	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport45.xls","Sheet3",0,0,"Admin");
  	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport45.xls","Sheet3",0,1,"admin123");
  	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport45.xls","Sheet3",0,2,"Chandra");
  	eat.PutCellData( "C://HTML Report//OrangeHRM6//TC01_EMPExport45.xls","Sheet3",0,3,"Mouli");
  	
  	System.out.println("Data succefully exported into excel");
  }

  public  void PutCellData(String xlFilePath,String sheetName,int rowNum,int column,String Text)
  		throws Exception
  {
  	
 	 
 	 	fis = new FileInputStream(xlFilePath);
      workbook = new HSSFWorkbook(fis);
  	sheet = workbook.getSheet(sheetName);
  	
  	if(sheet.getRow(rowNum)==null)
  	{
  		row=sheet.createRow(rowNum);
  	}
  	else
  	{
  		row=sheet.getRow(rowNum);
  	}

	if(row.getCell(column)==null)
	{
		cell=row.createCell(column);
	}
	else
	{
		cell=row.getCell(column);
	}

	cell = sheet.getRow(rowNum).getCell(column);  
	cell.setCellValue(Text);

    CellStyle cs1 = workbook.createCellStyle(); 
    cs1.setFillForegroundColor(IndexedColors.WHITE.getIndex()); 
    cs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    Font font = workbook.createFont();
    font.setColor(IndexedColors.BLUE.getIndex());
    font.setBold(false);
    cs1.setFont(font);

    cell.setCellStyle(cs1);
	
	cell.setCellValue(Text);
	fout= new FileOutputStream(xlFilePath);
	workbook.write(fout);
	  fout.flush();
      fout.close();
      workbook.close();
      fis.close();
      
   	

  }
}
