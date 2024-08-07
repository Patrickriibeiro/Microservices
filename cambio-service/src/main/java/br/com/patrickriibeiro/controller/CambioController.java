package br.com.patrickriibeiro.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.model.Cambio;
import br.com.patrickriibeiro.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;
	
	@Operation(description = "Get cambio from currency")
	@GetMapping(value = "/{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {
		Cambio cambio = repository.findByFromAndTo(from, to)
				.orElseThrow( () -> new RuntimeException("Currency Unsupported"));
		cambio.setEnvironment(environment.getProperty("local.server.port") + " FEIGN ");
		cambio.setConvertedValue(cambio.getConversionFactor()
				.multiply(amount)
				.setScale(2, RoundingMode.CEILING));
		return cambio;
	}

}
