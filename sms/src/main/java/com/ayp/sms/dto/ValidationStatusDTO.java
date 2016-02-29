package com.ayp.sms.dto;

import java.io.Serializable;

/**
 * 
 * @author rana
 *
 */

public class ValidationStatusDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String validationMessage;
	private boolean validated;
	
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
}
