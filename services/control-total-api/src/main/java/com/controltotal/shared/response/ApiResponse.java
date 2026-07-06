package com.controltotal.shared.response;

import java.time.LocalDateTime;

public record ApiResponse<T> (boolean success, LocalDateTime timestamp, String message, T data){

    public  static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<>(true,LocalDateTime.now(), message,data);
    }

    public static <T> ApiResponse<T> error(String message, T data){
        return new ApiResponse<>(false,LocalDateTime.now(), message,data);
    }

    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>(false,LocalDateTime.now(), message,null);
    }

}
