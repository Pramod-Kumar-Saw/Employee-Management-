package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.Service.EmployeeService;
@WebServlet("/dis")
public class display extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		
		List<Employee> e1 = service.getAll();
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "  <title>Animated Display Table</title>\r\n"
				+ "  <style>\r\n"
				+ "    /* Reset and Styling */\r\n"
				+ "    body {\r\n"
				+ "      margin: 0;\r\n"
				+ "      font-family: Arial, sans-serif;\r\n"
				+ "      display: flex;\r\n"
				+ "      justify-content: center;\r\n"
				+ "      align-items: center;\r\n"
				+ "      height: 100vh;\r\n"
				+ "      background: linear-gradient(270deg, #ff9a9e, #fad0c4, #a1c4fd, #c2e9fb, #c2e59c, #ff758c);\r\n"
				+ "      background-size: 600% 600%;\r\n"
				+ "      animation: backgroundAnimation 10s ease infinite;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .container {\r\n"
				+ "      background-color: rgba(255, 255, 255, 0.9);\r\n"
				+ "      border-radius: 10px;\r\n"
				+ "      padding: 20px;\r\n"
				+ "      width: 80%;\r\n"
				+ "      max-width: 800px;\r\n"
				+ "      box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);\r\n"
				+ "      animation: fadeIn 1s ease;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    h1 {\r\n"
				+ "      text-align: center;\r\n"
				+ "      color: #333;\r\n"
				+ "      font-size: 24px;\r\n"
				+ "      margin-bottom: 20px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    table {\r\n"
				+ "      width: 100%;\r\n"
				+ "      border-collapse: collapse;\r\n"
				+ "      margin: 0 auto;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    th, td {\r\n"
				+ "      border: 1px solid #ddd;\r\n"
				+ "      padding: 12px;\r\n"
				+ "      text-align: center;\r\n"
				+ "      font-size: 16px;\r\n"
				+ "      transition: background-color 0.3s ease, transform 0.2s ease;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    th {\r\n"
				+ "      background-color: #4caf50;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    tr:nth-child(even) {\r\n"
				+ "      background-color: #f9f9f9;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    tr:hover {\r\n"
				+ "      background-color: #f1f1f1;\r\n"
				+ "      transform: scale(1.01);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .action-buttons {\r\n"
				+ "      display: flex;\r\n"
				+ "      justify-content: center;\r\n"
				+ "      gap: 10px;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .btn {\r\n"
				+ "      padding: 8px 12px;\r\n"
				+ "      border: none;\r\n"
				+ "      border-radius: 5px;\r\n"
				+ "      font-size: 14px;\r\n"
				+ "      cursor: pointer;\r\n"
				+ "      transition: transform 0.2s, background-color 0.3s ease;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .btn.update {\r\n"
				+ "      background-color: #007bff;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .btn.update:hover {\r\n"
				+ "      background-color: #0056b3;\r\n"
				+ "      transform: translateY(-2px);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .btn.delete {\r\n"
				+ "      background-color: #ff4d4d;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .btn.delete:hover {\r\n"
				+ "      background-color: #e60000;\r\n"
				+ "      transform: translateY(-2px);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    /* Animations */\r\n"
				+ "    @keyframes backgroundAnimation {\r\n"
				+ "      0% { background-position: 0% 50%; }\r\n"
				+ "      50% { background-position: 100% 50%; }\r\n"
				+ "      100% { background-position: 0% 50%; }\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    @keyframes fadeIn {\r\n"
				+ "      from {\r\n"
				+ "        opacity: 0;\r\n"
				+ "        transform: translateY(20px);\r\n"
				+ "      }\r\n"
				+ "      to {\r\n"
				+ "        opacity: 1;\r\n"
				+ "        transform: translateY(0);\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  <div class=\"container\">\r\n"
				+ "    <h1>Employee Records</h1>\r\n"
				+ "    <table>\r\n"
				+ "      <thead>\r\n"
				+ "        <tr>\r\n"
				+ "          <th>ID</th>\r\n"
				+ "          <th>Name</th>\r\n"
				+ "          <th>Age</th>\r\n"
				+ "          <th>Email</th>\r\n"
				+ "          <th>Salary</th>\r\n"
				+ "          <th>Actions</th>\r\n"
				+ "        </tr>\r\n"
				+ "      </thead>");
		for(Employee employee : e1) {
			int id = employee.getId();
			String name = employee.getName();
			int age = employee.getAge();
			String email = employee.getEmail();
			double salary = employee.getSal();
			
		out.print("<tr>\r\n"
				+ "                <td> "+id+" </td>\r\n"
				+ "                <td> "+name+" </td>\r\n"
				+ "                <td> "+age+ "</td>\r\n"
				+ "                <td> "+email+" </td>\r\n"
				+ "                <td> "+salary+" </td>\r\n"
				+ "                <td>\r\n"
				+ "                        <a href=\"Update.html\"><button class=\"btn update\">Update</button></a>\r\n"
				+ "            <a href=\"Delete.html\"><button class=\"btn delete\">Delete</button></a>"
				+ "                    </td>"
				+ "            </tr>");
		}
				out.print(
				 "    </table>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		
		
		
		
		
		
		
	
	}

}
