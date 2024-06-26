package br.com.patrickriibeiro.services.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.patrickriibeiro.model.Person;
import br.com.patrickriibeiro.services.PersonServices;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonServices{
	
	private final AtomicLong counter = new AtomicLong();

	public Person findById(String id) {
		log.info("Finding one person!");
		return new Person(counter.incrementAndGet(),
				"Patrick","Oliveira",
				"Rio De Janeiro",
				"Masculino");
	}	
	
}
