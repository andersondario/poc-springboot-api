package com.acaimanager.acaimanager.functional;

import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiRequestDTO;
import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.AcaiResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcaiManagerApplicationTests {

	private static final String BASE_URL = "/api/v1/pedidos";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void dadoSolicitacaoDeCriarUmPedidoEntaoDeveCriarUmAcaiComSucesso() throws Exception {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequeno");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);

		final HttpEntity<AcaiRequestDTO> entity = new HttpEntity<AcaiRequestDTO>(acaiRequestDTO, null);
		final ResponseEntity<String> postResponse = restTemplate.exchange(createURLWithPort(BASE_URL), HttpMethod.POST, entity, String.class);

		final ObjectMapper objectMapper = new ObjectMapper();
		final AcaiResponseDTO acai = objectMapper.readValue(postResponse.getBody(), AcaiResponseDTO.class);

		assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
		assertEquals(1L, acai.getId().longValue());
	}

	@Test
	public void dadoUmaRequisicaoSemCampoObrigatorioEntaoDeveRetornarBadRequest() throws Exception {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setFruta("morango");

		final HttpEntity<AcaiRequestDTO> entity = new HttpEntity<AcaiRequestDTO>(acaiRequestDTO, null);
		final ResponseEntity<String> postResponse = restTemplate.exchange(createURLWithPort(BASE_URL), HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.BAD_REQUEST, postResponse.getStatusCode());
	}

	@Test
	public void dadoUmaRequisicaoComParametroInvalidoEntaoDeveRetornarUnprocessableEntity() {
		final AcaiRequestDTO acaiRequestDTO = new AcaiRequestDTO();
		acaiRequestDTO.setTamanho("pequenoASD");
		acaiRequestDTO.setFruta("morango");
		acaiRequestDTO.setTempoPreparo(10);

		final HttpEntity<AcaiRequestDTO> entity = new HttpEntity<AcaiRequestDTO>(acaiRequestDTO, null);
		final ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/v1/pedidos"), HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
