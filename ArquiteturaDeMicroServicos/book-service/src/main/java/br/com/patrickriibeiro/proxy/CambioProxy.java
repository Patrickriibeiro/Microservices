package br.com.patrickriibeiro.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.patrickriibeiro.response.Cambio;

@FeignClient(name = "cambio-service")
public interface CambioProxy {
	
	@GetMapping(value = "/cambio-service/{amount}/{from}/{to}", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cambio getCambio(@PathVariable("amount") Double amount, @PathVariable("from") String from,
			@PathVariable("to") String to);

}
