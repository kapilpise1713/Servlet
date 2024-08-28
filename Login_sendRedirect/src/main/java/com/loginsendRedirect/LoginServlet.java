package com.loginsendRedirect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String dburl = "jdbc:mysql://localhost:3306/login";
		String dbuser = "root";
		String dbpass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM registerdata WHERE email = ? AND password = ?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String fname = rs.getString("fname");
				response.sendRedirect("welcome?user=" + fname);
			} else {
				response.getWriter().println("Invalid credentials! Please try again.");
				response.sendRedirect("Login.html"); // Redirect back to login page
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("An error occurred: " + e.getMessage());
		}
	}
}
