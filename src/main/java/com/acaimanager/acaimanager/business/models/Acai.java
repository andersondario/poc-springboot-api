package com.acaimanager.acaimanager.business.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACAI")
public class Acai extends AbstractEntity implements Serializable {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TAMANHO_ID")
    @JsonProperty(value = "tamanho")
    private Tamanho tamanho;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FRUTA_ID")
    private Fruta fruta;

    @Column(name = "ADICIONAL")
    @OneToMany(mappedBy = "acai", cascade = CascadeType.ALL)
    private List<Adicional> adicionais;

    @Column(name = "TEMPO_PREPARO")
    private Long tempoPreparo;

    @Column(name = "VALOR")
    private Long valor;

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }

    public Long getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Long tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }
}
