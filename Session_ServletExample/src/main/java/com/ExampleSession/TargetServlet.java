package com.ExampleSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Welcome Mr./Mrs./Miss :"+username+"</h2>");
		
		out.println("<br><hr><br>");
		out.println("KYA AAP AAPKA BHOOTKAL JANNA CHAHATE HOO!! <br><br>");
		out.println("<a href='rajya'><button type='submit'>RAJ MAHAL</button></a>");
	}

}

//any attribute always returns object so thats why we need to typecast it.