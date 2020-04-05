package com.acaimanager.acaimanager.api.rest.base.exceptions;

public abstract class RestException extends Exception {

    public RestException(String message) {
        super(message);
    }
}
