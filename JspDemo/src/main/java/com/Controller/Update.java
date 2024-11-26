package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmployeeService;
@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String salary = req.getParameter("salary");
		
		int ids=Integer.parseInt(id);
		int ages=Integer.parseInt(age);
		Double sal=Double.parseDouble(salary);
		
		Employee e1 = new Employee (ids, name, ages, email, sal);
		EmployeeService emp=new EmployeeService();
		
		int n =emp.update(e1);
		
		if(n>0)
		{
			RequestDispatcher rd = req.getRequestDispatcher("Welcome2.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter();
			
			RequestDispatcher rd = req.getRequestDispatcher("Update.html");
			rd.include(req, resp);
			out.print("<h2> Invalid Id <br> Invalid Id <br> Invalid Id</h2> ");
			
		}
	}

}
