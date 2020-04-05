package com.acaimanager.app.business.services;

import com.acaimanager.app.business.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {

    public double calcularValor(Tamanho tamanho, Fruta fruta, List<Adicional> adicionais) {
        double valorFinal = 0.0D;

        valorFinal += safeDoubleValue(tamanho.getValor());
        valorFinal += safeDoubleValue(fruta.getValor());

        for (Adicional adicional : adicionais) {
            final TipoAdicional tipoAdicional = adicional.getTipoAdicional();
            valorFinal += safeDoubleValue(tipoAdicional.getValor());
        }

        return valorFinal;
    }

    public int calcularTempoPreparo(Integer tempoPreparoDefault, Tamanho tamanho, Fruta fruta, List<Adicional> adicionais) {
        int tempoPreparo = tempoPreparoDefault;

        tempoPreparo += safeIntegerValue(tamanho.getTempoAdicional());
        tempoPreparo += safeIntegerValue(fruta.getTempoAdicional());

        for (Adicional adicional : adicionais) {
            final TipoAdicional tipoAdicional = adicional.getTipoAdicional();
            tempoPreparo += safeIntegerValue(tipoAdicional.getTempoAdicional());
        }

        return tempoPreparo;
    }

    private Double safeDoubleValue(Double value) {
        return value == null? 0.0D : value;
    }

    private Integer safeIntegerValue(Integer value) {
        return value == null? 0 : value;
    }
}
