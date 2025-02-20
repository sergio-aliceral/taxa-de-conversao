package br.com.taxadeconversao.application.port.out;

import br.com.taxadeconversao.application.dto.TaxaConversaoProviderDto;

public interface ObterTaxaConversaoGateway {

	TaxaConversaoProviderDto execute(String moedaBase, String moedaAlvo);

}
