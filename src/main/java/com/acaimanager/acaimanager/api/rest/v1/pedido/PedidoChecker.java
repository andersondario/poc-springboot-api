package com.acaimanager.acaimanager.api.rest.v1.pedido;

import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class PedidoChecker {

    public void validateRequestDTO(PedidoDTO pedidoDTO) throws BusinessException {
        requiredParams(pedidoDTO);
    }

    private void requiredParams(PedidoDTO pedidoDTO) {

    }
}
