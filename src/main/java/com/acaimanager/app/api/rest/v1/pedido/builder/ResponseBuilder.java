package com.acaimanager.app.api.rest.v1.pedido.builder;

import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.app.business.models.Acai;
import com.acaimanager.app.business.models.Adicional;
import org.springframework.util.StringUtils;

public class ResponseBuilder {

    private static final String DEFAULT_SPACE = " ";

    public static AcaiResponseDTO build(Acai acai) {
        final AcaiResponseDTO acaiResponseDTO = new AcaiResponseDTO();

        acaiResponseDTO.setId(acai.getId());
        acaiResponseDTO.setTempoPreparo(acai.getTempoPreparo());
        acaiResponseDTO.setValor(acai.getValor());
        acaiResponseDTO.setDescricao(buildDescription(acai));

        return acaiResponseDTO;
    }

    private static String buildDescription(Acai acai) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.capitalize(acai.getTamanho().getNome()));
        stringBuilder.append(DEFAULT_SPACE);
        stringBuilder.append(" - ");
        stringBuilder.append(StringUtils.capitalize(acai.getFruta().getNome()));

        if (!acai.getAdicionais().isEmpty()) {
            stringBuilder.append(DEFAULT_SPACE);
            stringBuilder.append("+");
            stringBuilder.append(DEFAULT_SPACE);
            stringBuilder.append("[");

            for (Adicional adicional : acai.getAdicionais()) {
                stringBuilder.append(adicional.getTipoAdicional().getNome());
                stringBuilder.append(DEFAULT_SPACE);
            }

            stringBuilder.append("]");
        }

        return stringBuilder.toString();
    }
}
