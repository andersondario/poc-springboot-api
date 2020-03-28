package com.acaimanager.acaimanager.api.rest.v1.pedido;

import com.acaimanager.acaimanager.api.rest.base.RestService;
import com.acaimanager.acaimanager.business.services.AcaiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class PedidoRestService implements RestService<PedidoDTO, Serializable> {

    @Autowired
    private AcaiService acaiService;

    @Override
    public Serializable dispatch(PedidoDTO pedidoDTO) {
        return null;
    }
}
