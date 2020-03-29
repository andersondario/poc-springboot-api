package com.acaimanager.acaimanager.api.rest.v1.pedido.controllers;

import com.acaimanager.acaimanager.api.rest.base.AbstractControlller;
import com.acaimanager.acaimanager.api.rest.v1.pedido.checkers.CriarPedidoChecker;
import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.PedidoDTO;
import com.acaimanager.acaimanager.api.rest.v1.pedido.services.CriarPedidoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/api/v1/pedidos")
public class CriarPedidoRestController extends AbstractControlller<PedidoDTO, Serializable, CriarPedidoRestService> {

    @Autowired
    private CriarPedidoRestService pedidoRestService;

    @Autowired
    private CriarPedidoChecker pedidoChecker;

    @PostMapping
    public ResponseEntity<Serializable> criaPedido(@RequestBody PedidoDTO pedidoDTO) {
        return processRequest(pedidoRestService, pedidoDTO);
    }

    @Override
    protected void preExecutionCheck(PedidoDTO pedidoDTO) throws Exception {
        pedidoChecker.validateRequestDTO(pedidoDTO);
    }

    @Override
    protected void posExecutionCheck(Serializable serializable) throws Exception {

    }

    @Override
    protected HttpStatus getSuccessCode() {
        return HttpStatus.CREATED;
    }
}
