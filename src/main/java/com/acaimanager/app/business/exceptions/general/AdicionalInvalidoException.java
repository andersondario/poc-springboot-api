package com.acaimanager.app.business.exceptions.general;

import com.acaimanager.app.business.exceptions.base.BusinessException;

public class AdicionalInvalidoException extends BusinessException {

    public AdicionalInvalidoException(String nomeAdicional) {
        super("adicionalInvalidoException", nomeAdicional);
    }
}
