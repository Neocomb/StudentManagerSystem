package com.xiegd.model;
import com.xiegd.exception.UnknowSexException;

public enum Sex {
	MALE("male") ,
	FAMALE("famale") ;
	
	private String sex;
	
	private Sex( String str ) {
		// TODO Auto-generated constructor stub
		switch (str) {
		case "male":
		case "famale":
			sex = str;
			break;

		default:
			break;
		}
	}
	
	public String toString() {
		return sex;
	}
}
