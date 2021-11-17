package com.rogarocks.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.rogarocks.domain.model.Aplicativo;
import com.rogarocks.domain.repository.AplicativoRepository;

@Repository
public class AplicativoRepositoryImpl implements AplicativoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Aplicativo salvar(Aplicativo aplicativo) {
		return entityManager.merge(aplicativo);
	}

	@Override
	public List<Aplicativo> buscarPorNomeETipo(String nome, String tipo) {
		return entityManager.createQuery("from Aplicativo app where app.nome = :nome and app.tipo = :tipo", Aplicativo.class)
					.setParameter("nome", nome)
					.setParameter("tipo", tipo)
					.getResultList();
	}

	@Override
	public List<Aplicativo> buscarPorTipo(String tipo) {
		return entityManager.createQuery("from Aplicativo app where app.tipo = :tipo", Aplicativo.class)
				.setParameter("tipo", tipo)
				.getResultList();
	}
}
