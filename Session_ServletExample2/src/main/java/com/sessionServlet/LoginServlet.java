package com.sessionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(username.equals("Kapil") && password.equals("kp@gmail.com")) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			response.sendRedirect("welcome");
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<h2 style= 'color:red'>Incorrect credentials try Again!!</h2>");
			
			rd.include(request, response);
		}
		
	}

}
