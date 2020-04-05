package com.acaimanager.app.api.rest.v1.pedido.dtos;

import java.io.Serializable;
import java.util.List;

public class AcaiRequestDTO implements Serializable {

    private String tamanho;

    private String fruta;

    private List<String> adicionais;

    private Integer tempoPreparo;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getFruta() {
        return fruta;
    }

    public void setFruta(String fruta) {
        this.fruta = fruta;
    }

    public List<String> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<String> adicionais) {
        this.adicionais = adicionais;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}
