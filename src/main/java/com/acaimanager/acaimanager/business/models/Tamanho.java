package com.acaimanager.acaimanager.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAMANHO")
public class Tamanho extends AbstractEntity {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
