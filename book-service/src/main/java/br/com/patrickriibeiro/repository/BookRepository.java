package br.com.patrickriibeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patrickriibeiro.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	
}
