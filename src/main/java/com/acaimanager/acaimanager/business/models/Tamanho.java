package com.acaimanager.acaimanager.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAMANHO")
public class Tamanho extends AbstractEntity {

    @Column
    private String nome;

    @Column
    private Integer quantidade;

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
