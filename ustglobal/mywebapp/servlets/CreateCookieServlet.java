package com.ustglobal.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	
	// for creation of cookie
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("name","nikhil");
		resp.addCookie(cookie);// to add a cookie
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<h2>cookie created succeessfully</h2>");
	}
	

}
