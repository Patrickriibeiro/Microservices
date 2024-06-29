package br.com.patrickriibeiro.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.configuration.GreetingConfiguration;
import br.com.patrickriibeiro.model.Greeting;

@RestController
@RequestMapping("/v1/greeting")
public class GreetingController {

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingConfiguration configuration;
	
	@GetMapping
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
		
		if(name.isEmpty()) name = configuration.getDefaultValue();

		return new Greeting(counter.incrementAndGet(),
				String.format(template, configuration.getGreeting(), name));
	}
	
}
