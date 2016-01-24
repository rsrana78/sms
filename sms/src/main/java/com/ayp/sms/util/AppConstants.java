package com.ayp.sms.util;


public final class AppConstants {
    
    private AppConstants () {
        throw new RuntimeException(NICE_TRY);
    }
    
    //Response statuses
    public final static String SUCCESS = "SUCCESS";
    public final static String FAILURE = "FAILURE";
    
    //Error Message
    public final static String ERROR_MESSAGE = "message";

    //Application wide messages
    public final static String NICE_TRY = "Nice Try!!!";
    
    //Hard coded string
    public final static String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
    public final static String JDBC_URL = "jdbc.url";
    public final static String JDBC_USERNAME = "jdbc.username";
    public final static String JDBC_PASSWORD = "jdbc.password";
    public final static String HIBERNATE_DIALECT = "hibernate.dialect";
    public final static String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    public final static String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    
    //error pages
    public final static String PAGE_404 = "/errorPages/404";
    public final static String SMS_ERROR_PAGE_REDIRECT_PATH = "/SMS/errorPages/error.jsp";
    
    //exception messages
    public final static String RECORD_NOT_FOUND_EXCEPTION = "No data found for this record.";
    public final static String DATABASE_CONNECTION_EXCEPTION = "Could not create database connection for this action. Please try again at some other time";
    public final static String SQL_EXCEPTION = "Error while fetching data from server";
    public final static String DATA_NOT_READABLE_EXCEPTION = "Data is not in readable format in JSON.";
    public final static String TYPE_MISMATCH_EXCEPTION = "Data type error. Please try with valid data type";
    public final static String NUMBER_FORMAT_EXCEPTION = "Data type error. Please try with numbers only(0-9)";
    public final static String ARITHMETIC_EXCEPTION = "Error while applying mathematical function";
    public final static String NULL_POINTER_EXCEPTION = "Can not process empty record. Null pointer exception";
    public final static String PARSER_EXCEPTION = "Server error while parsing data. Please try again";
    public final static String MAIN_EXCEPTION = "Internal server error. Please try again or contact administrator";
    public final static String IO_EXCEPTION = "Error with input or output devices. Please try again";
    public final static String JSON_GENARATION_EXCEPTION = "Error while creating JSON. Please try again or contact administrator";
    public final static String JSON_PROCESSING_EXCEPTION = "Error while processing JSON. Please try again or contact administrator";
    public final static String ILLEGAL_STATE_EXCEPTION = "Illegal state error. Please contact administrator";
    public final static String EMAIL_MESSAGE_EXCEPTION = "Error while sending email. Please try again";
    public final static String EMAIL_ADDRESS_EXCEPTION = "Entered email address is not correct. Please try with valid email address";
    public final static String FILE_ATTACHMENTS_EXCEPTION = "Attached file not found.";
      
}
