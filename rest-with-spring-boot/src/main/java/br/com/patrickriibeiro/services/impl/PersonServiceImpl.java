package br.com.patrickriibeiro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patrickriibeiro.exceptions.ResourceNotFoundException;
import br.com.patrickriibeiro.model.Person;
import br.com.patrickriibeiro.model.repositorys.PersonRepository;
import br.com.patrickriibeiro.services.PersonServices;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonServices {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findPersonAll() {
		return personRepository.findAll();
	}

	public Person findById(Long id) {
		log.info("Finding one person!");
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found."));
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person update(Person person) {
		log.info("Update one Person");
		Person personEntity = personRepository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("Person not found."));
		
		personEntity.setFirstName(person.getFirstName());
		personEntity.setLastName(person.getLastName());
		personEntity.setGender(person.getGender());
		personEntity.setAddress(person.getAddress());

		return personRepository.save(personEntity);
	}

	@Override
	public void delete(Long id) {
		personRepository.deleteById(personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found.")).getId());
	}

}
