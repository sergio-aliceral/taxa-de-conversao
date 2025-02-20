package br.com.taxadeconversao.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.taxadeconversao.domain.model.TaxaConversao;

public record TaxaConversaoPersistenciaDto(
			String id, 
			String moedaBase, 
			String moedaAlvo, 
			BigDecimal taxaConversao,
			LocalDateTime dataHora) {

	public static TaxaConversaoPersistenciaDto fromEntity(TaxaConversao entity) {
		return new TaxaConversaoPersistenciaDto(
					entity.getId(), 
					entity.getMoedaBase(), 
					entity.getMoedaAlvo(),
					entity.getTaxaConversao(), 
					entity.getDataHora());
	}

}
