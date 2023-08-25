package com.pack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;


@WebServlet("/SerSer")
public class SerSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	Functional fun;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s=request.getParameter("par1");
		fun = new Functional();
		try {
			fun.conn();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		try {
			JSONArray data = fun.meth5(s);
			response.getWriter().println(data.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
