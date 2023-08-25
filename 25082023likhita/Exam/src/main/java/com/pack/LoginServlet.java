package com.pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String us=request.getParameter("nam");
		String pw=request.getParameter("psw");
		Connection con = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("class");
		try {
			 con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
					"pff123");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("Select password from employee_pass where ename=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(1,us );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pass = null;
		try {
			if(rs.next()) {
				pass=rs.getString("password");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection");
		if(pw.equals(pass)) {
			String key="cccccc"+us+pw;
			System.out.println(key);
			
			HttpSession ses=request.getSession();
			ses.setAttribute("keyses", key);
					
			response.setHeader("keyyy", key);
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("MainPage.html");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.html");
			rd.forward(request, response);
			
		}
		
		
	}

	
	
}
