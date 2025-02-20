package br.com.taxadeconversao.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.dizitart.no2.objects.Id;

public class TaxaConversao {

	@Id
	private String id;
	private String moedaBase;
	private String moedaAlvo;
	private BigDecimal taxaConversao;
	private LocalDateTime dataHora;

	public TaxaConversao(String moedaBase, String moedaAlvo, BigDecimal taxaConversao) {
		this.id = UUID.randomUUID().toString();
		this.moedaBase = moedaBase;
		this.moedaAlvo = moedaAlvo;
		this.taxaConversao = taxaConversao;
		this.dataHora = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}
	
	public String getMoedaAlvo() {
		return moedaAlvo;
	}

	public String getMoedaBase() {
		return moedaBase;
	}

	public BigDecimal getTaxaConversao() {
		return taxaConversao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

}
