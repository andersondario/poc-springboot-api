package com.acaimanager.acaimanager.business.models;

import javax.persistence.*;

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
    private Adicional adicional;

    public Tamanho getTamanho() {
        return tamanho;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public Adicional getAdicional() {
        return adicional;
    }
}
