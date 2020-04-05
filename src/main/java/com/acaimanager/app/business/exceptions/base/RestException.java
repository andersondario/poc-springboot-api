package com.acaimanager.app.business.exceptions.base;

public abstract class RestException extends AbstractException {

    private static final String BUNDLE_NAME = "restExceptions";

    public RestException(String exception, String parameter) {
        super(BUNDLE_NAME, exception, parameter);
    }
}
