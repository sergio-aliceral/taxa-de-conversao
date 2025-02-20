package br.com.taxadeconversao.infrastructure.adapter.in.dto;

import java.math.BigDecimal;

import br.com.taxadeconversao.application.dto.TaxaConversaoAplicacaoDto;

public record TaxaConversaoApiDto(String moedaBase, String moedaAlvo, BigDecimal taxaConversao) {

	public static TaxaConversaoApiDto from(TaxaConversaoAplicacaoDto dto) {
		return new TaxaConversaoApiDto(dto.moedaBase(), dto.moedaAlvo(), dto.taxaConversao());
	}

}
