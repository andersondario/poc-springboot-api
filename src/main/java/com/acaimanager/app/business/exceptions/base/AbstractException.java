package com.acaimanager.app.business.exceptions.base;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class AbstractException extends Exception {

    public AbstractException(String bundleName, String exception) {
        super(getBundleMessage(bundleName, exception));
    }

    public AbstractException(String bundleName, String exception, String parameter) {
        super(MessageFormat.format(getBundleMessage(bundleName, exception), parameter));
    }

    private static String getBundleMessage(String bundleName, String bundleKey) {
        final ResourceBundle rb = ResourceBundle.getBundle(bundleName, Locale.getDefault());
        return rb.getString(bundleKey);
    }
}
