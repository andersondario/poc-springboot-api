package com.acaimanager.acaimanager.business.exceptions;

public abstract class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }
}
