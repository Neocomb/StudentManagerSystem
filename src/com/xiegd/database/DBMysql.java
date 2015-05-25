package com.xiegd.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMysql extends DBBase {
	Connection conn;
	Statement stat;
	
	public DBMysql() {
		// TODO Auto-generated constructor stub
		driverClass = "com.mysql.jdbc.Driver";
		sqlPath  = "jdbc:mysql://localhost/StuMgrSystem?user=root&password=0426";
	}
	
	@Override
	Boolean getConn() {
		// TODO Auto-generated method stub
		if ( conn != null ) {
			return true;
		}
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(sqlPath);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			stat =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	ResultSet query(String order) {
		// TODO Auto-generated method stub
		if ( conn == null || stat == null ) {
			return null;
		}
		ResultSet ret = null;
		try {
			ret = stat.executeQuery(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	Boolean closeConn() {
		// TODO Auto-generated method stub
		try {
			stat.close();
			conn.close();
		} catch (final Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
