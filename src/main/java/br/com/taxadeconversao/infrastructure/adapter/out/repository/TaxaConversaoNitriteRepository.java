package br.com.taxadeconversao.infrastructure.adapter.out.repository;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.stereotype.Repository;

import br.com.taxadeconversao.domain.model.TaxaConversao;

@Repository
class TaxaConversaoNitriteRepository implements ITaxaConversaoRepository {

	private final ObjectRepository<TaxaConversao> repository;

	public TaxaConversaoNitriteRepository(Nitrite nitriteDatabase) {
		this.repository = nitriteDatabase.getRepository(TaxaConversao.class);
	}

	@Override
	public void save(TaxaConversao taxaCambio) {
		repository.insert(taxaCambio);
	}

}
