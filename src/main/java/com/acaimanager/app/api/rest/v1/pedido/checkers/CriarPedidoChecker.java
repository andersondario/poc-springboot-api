package com.acaimanager.app.api.rest.v1.pedido.checkers;

import com.acaimanager.app.business.exceptions.general.ParametroObrigatorioException;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoChecker {

    public void validateRequestDTO(AcaiRequestDTO acaiRequestDTO) throws Exception {
        requiredParams(acaiRequestDTO);
    }

    private void requiredParams(AcaiRequestDTO acaiRequestDTO) throws ParametroObrigatorioException {
        if (acaiRequestDTO.getTamanho() == null) throw new ParametroObrigatorioException("tamanho");
        if (acaiRequestDTO.getFruta() == null) throw new ParametroObrigatorioException("fruta");
        if (acaiRequestDTO.getTempoPreparo() == null) throw new ParametroObrigatorioException("tempoPreparo");
    }
}
