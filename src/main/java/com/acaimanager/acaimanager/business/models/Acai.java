package com.acaimanager.acaimanager.business.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACAI")
public class Acai extends AbstractEntity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAMANHO_ID")
    private Tamanho tamanho;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRUTA_ID")
    private Fruta fruta;

    @Column(name = "ADICIONAL")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adicional> adicionais;

    public Tamanho getTamanho() {
        return tamanho;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public void setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }
}
