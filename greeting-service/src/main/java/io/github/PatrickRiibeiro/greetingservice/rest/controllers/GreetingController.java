package io.github.PatrickRiibeiro.greetingservice.rest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.PatrickRiibeiro.greetingservice.config.GreetingConfiguration;
import io.github.PatrickRiibeiro.greetingservice.rest.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@Autowired
	private GreetingConfiguration greetingConfiguration;

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping
	public Greeting greeting(@RequestParam(value="name",defaultValue = "") String name) {
		
		if (name.isEmpty()) name = greetingConfiguration.getDefaultValue();

		return new Greeting(
					counter.incrementAndGet(),
					String.format(template, greetingConfiguration.getGreeting(),name)
				);
	}
}
