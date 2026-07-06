package com.controltotal.shared.exception;

import com.controltotal.shared.response.ApiResponse;

public abstract class ApiException extends RuntimeException{
    protected ApiException(String message){
        super(message);
    }
}
