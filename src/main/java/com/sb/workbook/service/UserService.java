package com.sb.workbook.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.workbook.ExcelExport.UserExcelGenerator;
import com.sb.workbook.entity.Users;
import com.sb.workbook.repository.UserRepository;


@Service
public class UserService{
	
	/*@Autowired
	private UserRepository UserRepo;
        
	public void generateExcel(HttpServletResponse response) throws IOException {
		/*HttpServletResponse - when user send a req directly that excel file should ne downloaded
		in the browser, so i sending that excel file as a response to the client.*/
		
		
		
	
	/*	HSSFWorkbook workbook = new HSSFWorkbook();
		//HSSFWorkbook - predefined class in Apache POI
		HSSFSheet sheet = workbook.createSheet("Users info");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("userName");
		row.createCell(2).setCellValue("description");
		row.createCell(3).setCellValue("dueDate");
		row.createCell(4).setCellValue("status");

		
		int dataRowIndex =1;
		for(Users userdata: users) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(userdata.getId());
		    dataRow.createCell(1).setCellValue(userdata.getUserName());
		    dataRow.createCell(2).setCellValue(userdata.getDescription());
		    dataRow.createCell(3).setCellValue(userdata.getDueDate());
		    dataRow.createCell(4).setCellValue(userdata.getStatus());

		    dataRowIndex++;

		}
		//Now we neeed to store this excel data to a excel file and we need to send this file
		// in a response.
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}*/
}

























