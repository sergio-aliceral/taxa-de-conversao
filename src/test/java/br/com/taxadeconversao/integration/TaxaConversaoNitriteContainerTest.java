package br.com.taxadeconversao.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import br.com.taxadeconversao.config.NitriteTestContainerConfig;
import br.com.taxadeconversao.infrastructure.adapter.in.dto.TaxaConversaoApiDto;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = NitriteTestContainerConfig.class)
class TaxaConversaoNitriteContainerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void deveProcessarFluxoCompletoDaConversaoComNitriteContainer() {
		
		String url = "http://localhost:" + port + "/taxa-conversao/USD/BRL";
		
		ResponseEntity<TaxaConversaoApiDto> response = restTemplate.getForEntity(url, TaxaConversaoApiDto.class);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().moedaBase()).isEqualTo("USD");
		assertThat(response.getBody().moedaAlvo()).isEqualTo("BRL");
		assertThat(response.getBody().taxaConversao()).isGreaterThan(BigDecimal.ZERO);
	}

}
