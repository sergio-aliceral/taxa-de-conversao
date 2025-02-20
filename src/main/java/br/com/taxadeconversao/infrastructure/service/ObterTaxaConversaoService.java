package br.com.taxadeconversao.infrastructure.service;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.taxadeconversao.application.dto.TaxaConversaoProviderDto;
import br.com.taxadeconversao.application.port.out.ObterTaxaConversaoGateway;
import br.com.taxadeconversao.infrastructure.enums.ProviderType;

@Service
class ObterTaxaConversaoService implements ObterTaxaConversaoGateway {
	private static final Logger logger = getLogger(ObterTaxaConversaoService.class);

	private final ProviderType provider;
	private final Map<ProviderType, ObterTaxaConversaoStrategy> strategyMap;

	public ObterTaxaConversaoService(@Value("${provider}") String provider, List<ObterTaxaConversaoStrategy> strategies) {
		this.provider = validarProvider(provider);
		this.strategyMap = strategies.stream().collect(toMap(ObterTaxaConversaoStrategy::getProviderType, identity()));
	}

	private ProviderType validarProvider(String provider) {
		return Arrays
					.stream(ProviderType.values())
					.filter(p -> p.name().equalsIgnoreCase(provider))
					.findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Provedor inválido no application.yml: " + provider));
	}

	@Override
	public TaxaConversaoProviderDto execute(String moedaBase, String moedaAlvo) {
		var strategy = strategyMap.get(this.provider);
		var taxaConversaoProviderDto = strategy.execute(moedaBase, moedaAlvo);
		logger.info("[TAXA-CONVERSAO] PROVEDOR:{} | MOEDA BASE:{} | MOEDA ALVO:{} | TAXA DE CONVERSÃO:{}", provider, moedaBase, moedaAlvo, taxaConversaoProviderDto.taxaConversao());
		return taxaConversaoProviderDto;
	}

}
