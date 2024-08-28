package com.loginsendRedirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Servlet</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h2>Welcome to The World of Servlets..!</h2>");
//		out.println("</body>");
//		out.println("</html>");
		
		String user = request.getParameter("user");
		if (user != null) {
			response.getWriter().println("Welcome, " + user + "!");
		} else {
			response.sendRedirect("login.html"); // Redirect to login if no user is provided
		}
	}

}
