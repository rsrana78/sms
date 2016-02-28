package com.ayp.sms.util;

import static com.ayp.sms.util.AppConstants.IMAGE_BASE_URL;
import static com.ayp.sms.util.AppConstants.NO_IMAGE_URL;

public class CompleteURLUtil {
	
	public static String completeURL(String url){
		if(url == null)
			return IMAGE_BASE_URL+NO_IMAGE_URL;
		else
			return IMAGE_BASE_URL+url;
	}
	
}
