package com.xiegd.database;

import java.util.Vector;

import com.xiegd.exception.WrongParamCheckException;
import com.xiegd.model.CheckField;
import com.xiegd.model.Person;

public interface SqlOperation {
	boolean add(Person p);
	boolean delete( int id );
	Vector<Person> check(  Vector<CheckField> ck  , Vector<String> key ) throws WrongParamCheckException ;
	boolean modify(int ID  , Person newp);
}
