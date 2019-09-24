package com.ustglobal.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ustglobal.dao.EmployeeDao;
import com.ustglobal.dao.EmployeedaoJpaImp;
import com.ustglobal.mywebapp.dto.EmployeeInfoBean;

@WebServlet("/searchEmp")
public class SearchEmployeeServlet extends HttpServlet {
	
	private EmployeeDao dao = new  EmployeedaoJpaImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the form data
		
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);
		
		EmployeeInfoBean employeeinfobean = dao.searchEmployee(empId);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(employeeinfobean != null) {
			out.println("<h3>employee data for employeeid "+empId+ "</h3>");
			out.println("employeeid "+empId);
			out.println("</br> employaname "+employeeinfobean.getEmpName());
			out.println("</br>employeeage  "+employeeinfobean.getAge());
			out.println("</br>employeesalary"+employeeinfobean.getSalary());
			out.println("</br>employeedesignation "+employeeinfobean.getDesignation());
			}else {
				out.println("<h3> employee id not found "+empId+"</h3>");
			}
		
		out.println("</html>");
		out.println("</body>");
		
	}// end of get method
}// end of class
