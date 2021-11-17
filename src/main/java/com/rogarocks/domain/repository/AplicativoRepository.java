package com.rogarocks.domain.repository;

import java.util.List;
import com.rogarocks.domain.model.Aplicativo;

public interface AplicativoRepository {
	Aplicativo salvar (Aplicativo aplicativo);
	
	List<Aplicativo> buscarPorNomeETipo (String nome, String tipo);	
	
	List<Aplicativo> buscarPorTipo (String tipo);
}
