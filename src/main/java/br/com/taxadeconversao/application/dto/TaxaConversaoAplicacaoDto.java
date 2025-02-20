package br.com.taxadeconversao.application.dto;

import java.math.BigDecimal;

public record TaxaConversaoAplicacaoDto(String moedaBase, String moedaAlvo, BigDecimal taxaConversao) {

	public static TaxaConversaoAplicacaoDto from(TaxaConversaoPersistenciaDto dto) {
		return new TaxaConversaoAplicacaoDto(dto.moedaBase(), dto.moedaAlvo(), dto.taxaConversao());
	}

}
