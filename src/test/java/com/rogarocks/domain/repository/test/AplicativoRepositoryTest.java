package com.rogarocks.domain.repository.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.rogarocks.domain.model.Aplicativo;
import com.rogarocks.domain.repository.AplicativoRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class AplicativoRepositoryTest {

	@Autowired
	private AplicativoRepository aplicativoRepository;
	
	@BeforeAll
	void start() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TEC");
		aplicativo.setValor(new BigDecimal(1000.00));
		aplicativoRepository.salvar(aplicativo);
		
		Aplicativo aplicativo2 = new Aplicativo();
		aplicativo2.setNome("App2 Roga Rocks");
		aplicativo2.setTipo("Empresa TEC");
		aplicativo2.setValor(new BigDecimal(2000.00));
		aplicativoRepository.salvar(aplicativo2);
		
		Aplicativo aplicativo3 = new Aplicativo();
		aplicativo3.setNome("App3 Roga Rocks");
		aplicativo3.setTipo("Empresa TEC");
		aplicativo3.setValor(new BigDecimal(1000.00));
		aplicativoRepository.salvar(aplicativo3);
	}
	
	@Test
	void cadastros() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TI");
		aplicativo.setValor(new BigDecimal(1000.00));
		
		Aplicativo cadastrado = aplicativoRepository.salvar(aplicativo);
		
		assertTrue(cadastrado != null);
	}
	
	@Test
	void buscarPorNomeETipo() {

		List<Aplicativo> buscarPorNomeETipo = aplicativoRepository.buscarPorNomeETipo("App1 Roga Rocks", "Empresa TEC");
		
		assertTrue(buscarPorNomeETipo.size() == 1);
	}
	
	@Test
	void buscarPorTipo() {

		List<Aplicativo> buscarPorTipo = aplicativoRepository.buscarPorTipo("Empresa TEC");
		
		assertTrue(buscarPorTipo.size() == 3);
	}
}