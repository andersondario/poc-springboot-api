package com.acaimanager.app.api.rest.v1.pedido.controllers;

import com.acaimanager.app.api.rest.base.AbstractControlller;
import com.acaimanager.app.api.rest.v1.pedido.checkers.CriarPedidoChecker;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.app.api.rest.v1.pedido.services.CriarPedidoRestService;
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
public class CriarPedidoRestController extends AbstractControlller<AcaiRequestDTO, AcaiResponseDTO, CriarPedidoRestService> {

    @Autowired
    private CriarPedidoRestService pedidoRestService;

    @Autowired
    private CriarPedidoChecker pedidoChecker;

    @PostMapping
    public ResponseEntity<Serializable> criaPedido(@RequestBody AcaiRequestDTO acaiRequestDTO) {
        return processRequest(pedidoRestService, acaiRequestDTO);
    }

    @Override
    protected void preExecutionCheck(AcaiRequestDTO acaiRequestDTO) throws Exception {
        pedidoChecker.validateRequestDTO(acaiRequestDTO);
    }

    @Override
    protected void posExecutionCheck(AcaiResponseDTO acaiResponseDTO) throws Exception {

    }

    @Override
    protected HttpStatus getSuccessCode() {
        return HttpStatus.CREATED;
    }
}
