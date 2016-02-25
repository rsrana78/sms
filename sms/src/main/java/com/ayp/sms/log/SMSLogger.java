package com.ayp.sms.log;


import org.apache.log4j.Logger;

public class SMSLogger {

    private static final Logger LOGGER =
        Logger.getLogger(SMSLogger.class.getName());


    public static void log (Exception e, String methodName, String className) {
        String description =
            className + ":" + methodName + ":" + e.getClass().getName() + ":" +
            e.getMessage();

        LOGGER.info("EXCEPTION:" + description);
    }
    
    public static void log (Exception e) {
        LOGGER.error("EXCEPTION:" + e);
    }
}
