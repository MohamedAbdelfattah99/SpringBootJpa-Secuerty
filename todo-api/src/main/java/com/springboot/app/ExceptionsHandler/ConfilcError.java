package com.springboot.app.ExceptionsHandler;

import org.springframework.http.HttpStatus;

public class ConfilcError extends  ApiException{


    public ConfilcError(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return  HttpStatus.NOT_FOUND;
    }
}
