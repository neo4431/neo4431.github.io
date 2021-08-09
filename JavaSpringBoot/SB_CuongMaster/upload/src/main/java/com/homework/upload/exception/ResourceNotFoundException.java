package com.homework.upload.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 3539103390640350210L;
    
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}