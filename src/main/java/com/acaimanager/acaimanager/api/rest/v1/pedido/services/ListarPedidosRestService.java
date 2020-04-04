package com.acaimanager.acaimanager.api.rest.v1.pedido.services;

import com.acaimanager.acaimanager.api.rest.base.RestService;
import com.acaimanager.acaimanager.api.rest.v1.pedido.builder.ResponseBuilder;
import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.acaimanager.business.models.Acai;
import com.acaimanager.acaimanager.business.services.AcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListarPedidosRestService implements RestService<Serializable, ArrayList<AcaiResponseDTO>> {

    @Autowired
    private AcaiService acaiService;

    @Override
    public ArrayList<AcaiResponseDTO> dispatch(Serializable serializable) throws Exception {
        final List<Acai> allAcais = acaiService.getAllAcais();
        final ArrayList<AcaiResponseDTO> acaisResponseDTO = new ArrayList<>();

        allAcais.forEach(acai -> acaisResponseDTO.add(ResponseBuilder.build(acai)));

        return acaisResponseDTO;
    }
}
