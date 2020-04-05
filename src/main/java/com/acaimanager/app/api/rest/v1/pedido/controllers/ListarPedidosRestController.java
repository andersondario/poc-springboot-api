package com.acaimanager.app.api.rest.v1.pedido.controllers;

import com.acaimanager.app.api.rest.base.AbstractControlller;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.app.api.rest.v1.pedido.services.ListarPedidosRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/pedidos")
public class ListarPedidosRestController extends AbstractControlller<Serializable, ArrayList<AcaiResponseDTO>, ListarPedidosRestService> {

    @Autowired
    private ListarPedidosRestService listarPedidosRestService;

    @GetMapping
    public ResponseEntity<Serializable> listaPedidos() {
        return processRequest(listarPedidosRestService, null);
    }

    @Override
    protected void preExecutionCheck(Serializable serializable) throws Exception {

    }

    @Override
    protected void posExecutionCheck(ArrayList<AcaiResponseDTO> acais) throws Exception {

    }

    @Override
    protected HttpStatus getSuccessCode() {
        return HttpStatus.OK;
    }
}
