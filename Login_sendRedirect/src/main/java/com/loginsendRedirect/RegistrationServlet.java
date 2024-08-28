package com.loginsendRedirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String dburl = "jdbc:mysql://localhost:3306/login";
		String dbuser = "root";
		String dbpass = ""; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);

			PreparedStatement stmt = con.prepareStatement("INSERT INTO registerdata (fname, lname, mobile, email, password) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, mobile);
			stmt.setString(4, email);
			stmt.setString(5, password);

			int result = stmt.executeUpdate();
			
			
			if (result > 0) {
				System.out.println("Registration successful.");
				response.sendRedirect("Login.html"); // Redirect to login page
			} else {
				PrintWriter out = response.getWriter();
				out.println("Registration failed!");
			}
			
			stmt.close();
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace(); // Print the stack trace to the console/logs
			response.getWriter().println("Error: " + e.getMessage());
		}
	}
}
