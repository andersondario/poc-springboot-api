package com.acaimanager.acaimanager.api.rest.v1.pedido.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AcaiResponseDTO implements Serializable {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "valor")
    private Long valor;

    @JsonProperty(value = "tempoPreparo")
    private Long tempoPreparo;

    @JsonProperty(value = "descricao")
    private String descricao;

    public AcaiResponseDTO() {
    }

    public AcaiResponseDTO(Long id, Long valor, Long tempoPreparo, String descricao) {
        this.id = id;
        this.valor = valor;
        this.tempoPreparo = tempoPreparo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Long tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
