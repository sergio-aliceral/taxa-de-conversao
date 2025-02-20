package br.com.taxadeconversao.infrastructure.service;

import br.com.taxadeconversao.application.dto.TaxaConversaoProviderDto;
import br.com.taxadeconversao.infrastructure.enums.ProviderType;

public interface ObterTaxaConversaoStrategy {

	ProviderType getProviderType();

	TaxaConversaoProviderDto execute(String moedaBase, String moedaAlvo);

}
