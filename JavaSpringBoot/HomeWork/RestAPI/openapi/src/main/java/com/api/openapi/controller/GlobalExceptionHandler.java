package com.api.openapi.controller;

import com.api.openapi.model.ErrorDetail;
import com.api.openapi.repository.ResourceNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail("Resource not found", request.getDescription(true));
        return handleExceptionInternal(ex, errorDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request){
        String errorMessage = "internal server error";
        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            ErrorDetail errorDetail = new ErrorDetail("Validation Failed", ex.getBindingResult().toString());
        // TODO Auto-generated method stub
        return handleExceptionInternal(ex, errorDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
