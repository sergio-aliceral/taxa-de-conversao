package br.com.taxadeconversao.infrastructure.adapter.out.repository;

import org.springframework.stereotype.Service;

import br.com.taxadeconversao.application.dto.TaxaConversaoPersistenciaDto;
import br.com.taxadeconversao.application.port.out.GravarTaxaConversaoGateway;
import br.com.taxadeconversao.domain.model.TaxaConversao;

@Service
public class GravarTaxaConversaoService implements GravarTaxaConversaoGateway {

	private final ITaxaConversaoRepository repository;

	public GravarTaxaConversaoService(ITaxaConversaoRepository repository) {
		this.repository = repository;
	}

	@Override
	public TaxaConversaoPersistenciaDto execute(TaxaConversao taxaConversao) {
		repository.save(taxaConversao);
		return TaxaConversaoPersistenciaDto.fromEntity(taxaConversao);
	}

}
