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
@WebServlet("/submit")
public class Saveemp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String salary = req.getParameter("salary");
		
		int ids=Integer.parseInt(id);
		int ages=Integer.parseInt(age);
		int sal=Integer.parseInt(salary);
		
		Employee e1 = new Employee (ids, name, ages, email, sal);
		
		EmployeeService service = new EmployeeService();
		
		int no = service.saveemp(e1);
		if(no!=0) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Welcome2.html");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter print = resp.getWriter();
			print.write("<h1>Data not saved</h1>");
		}
	}
}
