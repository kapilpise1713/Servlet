package com.genericServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//GenericServlet

public class Cyber extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cyber</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Cyber Is Live</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
