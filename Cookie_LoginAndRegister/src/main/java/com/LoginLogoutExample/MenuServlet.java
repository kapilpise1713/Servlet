package com.LoginLogoutExample;

import java.io.IOException;
import java.io.PrintWriter;import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("info.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			String user = (String)session.getAttribute("username");
			out.println("<h5 style='float:right'>"+user+"</h5>");
			out.println("<p>Kya khana pasand karenge aap??</p>");
			out.println("<div>");
			out.println("<ol>");
			out.println("<li>VadaPav</li>");
			out.println("<li>Samosa</li>");
			out.println("<li>Dosa</li>");
			out.println("<li>Panipuri</li>");
			out.println("<li>Biryani</li>");
			out.println("</ol>");
			out.println("</div>");
		}else {
			out.println("<h2 style='color:red'>Please Logn First..</h2>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

}
