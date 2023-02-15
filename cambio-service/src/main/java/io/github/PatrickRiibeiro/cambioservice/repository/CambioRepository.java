package io.github.PatrickRiibeiro.cambioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.PatrickRiibeiro.cambioservice.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

	Cambio findByFromAndTo(String from, String to);

}
