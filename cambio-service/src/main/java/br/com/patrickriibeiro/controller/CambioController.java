package br.com.patrickriibeiro.controller;

import java.math.BigDecimal;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.model.Cambio;
import br.com.patrickriibeiro.repository.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;
	
	@GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		var Cambio = repository.findByFromAndTo(from, to);
		if(Cambio == null) throw new RuntimeException("Currency Unsupported");
		
		return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, environment.getProperty("local.server.port"));
	}

}
