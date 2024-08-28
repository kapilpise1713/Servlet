package com.sessionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		
		String username = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
		
		PrintWriter out = response.getWriter();
	    out.println("<h2> Welcome : "+username+"</h2>");
	    out.println("<h2> Your Email is : "+password+"</h2>");
	}

}
