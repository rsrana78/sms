package com.ayp.sms.exceptionHandling;

import static com.ayp.sms.util.AppConstants.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ParserException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.transaction.TransactionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ayp.sms.dto.ResponseObject;
import com.ayp.sms.log.SMSLogger;
import com.ayp.sms.util.ResponseUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOGGER = Logger.getLogger(SMSLogger.class.getName());
	
	@ExceptionHandler(TransactionException.class)
	@ResponseBody
	public ResponseObject transactionExceptionHandler(TransactionException exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if((request.getHeader("X-Requested-With") == null)){
			request.getSession().setAttribute(ERROR_MESSAGE, DATABASE_CONNECTION_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, DATABASE_CONNECTION_EXCEPTION, null);
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseObject sqlExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, SQL_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, SQL_EXCEPTION, null);
	}
	
	@ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
	@ResponseBody
	public ResponseObject integrityConstrainstsExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, SQL_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, SQL_EXCEPTION,null);
	}
	
	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseBody
	public ResponseObject httpMessageExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, DATA_NOT_READABLE_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, DATA_NOT_READABLE_EXCEPTION,null);
	}
	
	@ExceptionHandler(JDBCConnectionException.class)
	@ResponseBody
	public ResponseObject jdbcExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, SQL_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, SQL_EXCEPTION,null);
	}
	
	@ExceptionHandler(MySQLSyntaxErrorException.class)
	@ResponseBody
	public ResponseObject sqlSyntaxExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, SQL_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, SQL_EXCEPTION,null);
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	@ResponseBody
	public ResponseObject typeMismatchExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, TYPE_MISMATCH_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, TYPE_MISMATCH_EXCEPTION, null);
	}
		
	@ExceptionHandler(ArithmeticException.class)
	@ResponseBody
	public ResponseObject arithmaticExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, ARITHMETIC_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, ARITHMETIC_EXCEPTION, null);
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public ResponseObject nullPointerExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, NULL_POINTER_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, NULL_POINTER_EXCEPTION, null);
	}
	
	@ExceptionHandler(ParserException.class)
	@ResponseBody
	public ResponseObject parserExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, PARSER_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, PARSER_EXCEPTION ,null);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseObject exceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if((request.getHeader("X-Requested-With") == null)){
			request.getSession().setAttribute(ERROR_MESSAGE, MAIN_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, MAIN_EXCEPTION, null);
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseBody
	public ResponseObject ioExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, IO_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, IO_EXCEPTION,null);
	}
	
	@ExceptionHandler(JsonGenerationException.class)
	@ResponseBody
	public ResponseObject jsonGenerationExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, JSON_GENARATION_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, JSON_GENARATION_EXCEPTION,null);
	}
	
	@ExceptionHandler(JsonProcessingException.class)
	@ResponseBody
	public ResponseObject jsonProcessingExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, JSON_PROCESSING_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, JSON_PROCESSING_EXCEPTION,null);
	}
	
	@ExceptionHandler(IllegalStateException.class)
	@ResponseBody
	public ResponseObject illegalStateExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, ILLEGAL_STATE_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, ILLEGAL_STATE_EXCEPTION,null);
	}
	
	@ExceptionHandler(MessagingException.class)
	@ResponseBody
	public ResponseObject emailMessageExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, EMAIL_MESSAGE_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, EMAIL_MESSAGE_EXCEPTION,null);
	}
	
	@ExceptionHandler(AddressException.class)
	@ResponseBody
	public ResponseObject emailAddressExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, EMAIL_ADDRESS_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
        return ResponseUtil.createResponseObject(FAILURE, EMAIL_ADDRESS_EXCEPTION,null);
	}
	
	@ExceptionHandler(FileNotFoundException.class)
	public ResponseObject fileNotFoundExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, FILE_ATTACHMENTS_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, FILE_ATTACHMENTS_EXCEPTION,null);
	}
	
	@ExceptionHandler(NoResultException.class)
	public ResponseObject noResultExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, RECORD_NOT_FOUND_EXCEPTION);
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, RECORD_NOT_FOUND_EXCEPTION,null);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseObject numberFormatExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, NUMBER_FORMAT_EXCEPTION+" "+exception.getLocalizedMessage());
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, NUMBER_FORMAT_EXCEPTION+" "+exception.getLocalizedMessage(),null);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleError404(HttpServletRequest request, Exception exception)   {
            return PAGE_404;
    }
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseObject requestMethdExceptionHandler(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException{
		LOGGER.error("Eception",exception);
		if(request.getHeader("X-Requested-With") == null){
			request.getSession().setAttribute(ERROR_MESSAGE, NUMBER_FORMAT_EXCEPTION+" "+exception.getLocalizedMessage());
			response.sendRedirect(SMS_ERROR_PAGE_REDIRECT_PATH);
			return null;
		}
		return ResponseUtil.createResponseObject(FAILURE, NUMBER_FORMAT_EXCEPTION+" "+exception.getLocalizedMessage(),null);
	}
}
