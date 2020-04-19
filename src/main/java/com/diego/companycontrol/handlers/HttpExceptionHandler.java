package com.diego.companycontrol.handlers;

import com.diego.companycontrol.exception.HttpException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity handleException(HttpException e, WebRequest request){
        return ResponseEntity.status(e.status).body(e.message);
    }
}
