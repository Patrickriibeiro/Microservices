package br.com.patrickriibeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrickriibeiro.model.Book;
import br.com.patrickriibeiro.proxy.CambioProxy;
import br.com.patrickriibeiro.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping(value = "/book-service")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CambioProxy proxy;
	
	@Operation(summary = "Find a sprecific book by your id")
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {
		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
		book.setEnvironment("Book port : " + environment.getProperty("local.server.port") + " Cambio Port : " + cambio.getEnvironment());
		book.setPrice(cambio.getConvertedValue());
		return book;
	}

	/*
	 * HashMap<String, String> params = new HashMap<>(); params.put("amount",
	 * book.getPrice().toString()); params.put("from", "USD"); params.put("to",
	 * currency);
	 * 
	 * var response = new RestTemplate().getForEntity(
	 * "http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class,
	 * params);
	 */

}
