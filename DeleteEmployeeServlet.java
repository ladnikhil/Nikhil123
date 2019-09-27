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

@WebServlet("/deleteEmp")
public class DeleteEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		// validation of session

		HttpSession session = req.getSession(false);

		if(session != null) {

			String empid = req.getParameter("id");
			int empid1 = Integer.parseInt(empid);


			EmployeedaoJpaImp ed = new EmployeedaoJpaImp();

			boolean condition = ed.DeleteEmployee(empid1);

			PrintWriter out = resp.getWriter();

			out.println("<html>");
			out.println("<body>");

			if(condition) {
				out.println("<h2>Employee Deleted</h2>");
			}else {
				out.println("<h2>not added Successfull</h2>");
			}
			out.println("</body>");
			out.println("</html>");
		}else {
			resp.sendRedirect("./loginform.html");
		}

	}
	}




