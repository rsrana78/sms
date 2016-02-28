package com.ayp.sms.util;


public final class AppConstants {
    
    //Response statuses
    public final static String SUCCESS = "SUCCESS";
    public final static String FAILURE = "FAILURE";
    
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
    public final static String ERROR_PAGE = "/errorPages/error";
    public final static String SMS_ERROR_PAGE_REDIRECT_PATH = "/SMS/errorPages/error.jsp";
    
    //image bas path
    public static String IMAGE_BASE_URL = null;
    public static String NO_IMAGE_URL = null;      
}
