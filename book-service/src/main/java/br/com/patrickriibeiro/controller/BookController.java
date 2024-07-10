package br.com.patrickriibeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.model.Book;
import br.com.patrickriibeiro.repository.BookRepository;

@RestController
@RequestMapping(value = "/book-service")
public class BookController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {
		
		var book = bookRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Book not found"));
		
		book.setEnvironment(environment.getProperty("local.server.port"));			
		return book;
				
	}

}
