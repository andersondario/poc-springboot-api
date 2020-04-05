package com.acaimanager.app.business.models;

import javax.persistence.*;

@Entity
@Table(name = "ADICIONAL")
public class Adicional extends AbstractEntity{

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Acai acai;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TIPO_ADICIONAL_ID")
    private TipoAdicional tipoAdicional;

    public Adicional() {
    }

    public Adicional(Acai acai, TipoAdicional tipoAdicional) {
        this.acai = acai;
        this.tipoAdicional = tipoAdicional;
    }

    public Acai getAcai() {
        return acai;
    }

    public void setAcai(Acai acai) {
        this.acai = acai;
    }

    public TipoAdicional getTipoAdicional() {
        return tipoAdicional;
    }

    public void setTipoAdicional(TipoAdicional tipoAdicional) {
        this.tipoAdicional = tipoAdicional;
    }
}
