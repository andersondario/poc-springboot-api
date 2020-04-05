package com.acaimanager.app.unit;

import com.acaimanager.app.business.models.Adicional;
import com.acaimanager.app.business.models.Fruta;
import com.acaimanager.app.business.models.Tamanho;
import com.acaimanager.app.business.models.TipoAdicional;
import com.acaimanager.app.business.services.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalcServiceTest {

    @Mock
    private Tamanho tamanhoMock;

    @Mock
    private Fruta frutaMock;

    @Mock
    private Adicional adicionalMock;

    @Mock
    private TipoAdicional tipoAdicionalMock;

    @Test
    public void dadoUmaConfiguracaoDeAcaiComAdicionaisEntaoDeveSomarCorretamenteTempoAdicional() {
        final CalcService calcService = new CalcService();

        when(tamanhoMock.getTempoAdicional()).thenReturn(15);
        when(frutaMock.getTempoAdicional()).thenReturn(4);
        when(adicionalMock.getTipoAdicional()).thenReturn(tipoAdicionalMock);
        when(tipoAdicionalMock.getTempoAdicional()).thenReturn(1);

        List<Adicional> adicionais = new ArrayList<>();
        adicionais.add(adicionalMock);

        assertEquals(30, calcService.calcularTempoPreparo(10, tamanhoMock, frutaMock, adicionais));
    }

    @Test
    public void dadoUmaConfiguracaoDeAcaiSemAdicionaisEntaoDeveSomarCorretamenteTempoAdicional() {
        final CalcService calcService = new CalcService();

        when(tamanhoMock.getTempoAdicional()).thenReturn(15);
        when(frutaMock.getTempoAdicional()).thenReturn(4);

        List<Adicional> adicionais = new ArrayList<>();

        assertEquals(19, calcService.calcularTempoPreparo(0, tamanhoMock, frutaMock, adicionais));
    }

}
