package com.ayp.sms.exceptionHandling;
/**
 * 
 * @author rana
 *
 */

public class DataValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private String exceptionMessage;
	
	public DataValidationException(String exceptionMessage){
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
