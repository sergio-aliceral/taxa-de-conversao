package br.com.taxadeconversao.application.usecase;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.taxadeconversao.application.dto.TaxaConversaoAplicacaoDto;
import br.com.taxadeconversao.application.dto.TaxaConversaoPersistenciaDto;
import br.com.taxadeconversao.application.dto.TaxaConversaoProviderDto;
import br.com.taxadeconversao.application.port.out.GravarTaxaConversaoGateway;
import br.com.taxadeconversao.application.port.out.ObterTaxaConversaoGateway;
import br.com.taxadeconversao.domain.model.TaxaConversao;

class BuscarTaxaConversaoServiceTest {

	@Mock
	private ObterTaxaConversaoGateway obterTaxaConversaoGateway;
	@Mock
	private GravarTaxaConversaoGateway gravarTaxaConversaoGateway;
	@InjectMocks
	private BuscarTaxaConversaoService buscarTaxaConversaoService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void deveBuscarETestarConversao() {

		when(obterTaxaConversaoGateway.execute(anyString(), anyString()))
				.thenReturn(new TaxaConversaoProviderDto(BigDecimal.valueOf(5.00)));
		when(gravarTaxaConversaoGateway.execute(any(TaxaConversao.class)))
				.thenReturn(new TaxaConversaoPersistenciaDto("1", "USD", "BRL", BigDecimal.valueOf(5.00), null));

		TaxaConversaoAplicacaoDto resultado = buscarTaxaConversaoService.execute("USD", "BRL");

		assertNotNull(resultado);
		verify(obterTaxaConversaoGateway, times(1)).execute(anyString(), anyString());
		verify(gravarTaxaConversaoGateway, times(1)).execute(any(TaxaConversao.class));
	}

}
