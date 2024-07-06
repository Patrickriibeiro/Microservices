package br.com.patrickriibeiro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patrickriibeiro.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
	
	Optional<Cambio> findByFromAndTo(String from, String to);

}
