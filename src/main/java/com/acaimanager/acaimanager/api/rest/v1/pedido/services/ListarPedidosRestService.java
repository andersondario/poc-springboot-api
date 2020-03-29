package com.acaimanager.acaimanager.api.rest.v1.pedido.services;

import com.acaimanager.acaimanager.api.rest.base.RestService;
import com.acaimanager.acaimanager.business.models.Acai;
import com.acaimanager.acaimanager.business.services.AcaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

@Service
public class ListarPedidosRestService implements RestService<Serializable, ArrayList<Acai>> {

    @Autowired
    private AcaiService acaiService;

    @Override
    public ArrayList<Acai> dispatch(Serializable serializable) throws Exception {
        return (ArrayList<Acai>) acaiService.getAllAcais();
    }
}
