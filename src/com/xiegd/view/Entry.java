package com.xiegd.view;

import java.util.Scanner;

import com.xiegd.database.DBBridge;
import com.xiegd.database.DBMysql;
import com.xiegd.exception.WrongParamCheckException;

public class Entry {
	static DBBridge bridge = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cmd = null ;
		bridge = new DBBridge( new DBMysql() );
		bridge.setDBTable("studentinfo");
		Order order = new Order();
		order.setBridge(bridge);
		
		try {
			order.menu();
			System.out.print("$:");
			while ( (cmd = sc.nextLine()) != null ) {
			order.parseOrder(cmd);
			System.out.print("$:");
			}
		} catch (WrongParamCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over");
	}


}
