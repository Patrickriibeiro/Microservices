package io.github.PatrickRiibeiro.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.PatrickRiibeiro.cambioservice.model.Cambio;
import io.github.PatrickRiibeiro.cambioservice.repository.CambioRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cambio-service") // http://localhost:8080/cambio-service/5/USD/BRL
@RequiredArgsConstructor
public class CambioController {

	private final Environment environment;
	private final CambioRepository cambioRepository;

	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {
				
		var cambio = cambioRepository.findByFromAndTo(from, to);	
		if(cambio == null)
			throw new RuntimeException("Currency Unsupported");
		
		var port = environment.getProperty("local.server.port");
		BigDecimal convertedValue = cambio.getConversionFactor().multiply(amount);
		cambio.setConversionValue(convertedValue.setScale(2,RoundingMode.CEILING));
		cambio.setEnvironment(port);
		
		return cambio;
	}

}
