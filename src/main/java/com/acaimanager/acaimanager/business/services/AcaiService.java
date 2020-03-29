package com.acaimanager.acaimanager.business.services;

import com.acaimanager.acaimanager.business.exceptions.TamanhoInvalidoException;
import com.acaimanager.acaimanager.business.models.Acai;
import com.acaimanager.acaimanager.business.models.Tamanho;
import com.acaimanager.acaimanager.business.repositories.AcaiRepository;
import com.acaimanager.acaimanager.business.repositories.AdicionaisRepository;
import com.acaimanager.acaimanager.business.repositories.FrutaRepository;
import com.acaimanager.acaimanager.business.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Acai criaAcai(String nomeTamanho, String nomeFruta, List<String> adicionais) throws TamanhoInvalidoException {
        final Tamanho tamanho = getTamanho(nomeTamanho);

        return null;
    }

    private Tamanho getTamanho(String nomeTamanho) throws TamanhoInvalidoException {
        final Tamanho tamanho = tamanhoRepository.findByNome(nomeTamanho);
        if (tamanho == null) throw new TamanhoInvalidoException();

        return tamanho;
    }
}
