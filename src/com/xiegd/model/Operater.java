package com.xiegd.model;

public enum Operater {
	ADD("Add"),
	DELETE("Delete"),
	QUREY("Query"),
	MODIFY("Modify");

	private String Operation;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	private Operater( String Operation ) {
		// TODO Auto-generated constructor stub
		this.setOperation(Operation);
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	
}
