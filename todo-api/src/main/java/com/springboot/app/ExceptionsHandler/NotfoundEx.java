package com.springboot.app.ExceptionsHandler;

import org.springframework.http.HttpStatus;

public class NotfoundEx extends ApiException {
    public NotfoundEx(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
