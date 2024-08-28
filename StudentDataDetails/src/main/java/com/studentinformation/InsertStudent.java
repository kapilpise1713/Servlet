package com.studentinformation;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Connection con;
    public void init(ServletConfig config) throws ServletException{
    	
    	
    	//SERVLET CONFIG
    	String url = config.getInitParameter("dburl");
     	String username =  config.getInitParameter("dbdbuser");
		String password =  config.getInitParameter("dbpass");
		
		/*
		 * //SERVLET CONTEXT 
		 * ServletContext context = config.getServletContext(); 
		 * String url = context.getInitParameter("dburl"); 
		 * String username = context.getInitParameter("dbdbuser"); 
		   String password = context.getInitParameter("dbpass");
		 */
		
		
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		try {
			 con = DriverManager.getConnection(url,username,password);
		}catch(SQLException e){
			e.printStackTrace();
			
		}
			
		
		
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
	   try {
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate("Insert into student_info values ('"+fname+"','"+lname+"','"+email+"','"+pass+"')");
		System.out.println(result+"Student data Inserted");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		if(result>0) {
			pw.print("<h2 style = 'color : green'>Student Inserted</h2>");
		}else {
			pw.print("<h2 style = 'color : red'>Error Occured</h2>");
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
		
	}
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
