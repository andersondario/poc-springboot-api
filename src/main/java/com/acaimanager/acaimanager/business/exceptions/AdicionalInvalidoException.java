package com.acaimanager.acaimanager.business.exceptions;

public class AdicionalInvalidoException extends BusinessException {

    public AdicionalInvalidoException(String nomeAdicional) {
        super("Adicional <"+ nomeAdicional + "> inválido");
    }
}
