package com.ayp.sms.util;

import com.ayp.sms.dto.ResponseObject;

/**
 * 
 * @author rana
 *
 */

public class ResponseUtil {
	
	public static ResponseObject createResponseObject(String status, String message, Object object){
		ResponseObject responseObject = new ResponseObject();
		responseObject.setMessage(message);
		responseObject.setStatus(status);
		responseObject.setObject(object);
		return responseObject;
	}
	
}
