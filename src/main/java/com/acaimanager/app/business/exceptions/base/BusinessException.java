package com.acaimanager.app.business.exceptions.base;

public abstract class BusinessException extends AbstractException {

    private static final String BUNDLE_NAME = "businessExceptions";

    public BusinessException(String exception) {
        super(BUNDLE_NAME, exception);
    }

    public BusinessException(String exception, String parameter) {
        super(BUNDLE_NAME, exception, parameter);
    }
}
