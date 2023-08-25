package com.pack;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;


@WebServlet("/Seredit")
public class Seredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  Functional fun;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fun = new Functional();
		try {
			fun.conn();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int v1=Integer.parseInt(request.getParameter("par1"));
		String v2=request.getParameter("par2");
		String v3=request.getParameter("par3");
		double v4=Double.parseDouble(request.getParameter("par4"));
		 String dateParameter = request.getParameter("par5"); // Replace with your parameter name
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date v5 = null;
			try {
				v5 = dateFormat.parse(dateParameter);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    int v6=Integer.parseInt(request.getParameter("par6"));
		    String v7=request.getParameter("par7");
		    
		    
		    
		try {
			JSONArray var1=fun.meth3( v2, v3, v4, v5,v6,v7,v1);
			System.out.println(var1);
			response.getWriter().write(var1.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	
}
