package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.Addconnection;
import com.dal.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	@Override
	public void insertEmployee(Employee emp) {
		try {
			con = Addconnection.getDbConnection();
			ps = con.prepareStatement("insert into dalemp values(?,?)");

			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void showEmployee() {
		try {
			con = Addconnection.getDbConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from dalemp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
// April 12th task
	@Override
	public void updateEmployee(Employee emp) {

		try {
			con = Addconnection.getDbConnection();
			ps = con.prepareStatement("update dalemp set EMPNAME = ? where EMPID =?");
			ps.setInt(2, emp.getEid());
			ps.setString(1, emp.getEname());
			int i = ps.executeUpdate();
			System.out.println(i+"row update");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int eid) {
		
          
          try {
        	  con = Addconnection.getDbConnection();
			  stmt = con.createStatement();
			  stmt.executeUpdate( "DELETE FROM dalemp " +
			            "WHERE EMPID ='"+eid+"'");
			  System.out.println("1 row deleted!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
             
	}
	
	// end of April 12 th task

}
