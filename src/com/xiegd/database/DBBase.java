package com.xiegd.database;

import java.sql.ResultSet;

public abstract class DBBase {
	static String sqlPath = "";
	static String driverClass = "";
	
	abstract Boolean getConn();
	abstract ResultSet query( String order );
	abstract Boolean closeConn();
}
