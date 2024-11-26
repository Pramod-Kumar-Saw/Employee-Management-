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
@WebServlet("/delete")
public class Delete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		int ids=Integer.parseInt(id);
	
		EmployeeService emp1=new EmployeeService();
		
		int n =emp1.delete(ids);
		
		if(n>0)
		{
			RequestDispatcher rd = req.getRequestDispatcher("Welcome2.html");
			rd.forward(req, resp);
		}
		else {
			PrintWriter out = resp.getWriter();
			
			RequestDispatcher rd = req.getRequestDispatcher("Delete.html");
			rd.include(req, resp);
			out.print("<h2> Invalid Id <br> Invalid Id <br> Invalid Id</h2> ");
		}
	}

}
