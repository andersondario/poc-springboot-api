package com.acaimanager.app.functional;

import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcaiManagerApplicationTests extends AbstractFunctionalTest<AcaiRequestDTO, AcaiResponseDTO> {

	@Test
	public void dadoSolicitacaoDeCriarUmPedidoEntaoDeveCriarUmAcaiComSucesso() throws Exception {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequeno");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);

		final ResponseEntity<String> postResponse = doPostRequest(acaiRequestDTO);
		final ObjectMapper objectMapper = new ObjectMapper();
		final AcaiResponseDTO acai = objectMapper.readValue(postResponse.getBody(), AcaiResponseDTO.class);

		assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
		assertEquals(1L, acai.getId().longValue());
	}

	@Test
	public void dadoUmaRequisicaoSemCampoObrigatorioEntaoDeveRetornarBadRequest() throws Exception {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setFruta("morango");

		doPostAndAssertStatusCode(acaiRequestDTO, HttpStatus.BAD_REQUEST);
	}

	@Test
	public void dadoUmaRequisicaoComParametroInvalidoEntaoDeveRetornarUnprocessableEntity() {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequenoASD");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);

		doPostAndAssertStatusCode(acaiRequestDTO, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Override
	protected String getServiceVersion() {
		return "v1";
	}

	@Override
	protected String getServiceName() {
		return "pedidos";
	}
}
