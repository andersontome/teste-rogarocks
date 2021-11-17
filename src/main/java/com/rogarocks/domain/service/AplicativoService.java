package com.rogarocks.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogarocks.domain.model.Aplicativo;
import com.rogarocks.domain.repository.AplicativoRepository;

@Service
public class AplicativoService {
	
	@Autowired
	private AplicativoRepository aplicativoRepository;
	
	public Aplicativo salvar(Aplicativo aplicativo) {
		return aplicativoRepository.salvar(aplicativo);
	}
	
	public List<Aplicativo> buscarMaisBaratoPorTipo(String tipo) {
		
		List<Aplicativo> aplicativos = aplicativoRepository.buscarPorTipo(tipo);
		List<Aplicativo> aplicativoMaisBarato = new ArrayList<>();
			
		Double min = aplicativos.get(0).getValor().doubleValue();
		
		for (Aplicativo aplicativo :aplicativos) {
			if (aplicativo.getValor().doubleValue() <= min) {
				min = aplicativo.getValor().doubleValue();
				aplicativoMaisBarato.add(aplicativo);
			}
		}
		return aplicativoMaisBarato;
	}
}
