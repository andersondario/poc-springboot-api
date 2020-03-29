package com.acaimanager.acaimanager.api.rest.base;

import java.io.Serializable;

public class SuccessDTO implements Serializable {

    private Serializable body;

    public SuccessDTO(Serializable body) {
        this.body = body;
    }

    public Serializable getBody() {
        return body;
    }
}
