package io.github.PatrickRiibeiro.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.PatrickRiibeiro.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
