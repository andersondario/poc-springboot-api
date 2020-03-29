package com.acaimanager.acaimanager.business.services;

import com.acaimanager.acaimanager.business.exceptions.AdicionalInvalidoException;
import com.acaimanager.acaimanager.business.exceptions.BusinessException;
import com.acaimanager.acaimanager.business.exceptions.FrutaInvalidaException;
import com.acaimanager.acaimanager.business.exceptions.TamanhoInvalidoException;
import com.acaimanager.acaimanager.business.models.Acai;
import com.acaimanager.acaimanager.business.models.Adicional;
import com.acaimanager.acaimanager.business.models.Fruta;
import com.acaimanager.acaimanager.business.models.Tamanho;
import com.acaimanager.acaimanager.business.repositories.AcaiRepository;
import com.acaimanager.acaimanager.business.repositories.AdicionaisRepository;
import com.acaimanager.acaimanager.business.repositories.FrutaRepository;
import com.acaimanager.acaimanager.business.repositories.TamanhoRepository;
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
    private AdicionaisRepository adicionaisRepository;

    @Autowired
    private FrutaRepository frutaRepository;

    public Acai criaAcai(String nomeTamanho, String nomeFruta, List<String> nomeAdicionais) throws BusinessException {
        final Acai acai = new Acai();

        acai.setTamanho(getTamanho(nomeTamanho));
        acai.setFruta(getFruta(nomeFruta));
        acai.setAdicionais(getAdicionais(nomeAdicionais));

        return acaiRepository.create(acai);
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

    private List<Adicional> getAdicionais(List<String> nomeAdicionais) throws AdicionalInvalidoException {
        final List<Adicional> adicionais = new ArrayList<>();

        for (String nomeAdicional : nomeAdicionais) {
            final Adicional adicional = adicionaisRepository.findBy(nomeAdicional);
            if (adicional == null) throw new AdicionalInvalidoException(nomeAdicional);

            adicionais.add(adicional);
        }

        return adicionais;
    }
}
