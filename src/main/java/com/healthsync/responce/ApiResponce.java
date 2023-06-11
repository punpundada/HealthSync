package com.healthsync.responce;



public class ApiResponce {
	private String message;
	private boolean success;
	public ApiResponce(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	public ApiResponce() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
