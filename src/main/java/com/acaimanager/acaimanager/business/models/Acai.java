package com.acaimanager.acaimanager.business.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACAI")
public class Acai extends AbstractEntity {

    @Column(name = "TAMANHO")
    @OneToOne
    private Tamanho tamanho;

    @Column(name = "FRUTA")
    @OneToOne
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
