package com.acaimanager.acaimanager.business.exceptions.general;

import com.acaimanager.acaimanager.business.exceptions.base.RestException;

public class ParametroObrigatorioException extends RestException {

    public ParametroObrigatorioException(String nomeParametro) {
        super("parametroObrigatorioException", nomeParametro);
    }
}
