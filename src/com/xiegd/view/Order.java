package com.xiegd.view;


import java.util.Vector;

import com.xiegd.database.DBBridge;
import com.xiegd.exception.WrongParamCheckException;
import com.xiegd.model.CheckField;
import com.xiegd.model.Sex;
import com.xiegd.model.Student;
import com.xiegd.model.Person;

public class Order {
	DBBridge bridge = null;
	
	public void menu(){
		System.out.println("usage :");
		System.out.println("show 显示所有学生");
		System.out.println("add 添加学生");
		System.out.println("delete 删除学生");
		System.out.println("find 查找学生 ");
		System.out.println("chg 修改学生信息");
		System.out.println("命令 -h 获取帮助");
		System.out.println("==============");
	}
	
	public DBBridge getBridge() {
		return bridge;
	}

	public void setBridge(DBBridge bridge) {
		this.bridge = bridge;
	}

	public void parseOrder( String order ) throws WrongParamCheckException{
		String[] words = order.split(" ");
		
		switch ( words[0].trim().toLowerCase() ) {
		case "show":	
			System.out.println(bridge.getall());;
			break;
		case "add":	
			add(words);
			break;
		case "del":	
			delete(words);
			break;
		case "find":			
			find(words);
			break;
		case "chg":	
			change(words);
			break;
		case "exit":
				System.exit(0);

		default:
			menu();
			break;
		}
	}
	
	public Boolean add( String[] args ) throws WrongParamCheckException{
		int index = 1;
		Student stu = new Student();
		while ( index < args.length - 1) {
			switch ( args[index++].trim().toLowerCase() ) {
			case "-n"://name
				stu.setName(args[index++]);
				break;
			case "-s"://sex
				stu.setSex(args[index++].equals("male") ? Sex.MALE : Sex.FAMALE);
				break;
			case "-a"://age
				stu.setAge(Integer.parseInt(args[index++]));
				break;
			case "-c"://className
				stu.setClassName(args[index++]);
				break;
			default:
				System.out.println("-n :set name");
				System.out.println("-s :set sex");
				System.out.println("-a :set age");
				System.out.println("-c :set className");
				break;
			}
		}
		
		if ( stu.getName() != null && stu.getClassName() != null && stu.getSex() != null ) {
			bridge.add(stu);		
			System.out.println("学生已添加成功");
		}else {
			System.out.println("sytax error!");
			System.out.println("-n :set name");
			System.out.println("-s :set sex");
			System.out.println("-a :set age");
			System.out.println("-c :set className");
		}
		
		return null;
	}
	
	public void delete( String[] args ){
		int index = 1;
		int id = 0;
		while ( index < args.length - 1) {
			switch ( args[index++].trim().toLowerCase() ) {
			case "-i"://className
				id = Integer.parseInt(args[index++]);
				break;
			default:
				System.out.println("-i : student_id ");
				return;
			}
		}
		bridge.delete(id);
	}
	
	public void find( String[] args  ) throws WrongParamCheckException{
		int index = 1;
		int id = 0;
		Vector<String> key = new Vector<String>();
		Vector<CheckField> ck = new Vector<CheckField>();
		while ( index < args.length - 1) {
			switch ( args[index++].trim().toLowerCase() ) {
			case "-n"://name
				key.add(args[index++]);
				ck.add(CheckField.NAME);
				break;
			case "-s"://sex
				key.add(args[index++]);
				ck.add(CheckField.SEX);
				break;
			case "-a"://age
				key.add(args[index++]);
				ck.add(CheckField.AGE);
				break;
			case "-c"://className
				key.add(args[index++]);
				ck.add(CheckField.CLASSNAME);
				break;
			case "-i"://ID
				key.add(args[index++]);
				ck.add(CheckField.ID);
				break;
			default:
				System.out.println("-n :set name");
				System.out.println("-s :set sex");
				System.out.println("-a :set age");
				System.out.println("-c :set className");
				System.out.println("-i  :set ID");
				break;
			}
		}
		
		try {
			System.out.println(bridge.check(ck, key));;
		} catch (WrongParamCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void change( String[] args ) throws WrongParamCheckException{
		int index = 1;
		int id = 0;
		Student stu = new Student();
		while ( index < args.length - 1) {
			switch ( args[index++].trim().toLowerCase() ) {
			case "-n"://name
				stu.setName(args[index++]);
				break;
			case "-s"://sex
				stu.setSex(args[index++].equals("male") ? Sex.MALE : Sex.FAMALE);
				break;
			case "-a"://age
				stu.setAge(Integer.parseInt(args[index++]));
				break;
			case "-c"://className
				stu.setClassName(args[index++]);
				break;
			case "-i"://className
				id = Integer.parseInt(args[index++]);
				break;
			default:
				System.out.println("-i  :set id (necessary)");
				System.out.println("-n :set name");
				System.out.println("-s :set sex");
				System.out.println("-a :set age");
				System.out.println("-c :set className");
				return;
			}
		}
		System.out.println( bridge.modify( id , stu) );;
	}
	
}
