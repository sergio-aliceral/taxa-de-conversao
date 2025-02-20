package br.com.taxadeconversao.infrastructure.adapter.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taxadeconversao.application.port.in.BuscarTaxaConversaoUseCase;
import br.com.taxadeconversao.infrastructure.adapter.in.dto.TaxaConversaoApiDto;

@RestController
@RequestMapping("/taxa-conversao")
public class TaxaConversaoController {

	private final BuscarTaxaConversaoUseCase buscarTaxaConversaoUseCase;

	public TaxaConversaoController(BuscarTaxaConversaoUseCase buscarTaxaConversaoUseCase) {
		this.buscarTaxaConversaoUseCase = buscarTaxaConversaoUseCase;
	}

	@GetMapping("/{moedaBase}/{moedaAlvo}")
	public ResponseEntity<TaxaConversaoApiDto> execute(@PathVariable String moedaBase, @PathVariable String moedaAlvo) {
		var taxaConversaoAplicacaoDto = buscarTaxaConversaoUseCase.execute(moedaBase, moedaAlvo);
		var taxaConversaoApiDto = TaxaConversaoApiDto.from(taxaConversaoAplicacaoDto);
		return ResponseEntity.ok(taxaConversaoApiDto);
	}

}
