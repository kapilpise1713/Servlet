package com.genericServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


public class Prime extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num1"));
		
		boolean flag = true;
		
		for(int i=2;i<=num/2;i++) {
			if(num%2 == 0) {
				flag = false;
			}
		}
		PrintWriter out = response.getWriter();
		
		if(flag) {
			out.println(num+"is a Prime");
			
		}else {
			out.println("Not Prime");
		}
		
	}

}
