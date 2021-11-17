package com.rogarocks.api.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rogarocks.domain.model.Aplicativo;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class AplicativoControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void deveCadastrarERetornar201() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TI");
		aplicativo.setValor(new BigDecimal(1000.00));
		
		HttpEntity<Aplicativo> request = new HttpEntity<Aplicativo>(aplicativo);
		
		ResponseEntity<Aplicativo> resposta = testRestTemplate.exchange("/aplicativos", HttpMethod.POST, 
				request, Aplicativo.class);
		assertEquals(resposta.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	void deveBuscarPorNomeETipo() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TI");
		aplicativo.setValor(new BigDecimal(1000.00));
		
		HttpEntity<Aplicativo> request = new HttpEntity<Aplicativo>(aplicativo);
		
		ResponseEntity<Aplicativo> resposta = testRestTemplate.exchange("/aplicativos", HttpMethod.POST, 
				request, Aplicativo.class);
		assertEquals(resposta.getStatusCode(), HttpStatus.CREATED);
	
		ResponseEntity<Aplicativo[]> resposta2 = testRestTemplate.getForEntity("/aplicativos/buscar?nome=App1 Roga Rocks&tipo=Empresa TI", Aplicativo[].class);
		assertEquals(resposta2.getStatusCode(), HttpStatus.OK);
	}	
	
	@Test
	void deveBuscarPorMaisBarato() {
		Aplicativo aplicativo = new Aplicativo();
		aplicativo.setNome("App1 Roga Rocks");
		aplicativo.setTipo("Empresa TI");
		aplicativo.setValor(new BigDecimal(1000.00));
		
		HttpEntity<Aplicativo> request = new HttpEntity<Aplicativo>(aplicativo);
		
		ResponseEntity<Aplicativo> resposta = testRestTemplate.exchange("/aplicativos", HttpMethod.POST, 
				request, Aplicativo.class);
		assertEquals(resposta.getStatusCode(), HttpStatus.CREATED);
		
		Aplicativo aplicativo2 = new Aplicativo();
		aplicativo2.setNome("App2 Roga Rocks");
		aplicativo2.setTipo("Empresa TI");
		aplicativo2.setValor(new BigDecimal(2000.00));
		
		HttpEntity<Aplicativo> request2 = new HttpEntity<Aplicativo>(aplicativo2);
		
		ResponseEntity<Aplicativo> resposta2 = testRestTemplate.exchange("/aplicativos", HttpMethod.POST, 
				request2, Aplicativo.class);
		assertEquals(resposta2.getStatusCode(), HttpStatus.CREATED);
		
		Aplicativo aplicativo3 = new Aplicativo();
		aplicativo3.setNome("App3 Roga Rocks");
		aplicativo3.setTipo("Empresa TI");
		aplicativo3.setValor(new BigDecimal(1000.00));
		
		HttpEntity<Aplicativo> request3 = new HttpEntity<Aplicativo>(aplicativo3);
		
		ResponseEntity<Aplicativo> resposta3 = testRestTemplate.exchange("/aplicativos", HttpMethod.POST, 
				request3, Aplicativo.class);
		assertEquals(resposta3.getStatusCode(), HttpStatus.CREATED);		
		
		ResponseEntity<Aplicativo[]> resposta4 = testRestTemplate.getForEntity("/aplicativos/buscarBarato?tipo=Empresa TI", Aplicativo[].class);
		assertEquals(resposta4.getStatusCode(), HttpStatus.OK);
		assertEquals(resposta4.getBody().length, 2);
	}
}