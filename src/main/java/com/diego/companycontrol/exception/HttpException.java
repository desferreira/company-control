package com.diego.companycontrol.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException{

    public HttpStatus status;

    public String type;

    public String message;

    public HttpException(String message, HttpStatus status, String type) {
        this.message = message;
        this.status = status;
        this.type = type;
    }

}
