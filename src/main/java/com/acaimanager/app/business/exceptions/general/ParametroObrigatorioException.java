package com.acaimanager.app.business.exceptions.general;

import com.acaimanager.app.business.exceptions.base.RestException;

public class ParametroObrigatorioException extends RestException {

    public ParametroObrigatorioException(String nomeParametro) {
        super("parametroObrigatorioException", nomeParametro);
    }
}
