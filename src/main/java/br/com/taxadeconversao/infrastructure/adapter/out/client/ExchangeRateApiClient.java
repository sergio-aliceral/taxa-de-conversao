package br.com.taxadeconversao.infrastructure.adapter.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.taxadeconversao.infrastructure.adapter.out.client.response.ExchangeRateResponse;
import br.com.taxadeconversao.infrastructure.config.ExchangeRateApiFeignConfig;

@FeignClient(name = "exchangeRateClient", url = "${exchangerate.url}", configuration = ExchangeRateApiFeignConfig.class)
public interface ExchangeRateApiClient {

	@GetMapping("/{baseCode}/{targetCode}")
	public ExchangeRateResponse pairConversion(@PathVariable String baseCode, @PathVariable String targetCode);

}
