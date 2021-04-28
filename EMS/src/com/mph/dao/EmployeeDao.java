package com.mph.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.mph.model.Employee;
import com.mph.util.MyDBConnection;

public class EmployeeDao {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	public void insertEmp(Employee emp) {
		con = MyDBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("insert into mphemp(eid,ename) values(?,?)");
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "   inserted successfully !!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewEmp() {
		con = MyDBConnection.getDBConnection();
		try {
			st = con.createStatement();

			rs = st.executeQuery("select * from mphemp");

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertUsingProcedure(Employee emp)
	{
		con = MyDBConnection.getDBConnection();
		try {
			CallableStatement cs = con.prepareCall("{call insertRecord(?,?)}");
			cs.setInt(1, emp.getEid());
			cs.setString(2, emp.getEname());
			cs.execute();
			System.out.println("Procedure Successfully Executed and record inserted");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
	
	public void rsmd()
	{
		con = MyDBConnection.getDBConnection();
		HashMap<Long, HashMap<String, Object>> hmap = new HashMap<Long, HashMap<String,Object>>();
		try {
			st = con.createStatement();
			rs =st.executeQuery("select * from mphemp");
			
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			while(rs.next())
			{
				HashMap<String, Object> row = new HashMap<String, Object>();
				for(int i=1 ; i<md.getColumnCount();i++)
				{
					row.put(md.getColumnName(i), rs.getObject(i));
					hmap.put(rs.getLong("eid"), row);
					
				}
			}
			System.out.println(hmap);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void type_forward_only_rs() {
	}
	{
		con = MyDBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("select * from mphemp",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			System.out.println(rs.getType());
		}catch (SQLException e) {
			e.printStackTrace();
		}
			}
	public void type_scroll_insensitive_rs()
	{
		con = MyDBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("select * from mphemp",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				
				System.out.println(rs.getString(2));
			}
			
			System.out.println("Move Cursor to Ist position");
			rs.first();
			System.out.println(rs.getString("enam"));
			
			System.out.println("Move Cursor to Last position");
			rs.last();
			System.out.println(rs.getString("enam"));
			
			System.out.println("Move Cursor to previous position");
			rs.previous();
			System.out.println(rs.getString("enam"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void type_scroll_sensitive_rs_insert() {
		con = MyDBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("select eid,enam from mphemp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			System.out.println("Before Insert ==>");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			rs.moveToInsertRow();
			rs.updateInt("eid",11);
			rs.updateString("enam", "Ram");
			rs.insertRow();
			
			System.out.println("Inserted ...");
			System.out.println("After Insert ==>");
			System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("enam"));
			
			System.out.println(rs.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void type_scroll_sensitive_rs_update() {
		con = MyDBConnection.getDBConnection();
		try {
			ps = con.prepareStatement("select eid,enam from mphemp where eid=22", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

			System.out.println("Before Update ==>");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				rs.updateInt("eid", 10);
				rs.updateString("enam", "Sahil");
				rs.updateRow();
			}

			System.out.println("Updated ...");
			

			System.out.println(rs.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void batchUpdate()
	{
		con = MyDBConnection.getDBConnection();
		
		try {
			st = con.createStatement();
			st.addBatch("update mphemp set enam ='Mohann' where eid=77");
			st.addBatch("update mphemp set eid=1 where enam ='kkk'");
			st.addBatch("update mphemp set enam ='Varunaa' where eid=88");
			st.addBatch("update mphemp set enam ='Sarikaa' where eid=44");
			st.addBatch("update mphemp set enam ='Rajaa' where eid=33");
			
			int[] count =st.executeBatch();
			for(int i=0;i<count.length ;i++)
			{
				System.out.println(i + "  "+ count [i] + " times. ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
}
	
	
	
	
	
	
	
	

	
	
						
		

	
