package com.acaimanager.acaimanager.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FRUTA")
public class Fruta extends AbstractEntity {

    @Column
    private String nome;

    @Column
    private Integer tempoAdicional;

    public String getNome() {
        return nome;
    }

    public Integer getTempoAdicional() {
        return tempoAdicional;
    }
}
