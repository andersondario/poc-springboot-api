package com.acaimanager.acaimanager.business.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TAMANHO")
public class Tamanho extends AbstractEntity implements Serializable {

    @Column(name = "NOME")
    @JsonProperty(value = "nome")
    private String nome;

    @Column(name = "QUANTIDADE")
    @JsonProperty(value = "quantidade")
    private Integer quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
