package com.ayp.sms.exceptionHandling;
/**
 * 
 * @author rana
 *
 */

public class RecordNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;
	
	public RecordNotFoundException(String exceptionMessage){
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
