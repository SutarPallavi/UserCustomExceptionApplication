package com.springbeanexample.beanexample.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(NoSuchUserExistException.class)
	public ResponseEntity<ErrorResponse> handleNoSuchUserExistException (Exception e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		return new ResponseEntity<>(
				new ErrorResponse(
						status,
						e.getMessage()), status); 
	}
	
	@ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(
        Exception e
    ) {
        // ... potential custom logic

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
            new ErrorResponse(
              status, 
              e.getMessage(), 
              stackTrace // specifying the stack trace in case of 500s
            ),
            status
        );
    }

}
