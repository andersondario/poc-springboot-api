package com.acaimanager.acaimanager.api.rest.base;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
