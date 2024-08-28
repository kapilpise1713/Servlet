package com.logininfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		String dburl = "jdbc:mysql://localhost:3306/login";
     	String dbuser = "root";
		String dbpass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,dbuser,dbpass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from logincred where email = '"+email+"' and password = '"+password+"'");
			
			RequestDispatcher rd = request.getRequestDispatcher("home");
			
			if(rs.next()) {
				request.setAttribute("message", "Welcome :"+rs.getString(1));
				rd.forward(request, response); 
				
			}else {
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("login.html");
				
				PrintWriter out = response.getWriter();
				out.println("<h2 style= 'color:red'>Incorrect credentials try Again!!</h2>");
				
				rd.include(request, response);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		try {}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
