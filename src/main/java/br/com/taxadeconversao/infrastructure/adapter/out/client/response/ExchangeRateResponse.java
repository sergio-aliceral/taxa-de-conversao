package br.com.taxadeconversao.infrastructure.adapter.out.client.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRateResponse {

	@JsonProperty("conversion_rate")
	private BigDecimal conversionRate;

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

}
