package com.acaimanager.acaimanager.api.rest.v1.pedido;

import com.acaimanager.acaimanager.api.rest.base.AbstractControlller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

@Controller
public class PedidoRestController extends AbstractControlller<PedidoDTO, Serializable, PedidoRestService> {

    @Autowired
    private PedidoRestService pedidoRestService;

    @Autowired
    private PedidoChecker pedidoChecker;

    @Override
    protected void preExecutionCheck(PedidoDTO pedidoDTO) throws Exception {

    }

    @Override
    protected void posExecutionCheck(Serializable serializable) throws Exception {

    }
}
