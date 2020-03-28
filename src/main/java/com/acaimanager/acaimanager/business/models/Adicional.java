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

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}
