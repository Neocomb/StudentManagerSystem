package com.xiegd.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.xiegd.exception.WrongParamCheckException;
import com.xiegd.model.CheckField;
import com.xiegd.model.Person;
import com.xiegd.model.Sex;
import com.xiegd.model.Student;


public class DBBridge implements SqlOperation{
	DBBase db;
	private String DBTable = "";
	public String getDBTable() {
		return DBTable;
	}
	public void setDBTable(String dBTable) {
		DBTable = dBTable;
	}
	public DBBridge( DBBase db ) {
		// TODO Auto-generated constructor stub
		this.db = db;
		db.getConn();
	}
	public Vector<Person> getall() {
		// TODO Auto-generated method stub
		Vector<Person> allPersons = new Vector<Person>();
		
		String order = "select * from " + DBTable + ";";
		ResultSet rst = db.query(order);
		covertToPerson(rst, allPersons);
		return allPersons;
	}
	public boolean add( Person p ) {

		String order = "select * from " + DBTable + ";";
		ResultSet rst = db.query(order);
		try {
	
				rst.moveToInsertRow();
				rst.updateString("name", p.getName());
				rst.updateString("sex", p.getSex().toString());
				rst.updateInt("age", p.getAge());
				rst.updateString("classname", ((Student)p).getClassName() );
				rst.insertRow();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean delete( int ID ) {
		boolean ret = false;
		String order = " select * from " + DBTable + " where id="  
						+ ID + ";"; 
		ResultSet rst = db.query(order);
		try {
			if ( rst.next() ) {
				rst.deleteRow();
				ret = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public Vector<Person> check( Vector<CheckField> ck , Vector<String> key ) throws WrongParamCheckException {
		Vector<Person> allPersons = new Vector<Person>();
		if ( ck.size() != key.size() ) { 
			throw new WrongParamCheckException();
		}
		String order = " select * from " + DBTable + " where ";
		for ( int i = 0 ; i < key.size() ; i++ ) {
			order += ck.elementAt(i).getField() + " = '" + key.elementAt(i).toString() + "'";
			if ( i != key.size() - 1) {
				order += "and";
			}
		}
		order+=";";

		ResultSet rst = db.query(order);
		covertToPerson(rst, allPersons);
		return allPersons;
	}
	public boolean modify( int ID  , Person newp){
		String order = "select * from " + DBTable + " where id = " + ID + ";";
		ResultSet rst = db.query(order);
		boolean ret = false;
		try {
			if ( rst.next() ) {
				if( newp.getName() != null ) rst.updateString("name", newp.getName() );
				if( newp.getAge() != 0 ) rst.updateInt("age", newp.getAge() );
				if( newp.getSex() != null ) rst.updateString("sex", newp.getSex().toString() );
				if( ((Student)newp).getClassName() != null ) rst.updateString("classname", ((Student)newp).getClassName() );
				
				rst.updateRow();
				ret = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return ret;
	}
	private void covertToPerson( ResultSet rst , Vector<Person> allPersons ) {
		try {
			while ( rst.next() ) {
				Student stu = new Student( rst.getString("name"),
						rst.getInt("age"),  
						rst.getString("sex").equals("male")?Sex.MALE:Sex.FAMALE ,
						rst.getString("classname") );
				stu.setID( String.valueOf(rst.getInt("id")) );
				allPersons.add( stu );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
