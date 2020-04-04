package com.acaimanager.acaimanager.e2e;

import com.acaimanager.acaimanager.api.rest.v1.pedido.dtos.PedidoDTO;
import com.acaimanager.acaimanager.business.models.Acai;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
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
class AcaiManagerApplicationTests {

	private static final String BASE_URL = "/api/v1/pedidos";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void dadoSolicitacaoDeCriarUmPedidoEntaoDeveCriarUmAcaiComSucesso() throws Exception {
		final PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setTamanho("pequeno");
		pedidoDTO.setFruta("morango");

		final HttpEntity<PedidoDTO> entity = new HttpEntity<PedidoDTO>(pedidoDTO, null);
		final ResponseEntity<String> postResponse = restTemplate.exchange(createURLWithPort(BASE_URL), HttpMethod.POST, entity, String.class);

		final ObjectMapper objectMapper = new ObjectMapper();
		final Acai acai = objectMapper.readValue(postResponse.getBody(), Acai.class);

		assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
		assertEquals(1L, acai.getId().longValue());
		assertEquals(300L, acai.getTamanho().getQuantidade().longValue());
	}

	@Test
	public void dadoSolicitacaoDeCriarUmPedidoDeFormaInvalidaEntaoDeveRetornarErro() {
		final PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setTamanho("pequenoASD");

		final HttpEntity<PedidoDTO> entity = new HttpEntity<PedidoDTO>(pedidoDTO, null);
		final ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/v1/pedidos"), HttpMethod.POST, entity, String.class);

		assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
