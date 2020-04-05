package com.acaimanager.app.business.models;

import javax.persistence.*;

@Entity
@Table(name = "FRUTA")
public class Fruta extends AbstractEntity {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "TEMPO_ADICIONAL")
    private Integer tempoAdicional;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTempoAdicional() {
        return tempoAdicional;
    }

    public void setTempoAdicional(Integer tempoAdicional) {
        this.tempoAdicional = tempoAdicional;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
