package br.com.patrickriibeiro.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.model.Person;
import br.com.patrickriibeiro.services.PersonServices;

@RestController
@RequestMapping("/v1/restservice/person")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findPersonById(@PathVariable(name = "id") String id) {
		return personServices.findById(id);
	}
	
}
