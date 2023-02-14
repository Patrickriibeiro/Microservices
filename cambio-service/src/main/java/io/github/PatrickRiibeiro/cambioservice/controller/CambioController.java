package io.github.PatrickRiibeiro.cambioservice.controller;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.PatrickRiibeiro.cambioservice.model.Cambio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cambio-service") // http://localhost:8080/cambio-service/5/USD/BRL
@RequiredArgsConstructor
public class CambioController {

	private final Environment environment;

	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {
		var port = environment.getProperty("local.server.port");

		return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
	}

}
