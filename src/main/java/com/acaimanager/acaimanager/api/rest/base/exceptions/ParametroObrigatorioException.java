package com.acaimanager.acaimanager.api.rest.base.exceptions;

public class ParametroObrigatorioException extends RestException {

    public ParametroObrigatorioException(String message) {
        super("Campo [" + message + "] é obrigatório.");
    }
}
