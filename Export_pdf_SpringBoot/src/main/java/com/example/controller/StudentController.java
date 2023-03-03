package com.example.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Student;
import com.example.service.StudentService;
import com.example.util.PdfGenerator;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

public class StudentController {
  @Autowired
	private StudentService studentService;
  @GetMapping("/export-to-pdf")
  public String generatePdfFile(HttpServletResponse response) throws DocumentException, IOException 
  {
	  System.out.println("controller");
    response.setContentType("application/pdf");
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
    String currentDateTime = dateFormat.format(new Date());
    String headerkey = "Content-Disposition";
    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
    response.setHeader(headerkey, headervalue);
    List< Student > listofStudents = studentService.getStudentList();
    PdfGenerator generator = new PdfGenerator();
    generator.generate(listofStudents, response);
    return "index";
  }
  
  @GetMapping("/b")
  public String help() {
	  System.out.println("controller");
	  return "index";
  }
}