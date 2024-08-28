package com.genericServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


public class Addition extends GenericServlet {
	
    
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int sum = num1+num2;
		
		PrintWriter out = response.getWriter();
		out.println("The Addition is :"+sum);
		
	}

}
