package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoDao extends JpaRepository<Juego ,Integer> {
	
	// no hacen falta, vienen de serie

	// Juego save(Juego juego);
	
	// List<Juego> findAll();
	
	// Juego findById(Long id);
}
