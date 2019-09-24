package com.ustglobal.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// to read a cookie
		Cookie[] cookies = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		out.println("<head>");
		out.println("<body>");
		
		if(cookies != null) {
		for(Cookie cookie: cookies) {
			out.println("<h3>cookie name is : "+cookie.getName()+"</h3>");
			out.println("<h3>cookie value is : "+cookie.getValue()+"</h3>");
			
		}// end of for loop
		}else {
			out.println("<h3>cookie not present</h3>");
		}
			
		
		
		
		
		out.println("</body>");
		out.println("</head>");
		
	}
}
