package com.sb.workbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.workbook.ExcelExport.UserExcelGenerator;
import com.sb.workbook.entity.Users;
import com.sb.workbook.repository.UserRepository;
import com.sb.workbook.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/excel")
	public void  generateExcelReport(HttpServletResponse response) throws IOException {
 //Whatever the file we are generating that file should be download whenever we send a req to this
		//controller method for that we need to set the content type.
		
		response.setContentType("application/octet-stream");
		 String headerKey ="Content-Disposition";
		 String headerValue ="attachment;filename=todolist.xlsx";
		 response.setHeader(headerKey, headerValue);
		 List<Users> users=userRepo.findAll();
			UserExcelGenerator exp= new UserExcelGenerator(users);
             exp.generate(response);
}
	

}
