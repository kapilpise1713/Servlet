package com.LoginLogoutExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("info.html").include(request, response);
		
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		if(pass.equals("admin@123")) {
			out.println("<h2 align='center'>welcome"+user+"</h2>");
			
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
			
		}else {
			out.println("<h2 style= 'color:red'>BAD CREDENTIALS</h2><br>");
			request.getRequestDispatcher("login.html").include(request, response);
			
			
		}
		
		
	}

}
