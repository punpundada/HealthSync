package com.healthsync.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7716194579010048386L;


	private String resourcename;
	private String fieldname;
	private Object fieldvalue;
	
	
	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
		
		super(String.format("%s not found with %s:'%s'",resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	
	
}
