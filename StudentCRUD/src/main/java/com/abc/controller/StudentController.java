 package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dto.Student;
import com.abc.factory.StudentServiceFactory;
import com.abc.service.StudentService;


public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		
		String action = request.getParameter("action");
//Module for Addiding the record
		if (action.equalsIgnoreCase("ADD")) {
	//Take the data from client
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");
	//Create a Student object use DTO Pattern to Transfer Data
			Student student = new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSage(sage);
			student.setSaddress(saddress);
			StudentService studentService = StudentServiceFactory.getStudentService();
			String status = studentService.save(student);
			RequestDispatcher requestDispatcher = null;
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);

			}
			if (status.equals("already Existed")) {
				requestDispatcher = request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);

			} 
		}
//Module Action for Read	
		if(action.equalsIgnoreCase("READ")) {
//Collect sid from client
			String sid = request.getParameter("sid");	
			StudentService studentService = StudentServiceFactory.getStudentService();
			Student student = studentService.findById(sid);
			
			RequestDispatcher requestDispatcher=null;
			
			if(student==null) {
			 requestDispatcher= request.getRequestDispatcher("notexisted.html");
			 requestDispatcher.forward(request, response);
			}else {
				request.setAttribute("student", student);
				 requestDispatcher= request.getRequestDispatcher("displayRecord.jsp");
				 requestDispatcher.forward(request, response);
			}
		}
	// Module for Delete the Record
		
		if(action.equalsIgnoreCase("delete")) {
	//Collect sid from client
			String sid = request.getParameter("sid");
			StudentService studentService = StudentServiceFactory.getStudentService();
			String status = studentService.deleteById(sid);
			
			RequestDispatcher requestDispatcher=null;
           if(status.equals("success")) {
			 requestDispatcher = request.getRequestDispatcher("success.html");
			 requestDispatcher.forward(request, response);
			}
			if(status.equals("notexisted")) {
			 requestDispatcher = request.getRequestDispatcher("notexisted.html");
			 requestDispatcher.forward(request, response);
			}
			if(status.equals("failure")) {
			 requestDispatcher = request.getRequestDispatcher("failure.html");	
			 requestDispatcher.forward(request, response);
			}
		}
		
	    //Module Action for Read	
				if(action.equalsIgnoreCase("update")) {
	     //Collect sid from client
					String sid = request.getParameter("sid");
					
					StudentService studentService = StudentServiceFactory.getStudentService();
					Student student = studentService.findById(sid);
					RequestDispatcher requestDispatcher=null;
					
					if(student==null) {
					 requestDispatcher= request.getRequestDispatcher("notexisted.html");
					 requestDispatcher.forward(request, response);
					}else {
					request.setAttribute("Student", student);
				    requestDispatcher= request.getRequestDispatcher("editRecord.jsp");
				    requestDispatcher.forward(request, response);
					}		
				}
		if(action.equals("edit")) {				
			// Took the data from the client
						String sid = request.getParameter("sid");
						String sname = request.getParameter("sname");
						String sage = request.getParameter("sage");
						String saddress = request.getParameter("saddress");

						// Create a student object use DTO pattern to transfer the data
						Student student = new Student();
						student.setSid(sid);
						student.setSname(sname);
						student.setSage(sage);
						student.setSaddress(saddress);

						// Use Factory Design pattern to the StudentService object
						StudentService studentService = StudentServiceFactory.getStudentService();
				    	 String status = studentService.update(student);

						// Based on status process the information to the client
						RequestDispatcher requestDispatcher = null;
						if (status.equals("success")) {
							requestDispatcher = request.getRequestDispatcher("success.html");
							requestDispatcher.forward(request, response);
						}
						if (status.equals("failure")) {
							requestDispatcher = request.getRequestDispatcher("failure.html");
							requestDispatcher.forward(request, response);
						}

		}
	}

}
