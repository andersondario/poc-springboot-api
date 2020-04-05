package com.acaimanager.acaimanager.api.rest.v1.pedido.services;

import com.acaimanager.acaimanager.api.rest.base.RestService;
import com.acaimanager.acaimanager.api.rest.v1.pedido.builder.ResponseBuilder;
import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.acaimanager.business.models.Acai;
import com.acaimanager.acaimanager.business.services.AcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPedidoRestService implements RestService<AcaiRequestDTO, AcaiResponseDTO> {

    @Autowired
    private AcaiService acaiService;

    @Override
    public AcaiResponseDTO dispatch(AcaiRequestDTO acaiRequestDTO) throws Exception {
        final Acai acai = acaiService.criaAcai(acaiRequestDTO.getTempoPreparo(), acaiRequestDTO.getTamanho(), acaiRequestDTO.getFruta(), acaiRequestDTO.getAdicionais());
        return ResponseBuilder.build(acai);
    }
}
