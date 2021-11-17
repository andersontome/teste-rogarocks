package com.rogarocks.domain.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rogarocks.domain.model.Aplicativo;
import com.rogarocks.domain.repository.AplicativoRepository;
import com.rogarocks.domain.service.AplicativoService;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class AplicativoServiceTeste {

	@Autowired
	private AplicativoService aplicativoService;
	
	@MockBean
	private AplicativoRepository aplicativoRepository;
	
	@Test
	public void testarMetodoSalvarAoCadastrarCliente() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TI");
		aplicativo.setValor(new BigDecimal(1000.00));
		
		Aplicativo aplicativo2 = new Aplicativo();
		aplicativo2.setNome("App2 Roga Rocks");
		aplicativo2.setTipo("Empresa TI");
		aplicativo2.setValor(new BigDecimal(2000.00));
		
		Aplicativo aplicativo3 = new Aplicativo();
		aplicativo3.setNome("App3 Roga Rocks");
		aplicativo3.setTipo("Empresa TI");
		aplicativo3.setValor(new BigDecimal(1000.00));
		
		List<Aplicativo> aplicativosPorTipo = Arrays.asList(aplicativo, aplicativo2, aplicativo3);
		
		Mockito.when(aplicativoRepository.buscarPorTipo("Empresa TI")).thenReturn(aplicativosPorTipo);

		List<Aplicativo> aplicativosPorTipoRetorno = aplicativoService.buscarMaisBaratoPorTipo("Empresa TI");
		
		assertEquals(aplicativosPorTipoRetorno.size(),2);
		
	}
}