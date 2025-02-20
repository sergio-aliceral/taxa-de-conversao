package br.com.taxadeconversao.application.port.out;

import br.com.taxadeconversao.application.dto.TaxaConversaoPersistenciaDto;
import br.com.taxadeconversao.domain.model.TaxaConversao;

public interface GravarTaxaConversaoGateway {

	TaxaConversaoPersistenciaDto execute(TaxaConversao taxaConversao);

}
