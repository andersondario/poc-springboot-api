package com.acaimanager.acaimanager.business.models;

import javax.persistence.*;

@Entity
@Table(name = "FRUTA")
public class Fruta extends AbstractEntity {

    @Column(name = "NOME")
    private String nome;

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
}
