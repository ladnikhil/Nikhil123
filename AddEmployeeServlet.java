package com.ustglobal.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ustglobal.dao.EmployeeDao;
import com.ustglobal.dao.EmployeedaoJpaImp;
import com.ustglobal.mywebapp.dto.EmployeeInfoBean;

@WebServlet("/addEmp")
public class AddEmployeeServlet extends HttpServlet {

	EmployeeDao dao = new EmployeedaoJpaImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// validation of session

		HttpSession session = req.getSession(false);

		if(session != null) {




			String empIdVal = req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);

			String empnameVal = req.getParameter("empname");


			String empageVal = req.getParameter("age");
			int empage = Integer.parseInt(empageVal);


			String empsalaryVal = req.getParameter("salary");
			double empsalary = Integer.parseInt(empsalaryVal);

			String empdesignationVal = req.getParameter("designation");
			
			String password= req.getParameter("password");

			boolean condition = dao.addEmployee(empId, empnameVal, empage, empsalary, empdesignationVal,password);

			PrintWriter out = resp.getWriter();

			out.println("<html>");
			out.println("<body>");

			if(condition) {
				out.println("<h2>Added Successfull</h2>");
			}else {
				out.println("<h2>not added Successfull</h2>");
			}

			out.println("</html>");
			out.println("</body>");
		}else {
			resp.sendRedirect("./loginform.html");
		}
		}
	}
