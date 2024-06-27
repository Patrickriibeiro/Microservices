package br.com.patrickriibeiro.model.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patrickriibeiro.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
