package br.com.patrickriibeiro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

//import io.github.resilience4j.retry.annotation.Retry;

@Tag(name = "Foo bar")
@RestController
@RequestMapping(value = "/book-service")
public class FooBarController {

	public static final Logger logger = LoggerFactory.getLogger(FooBarController.class);

	@Operation(summary = "Foo bar")
	@GetMapping("/foo-bar")
	//@Retry(name = "foo-bar", fallbackMethod = "metodoTratativo")
	//@CircuitBreaker(name = "default", fallbackMethod = "metodoTratativo")
	@RateLimiter(name = "default")
	public String fooBar() {
		logger.info("Testando retry resilience.");
		var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		return response.getBody();
	}

	public String metodoTratativo(Exception e) {
		return "Testando metodo Tratativo ." + e.getCause();

	}

}
