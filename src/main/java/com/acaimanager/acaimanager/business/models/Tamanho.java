package com.acaimanager.acaimanager.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TAMANHO")
public class Tamanho extends AbstractEntity implements Serializable {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
