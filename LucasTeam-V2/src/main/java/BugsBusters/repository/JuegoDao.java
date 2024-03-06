package BugsBusters.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BugsBusters.model.Juego;

@Repository
public interface JuegoDao extends JpaRepository<Juego, Integer> {
	
	Optional<Juego> findByNombre(String nombre);
	
}
