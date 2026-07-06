package com.controltotal.shared.exception;

public class ResourceNotFoundException extends ApiException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
