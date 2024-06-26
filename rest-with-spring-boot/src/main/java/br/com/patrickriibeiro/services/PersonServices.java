package br.com.patrickriibeiro.services;

import java.util.List;

import br.com.patrickriibeiro.model.Person;

public interface PersonServices {

	public Person findById(Long id);
	
	public List<Person> findPersonAll();
	
	public Person create(Person person);
	
	public Person update(Person person);
	
	public void delete(Long id);

}
