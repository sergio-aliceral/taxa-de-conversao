package br.com.taxadeconversao.application.usecase;

import org.springframework.stereotype.Service;

import br.com.taxadeconversao.application.dto.TaxaConversaoAplicacaoDto;
import br.com.taxadeconversao.application.port.in.BuscarTaxaConversaoUseCase;
import br.com.taxadeconversao.application.port.out.GravarTaxaConversaoGateway;
import br.com.taxadeconversao.application.port.out.ObterTaxaConversaoGateway;
import br.com.taxadeconversao.domain.model.TaxaConversao;

@Service
class BuscarTaxaConversaoService implements BuscarTaxaConversaoUseCase {

	private final ObterTaxaConversaoGateway obterTaxaConversaoGateway;
	private final GravarTaxaConversaoGateway gravarTaxaConversaoGateway;

	public BuscarTaxaConversaoService(ObterTaxaConversaoGateway obterTaxaConversaoGateway, GravarTaxaConversaoGateway gravarTaxaConversaoGateway) {
		this.obterTaxaConversaoGateway = obterTaxaConversaoGateway;
		this.gravarTaxaConversaoGateway = gravarTaxaConversaoGateway;
	}

	@Override
	public TaxaConversaoAplicacaoDto execute(String moedaBase, String moedaAlvo) {
		var taxaConversaoResponse = obterTaxaConversaoGateway.execute(moedaBase, moedaAlvo);
		var taxaConversao = new TaxaConversao(moedaBase, moedaAlvo, taxaConversaoResponse.taxaConversao());
		var taxaConversaoPersistenciaDto = gravarTaxaConversaoGateway.execute(taxaConversao);
		return TaxaConversaoAplicacaoDto.from(taxaConversaoPersistenciaDto);
	}

}
