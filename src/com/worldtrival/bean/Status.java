package com.worldtrival.bean;

public class Status {
	private int succeed;
	private int error_code;
	public Status(int succeed, int error_code) {
		super();
		this.succeed = succeed;
		this.error_code = error_code;
	}
	public Status() {
		super();
	}
	public int getSucceed() {
		return succeed;
	}
	public void setSucceed(int succeed) {
		this.succeed = succeed;
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	
}
