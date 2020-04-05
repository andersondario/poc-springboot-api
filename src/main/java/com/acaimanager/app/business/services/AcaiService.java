package com.acaimanager.app.business.services;

import com.acaimanager.app.business.exceptions.general.AdicionalInvalidoException;
import com.acaimanager.app.business.exceptions.base.BusinessException;
import com.acaimanager.app.business.exceptions.general.FrutaInvalidaException;
import com.acaimanager.app.business.exceptions.general.TamanhoInvalidoException;
import com.acaimanager.app.business.models.*;
import com.acaimanager.app.business.repositories.AcaiRepository;
import com.acaimanager.app.business.repositories.FrutaRepository;
import com.acaimanager.app.business.repositories.TamanhoRepository;
import com.acaimanager.app.business.repositories.TipoAdicionalRepository;
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
    private TipoAdicionalRepository tipoAdicionalRepository;

    @Autowired
    private FrutaRepository frutaRepository;

    @Autowired
    private CalcService calcService;

    public Acai criaAcai(Integer tempoPreparo, String nomeTamanho, String nomeFruta, List<String> nomeAdicionais) throws BusinessException {
        final Acai acai = new Acai();
        final Tamanho tamanho = getTamanho(nomeTamanho);
        final Fruta fruta = getFruta(nomeFruta);
        final List<Adicional> adicionais = getAdicionais(acai, nomeAdicionais);

        acai.setTamanho(tamanho);
        acai.setFruta(fruta);
        acai.setAdicionais(adicionais);
        acai.setValor(calcService.calcularValor(tamanho, fruta, adicionais));
        acai.setTempoPreparo(calcService.calcularTempoPreparo(tempoPreparo, tamanho, fruta, adicionais));

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

        if(nomeAdicionais != null) {
            for (String nomeAdicional : nomeAdicionais) {
                final TipoAdicional tipoAdicional = tipoAdicionalRepository.findByNome(nomeAdicional);
                if (tipoAdicional == null) throw new AdicionalInvalidoException(nomeAdicional);

                adicionais.add(new Adicional(acai, tipoAdicional));
            }
        }

        return adicionais;
    }
}
