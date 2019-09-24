package com.ustglobal.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getEmp") 
public class GetEmployeeServlet  extends HttpServlet{

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 // herer we are making request so using req obj
		 
		String empidVal =  req.getParameter("empid");// here we have set key for querystring and it can be done using setparameter
		int empId = Integer.parseInt(empidVal);// convert string into integer
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		
		if (empId == 101) {
			out.println("<h2> Employee details for empid "+empId+"</h2>");
			out.println("id = 101<br/>");
			out.println("Name = Nikhil<br/>");
			out.println("age = 21<br/>");
			out.println("phonenumber = 8369926981<br/>");
			out.println("salary= 26000<br/>");
		}else {
			out.println("<h2 style=\"color:red\"> Record not found  for empid "+empId+"</h2>");
			
		}
		out.println("</body>");
		out.println("</html>");
		
		
	}// end of doget
}// end of class
