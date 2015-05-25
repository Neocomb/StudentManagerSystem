/**
 * 
 */
package com.xiegd.model;

/**
 * @author Byron
 *
 */
public enum CheckField {
	ID("id"),
	NAME("name"),
	AGE("age"),
	SEX("sex"),
	CLASSNAME("className");
	
	private String field;

	private CheckField(String field) {
		this.setField(field);
	}

	public String getField() {
		return field;
	}

	private void setField(String field) {
		this.field = field;
	}
	
	
}
