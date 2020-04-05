package com.acaimanager.app.functional;

import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.app.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.acaimanager.app.business.models.Acai;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcaiManagerApplicationTests extends AbstractFunctionalTest<AcaiRequestDTO, AcaiResponseDTO> {

	@Test
	public void dadoSolicitacaoDeCriarUmPedidoEntaoDeveCriarUmAcaiComSucesso() throws Exception {
		final ResponseEntity<String> postResponse = doRequest(HttpMethod.POST, buildValidAcaiRequestDTO());
		final ObjectMapper objectMapper = new ObjectMapper();
		final AcaiResponseDTO acai = objectMapper.readValue(postResponse.getBody(), AcaiResponseDTO.class);

		assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
		assertEquals(1L, acai.getId().longValue());

		final ResponseEntity<String> getRespose = doRequest(HttpMethod.GET, null);
		final AcaiResponseDTO[] acais = objectMapper.readValue(getRespose.getBody(), AcaiResponseDTO[].class);

		assertEquals(1, acais.length);
	}

	@Test
	public void dadoUmaRequisicaoSemCampoObrigatorioEntaoDeveRetornarBadRequest() throws Exception {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setFruta("morango");

		doRequestAndAssertStatusCode(HttpMethod.POST, acaiRequestDTO, HttpStatus.BAD_REQUEST);
	}

	@Test
	public void dadoUmaRequisicaoComParametroInvalidoEntaoDeveRetornarUnprocessableEntity() {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequenoASD");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);

		doRequestAndAssertStatusCode(HttpMethod.POST, acaiRequestDTO, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	private AcaiRequestDTO buildValidAcaiRequestDTO() {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequeno");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);
		return acaiRequestDTO;
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
