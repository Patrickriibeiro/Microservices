package br.com.patrickriibeiro.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.patrickriibeiro.model.Book;
import br.com.patrickriibeiro.repository.BookRepository;
import br.com.patrickriibeiro.response.Cambio;

@RestController
@RequestMapping(value = "/book-service")
public class BookController {

	@Autowired
	private Environment environment;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable Long id, @PathVariable String currency) {

		var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);

		var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
				Cambio.class, params);

		book.setEnvironment(environment.getProperty("local.server.port"));
		book.setPrice(response.getBody().getConvertedValue());
		return book;

	}

}
