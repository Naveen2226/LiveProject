package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	Workbook wb;
	public ExcelFileUtil() throws Exception{
		FileInputStream fi= new FileInputStream("C:\\Users\\naveen\\Desktop\\Naveen\\LiveProject\\Excelfiles\\supplier.xlsx");
		 wb= new XSSFWorkbook(fi);
		
		
		 }
	public int rowCount(String Sheetname){
		return wb.getSheet(Sheetname).getLastRowNum();
	}
	public int colCount(String Sheetname){
		return wb.getSheet(Sheetname).getRow(0).getLastCellNum();
	}
		
	
	
	public String getData(String Sheetname,int row,int column){
		String data;
		if(wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC){
		int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
		data=String.valueOf(celldata);
		
		}else{
			data=wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
		
		
	}
	public void setData(String Sheetname,int row,int column,String status) throws Exception{
		Sheet sh=wb.getSheet(Sheetname);
		Row rownumber=sh.getRow(row);
		Cell cellnumber=rownumber.createCell(column);
		cellnumber.setCellValue(status);
		
		if(status.equalsIgnoreCase("Pass")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			
			rownumber.getCell(column).setCellStyle(style);
		}
		if(status.equalsIgnoreCase("fail")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			
			rownumber.getCell(column).setCellStyle(style);
		}
		if(status.equalsIgnoreCase("Not Executed")){
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			
			rownumber.getCell(column).setCellStyle(style);
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\naveen\\Desktop\\Naveen\\LiveProject\\Excelfiles\\supplier.xlsx");
		wb.write(fos);
		fos.close();
	}
} 
