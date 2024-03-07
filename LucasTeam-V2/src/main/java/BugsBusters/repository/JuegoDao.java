package BugsBusters.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BugsBusters.model.Juego;
import BugsBusters.model.Platform;

@Repository
public interface JuegoDao extends JpaRepository<Juego, Integer> {
	
	Optional<Juego> findByNombre(String nombre);
	
	@Query("SELECT j.id FROM Juego j WHERE j.nombre= :nombre AND j.plataforma= :plataforma AND j.editor= :editor")
    Integer idJuegoExistente(@Param("nombre") String nombre,
    					@Param("plataforma") Platform plataforma,
    					@Param("editor") String editor);
	
}
