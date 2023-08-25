package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Functional {
	Connection con;
	ResultSet rs;
	public void conn() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin", "pff123");
		System.out.println("connection established");
	}
	public JSONArray meth() throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from Likhita_Product");
		rs=ps.executeQuery();
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			try {
				
				
				jo.put("id",rs.getInt("product_id") );
				jo.put("name",rs.getString("product_name") );
				jo.put("cat",rs.getString("category") );
				jo.put("price",rs.getDouble("price") );
				jo.put("mdate",rs.getDate("manufacturing_date") );
				jo.put("qua",rs.getInt("stock_quantity") );
				jo.put("iavl",rs.getString("is_available") );
				ja.put(jo);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ja);
		return ja;
	}
	public JSONArray meth2(int id,String name,String cat,Double price,Date date,int qua,String isa) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into Likhita_Product values(?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, cat);
		ps.setDouble(4, price);
		ps.setDate(5, (java.sql.Date) date); 
		ps.setInt(6, qua);
		ps.setString(7, isa);
		
		
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
	}
	public JSONArray meth3(String name,String cat,Double price,Date date,int qua,String isa,int id) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update Likhita_Product set ename=?,job=?,dept=?,sal=? where empno=?");
		
		ps.setString(1, name);
		ps.setString(2, cat);
		ps.setDouble(3, price);
		ps.setDate(4, (java.sql.Date) date); 
		ps.setInt(5, qua);
		ps.setString(6, isa);
		ps.setInt(7, id);
		
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
	}
	public JSONArray meth4(int id) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete  from Likhita_Product where product_id=? ");
		ps.setInt(1, id);
		ps.executeUpdate();
		
		JSONArray re=meth();
		return re;
		
	}
	public JSONArray meth5(String s) throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from Likhita_Product order by ?");
		ps.setString(1, s);
		rs=ps.executeQuery();
		JSONArray ja=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			try {
				
				
				jo.put("id",rs.getInt("product_id") );
				jo.put("name",rs.getString("product_name") );
				jo.put("cat",rs.getString("category") );
				jo.put("price",rs.getDouble("price") );
				jo.put("mdate",rs.getDate("manufacturing_date") );
				jo.put("qua",rs.getInt("stock_quantity") );
				jo.put("iavl",rs.getString("is_available") );
				ja.put(jo);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ja);
		return ja;
		
		
	}

}

