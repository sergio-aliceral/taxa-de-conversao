package br.com.taxadeconversao.application.port.in;

import br.com.taxadeconversao.application.dto.TaxaConversaoAplicacaoDto;

public interface BuscarTaxaConversaoUseCase {

	TaxaConversaoAplicacaoDto execute(String moedaBase, String moedaAlvo);

}
