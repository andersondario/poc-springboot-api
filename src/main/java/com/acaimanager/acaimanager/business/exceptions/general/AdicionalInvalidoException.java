package com.acaimanager.acaimanager.business.exceptions.general;

import com.acaimanager.acaimanager.business.exceptions.base.BusinessException;

public class AdicionalInvalidoException extends BusinessException {

    public AdicionalInvalidoException(String nomeAdicional) {
        super("adicionalInvalidoException", nomeAdicional);
    }
}
