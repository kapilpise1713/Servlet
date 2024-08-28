package com.genericServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


public class UsernamePasswordCheck extends GenericServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.isEmpty() && password.isEmpty()) {
            out.println("Please enter username and password");
        } else if ("Admin".equals(username) && "Admin".equals(password)) {
            out.println("Admin");
        } else if (!username.isEmpty() && password.isEmpty()) {
            out.println("Hello " + username);
        } else {
            out.println("Invalid credentials");
        }
		
		}

}
