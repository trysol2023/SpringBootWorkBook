package com.sb.workbook.ExcelExport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sb.workbook.entity.Users;

public class UserExcelGenerator {

	
	  private XSSFWorkbook workbook;
	  private XSSFSheet sheet;
	  private List<Users> listUsers;
	  
	// whenever this constructor is called at that time Users info will be passed when we create 
	 // an object for this class
	  public UserExcelGenerator(List<Users>listUsers) {
		  this.listUsers=listUsers;
		  workbook = new XSSFWorkbook(); 
	  }
	  private void createCell(Row row,int columnCount,Object value, CellStyle style) {
		  sheet.autoSizeColumn(columnCount); //Adjusts the column width to fit the contents.
		  Cell cell =  row.createCell(columnCount);
		  
		  if(value instanceof Long ) {
			  cell.setCellValue((Long)value);
		  }else if(value instanceof Integer) {
			  cell.setCellValue((Integer)value);
		  }else if(value instanceof Boolean) {
			  cell.setCellValue((Boolean)value);
		  }else {
			  cell.setCellValue((String)value);
		  }
		  cell.setCellStyle(style);
	  }
	  
	  private void writeHeader() {
		  sheet=workbook.createSheet("Users");
		  Row row= sheet.createRow(0);
		  CellStyle style = workbook.createCellStyle();
		  XSSFFont font = workbook.createFont();
		  font.setBold(true);
		  font.setFontHeight(16);
		  style.setFont(font);
		  
		  createCell(row,0,"id",style);		  
		  createCell(row,1,"userName",style);
		  createCell(row,2,"description",style);
		  createCell(row,3,"dueDate",style);
		  createCell(row,4,"status",style);
	  }
	  
	  private void write() {
		  int rowCount = 1;
		  CellStyle style = workbook.createCellStyle();
		  XSSFFont font = workbook.createFont();
		  font.setBold(true);
		  font.setFontHeight(14);
		  style.setFont(font);
		  
		  for(Users user:listUsers) {
			  Row row = sheet.createRow(rowCount++);
			  int columnCount=0;
			  createCell(row,columnCount++,user.getId(),style);
			  createCell(row,columnCount++,user.getUserName(),style);
			  createCell(row,columnCount++,user.getDescription(),style);
			  createCell(row,columnCount++,user.getDueDate(),style);			
			  createCell(row,columnCount++,user.getStatus(),style);
		  }
		  }
	  public void generate(HttpServletResponse response) throws IOException{
		  writeHeader();
		  write();
		 ServletOutputStream outputStream = response.getOutputStream();
		 workbook.write(outputStream);
		 workbook.close();
		 outputStream.close();
	  }
}
