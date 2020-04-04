package com.acaimanager.acaimanager.api.rest.v1.pedido.checkers;

import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoChecker {

    public void validateRequestDTO(AcaiRequestDTO acaiRequestDTO) throws BusinessException {
        requiredParams(acaiRequestDTO);
    }

    private void requiredParams(AcaiRequestDTO acaiRequestDTO) {

    }
}
