package com.acaimanager.acaimanager.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADICIONAL")
public class Adicional extends AbstractEntity {

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTempoAdicional() {
        return tempoAdicional;
    }

    public void setTempoAdicional(Integer tempoAdicional) {
        this.tempoAdicional = tempoAdicional;
    }
}
