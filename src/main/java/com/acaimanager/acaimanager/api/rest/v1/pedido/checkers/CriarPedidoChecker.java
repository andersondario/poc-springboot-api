package com.acaimanager.acaimanager.api.rest.v1.pedido.checkers;

import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.PedidoDTO;
import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoChecker {

    public void validateRequestDTO(PedidoDTO pedidoDTO) throws BusinessException {
        requiredParams(pedidoDTO);
    }

    private void requiredParams(PedidoDTO pedidoDTO) {

    }
}
