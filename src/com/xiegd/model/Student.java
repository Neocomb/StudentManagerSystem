package com.xiegd.model;

public class Student extends Person{
	private String className = "";
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student( String name , int age , Sex sex  , String className ) {
		// TODO Auto-generated constructor stub
		super(name, age, sex);
		this.className  = className;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Student [ id = " + ID + ", name=" + name + ", sex="
				+ sex + ", age=" + age + ", className=" + className + "]\n";
	}
	
	
}
