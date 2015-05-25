package com.xiegd.model;

public class Person {
	
	protected int age;
	protected String ID ;
	protected String name;
	protected Sex sex;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person( String name , int age , Sex sex) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public Sex getSex() {
		return sex;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [ id = " + ID + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	

}



