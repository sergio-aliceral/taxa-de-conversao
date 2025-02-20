package br.com.taxadeconversao.infrastructure.service;

import org.springframework.stereotype.Service;

import br.com.taxadeconversao.application.dto.TaxaConversaoProviderDto;
import br.com.taxadeconversao.infrastructure.adapter.out.client.ExchangeRateApiClient;
import br.com.taxadeconversao.infrastructure.enums.ProviderType;

@Service
public class ExchangeRateApiService implements ObterTaxaConversaoStrategy {

	private final ExchangeRateApiClient exchangeRateApiClient;

	public ExchangeRateApiService(ExchangeRateApiClient exchangeRateApiClient) {
		this.exchangeRateApiClient = exchangeRateApiClient;
	}

	@Override
	public TaxaConversaoProviderDto execute(String moedaBase, String moedaAlvo) {
		var exchangeRateResponse = exchangeRateApiClient.pairConversion(moedaBase, moedaAlvo);
		return new TaxaConversaoProviderDto(exchangeRateResponse.getConversionRate());
	}

	@Override
	public ProviderType getProviderType() {
		return ProviderType.EXCHANGE_RATE_API;
	}

}
