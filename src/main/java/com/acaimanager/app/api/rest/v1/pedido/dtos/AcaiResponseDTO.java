package com.acaimanager.app.api.rest.v1.pedido.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AcaiResponseDTO implements Serializable {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "valor")
    private Double valor;

    @JsonProperty(value = "tempoPreparo")
    private Integer tempoPreparo;

    @JsonProperty(value = "descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
