package com.acaimanager.acaimanager.business.services;

import com.acaimanager.acaimanager.business.exceptions.AdicionalInvalidoException;
import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import com.acaimanager.acaimanager.business.exceptions.FrutaInvalidaException;
import com.acaimanager.acaimanager.business.exceptions.TamanhoInvalidoException;
import com.acaimanager.acaimanager.business.models.*;
import com.acaimanager.acaimanager.business.repositories.AcaiRepository;
import com.acaimanager.acaimanager.business.repositories.FrutaRepository;
import com.acaimanager.acaimanager.business.repositories.TamanhoRepository;
import com.acaimanager.acaimanager.business.repositories.TipoAdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcaiService {

    @Autowired
    private AcaiRepository acaiRepository;

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @Autowired
    private TipoAdicionalRepository adicionaisRepository;

    @Autowired
    private FrutaRepository frutaRepository;

    public Acai criaAcai(String nomeTamanho, String nomeFruta, List<String> nomeAdicionais) throws BusinessException {
        final Acai acai = new Acai();

        acai.setTamanho(getTamanho(nomeTamanho));
//        acai.setFruta(getFruta(nomeFruta));
//        acai.setAdicionais(getAdicionais(acai, nomeAdicionais));

        return acaiRepository.save(acai);
    }

    public List<Acai> getAllAcais() {
        return acaiRepository.findAll();
    }

    private Tamanho getTamanho(String nomeTamanho) throws TamanhoInvalidoException {
        final Tamanho tamanho = tamanhoRepository.findByNome(nomeTamanho.toLowerCase());
        if (tamanho == null) throw new TamanhoInvalidoException();

        return tamanho;
    }

    private Fruta getFruta(String nomeFruta) throws FrutaInvalidaException {
        final Fruta fruta = frutaRepository.findByNome(nomeFruta.toLowerCase());
        if (fruta == null) throw new FrutaInvalidaException();

        return fruta;
    }

    private List<Adicional> getAdicionais(Acai acai, List<String> nomeAdicionais) throws AdicionalInvalidoException {
        final List<Adicional> adicionais = new ArrayList<>();

        for (String nomeAdicional : nomeAdicionais) {
            final TipoAdicional tipoAdicional = adicionaisRepository.findByNome(nomeAdicional);
            if (tipoAdicional == null) throw new AdicionalInvalidoException(nomeAdicional);

            adicionais.add(new Adicional(acai, tipoAdicional));
        }

        return adicionais;
    }
}
