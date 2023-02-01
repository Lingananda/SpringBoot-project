package org.jsp.student_crud.exception;

public class UserDefinedException extends Exception {
	String msg;

	public UserDefinedException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
}
