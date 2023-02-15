package io.github.PatrickRiibeiro.bookservice.controller;

import java.util.HashMap;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.PatrickRiibeiro.bookservice.model.Book;
import io.github.PatrickRiibeiro.bookservice.repository.BookRepository;
import io.github.PatrickRiibeiro.bookservice.response.Cambio;
import io.github.PatrickRiibeiro.proxy.CambioProxy;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;

@RestController
@RequestMapping("book-service")
@RequiredArgsConstructor
public class BookController {

	private final Environment environment;
	private final BookRepository bookRepository;
	private final CambioProxy cambioProxy;

	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		var book = bookRepository.findById(id);

		if (book == null)
			throw new RuntimeException("Book not Found");

		var cambio = cambioProxy.getCambio(book.get().getPrice(), "USD", currency);

		var port = environment.getProperty("local.server.port");
		book.get().setEnvironment(port + "FEIGN");
		book.get().setPrice(cambio.getConversionValue());
		return book.get();
	}

	/*
	 * HashMap<String, String> params = new HashMap<>(); params.put("amount",
	 * book.get().getPrice().toString()); params.put("from", "USD");
	 * params.put("to", currency);
	 * 
	 * var response = new
	 * RestTemplate().getForEntity("http://localhost:8000/cambio-service" +
	 * "/{amount}/{from}/{to}", Cambio.class, params);
	 * 
	 * var cambio = response.getBody();
	 */

}
