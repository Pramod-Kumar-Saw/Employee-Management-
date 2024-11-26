package com.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Employee;

public class EmployeeService {
 	private static String url = "jdbc:mysql://localhost:3306/server_1";
	private static String user = "root";
	private static String password = "root";
	
	public static Connection con = null;
	public static int no = 0;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public int saveemp(Employee e1) {
		String query = "insert into employee values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, e1.getId());
			pstm.setString(2, e1.getName());
			pstm.setInt(3, e1.getAge());
			pstm.setString(4, e1.getEmail());
			pstm.setDouble(5, e1.getSal());
			no = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no;
	}
	
	public List<Employee> getAll()
	{
		List <Employee> l1 = new ArrayList<Employee>();
		
		String sql = "SELECT * from employee";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String email = rs.getString(4);
				double salary = rs.getDouble(5);
				
				l1.add(new Employee(id,name,age,email,salary));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l1;
	}
	
	
	public  int update(Employee e1)
	{
		int no2=0;
		String sql1 = "update employee set name = ?, age=?, email=?, sal=? where id=?" ;
		try {
			PreparedStatement pstm = con.prepareStatement(sql1);
			pstm.setString(1, e1.getName());
			pstm.setInt(2, e1.getAge());
			pstm.setString(3, e1.getEmail());
			pstm.setDouble(4, e1.getSal());
			pstm.setInt(5, e1.getId());
			
			no2 = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no2;
	}
	
	public  int delete(int id)
	{
		int no3 = 0;
		String sql2 = "delete from employee where id = ?" ;
		try {
			PreparedStatement pstm = con.prepareStatement(sql2);
			pstm.setInt(1, id);
			
			no3 = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no3;
	}
}
