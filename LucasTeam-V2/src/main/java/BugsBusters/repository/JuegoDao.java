package BugsBusters.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import BugsBusters.model.Juego;
import BugsBusters.model.Platform;

/**
 * JuegoDao
 * Es la interfaz para acceder a los datos del juego en la base de datos y que proporciona métodos CRUD predefinidos
 * 06/03/2024
 * V2
 * BugsBusters
 */
@Repository
public interface JuegoDao extends JpaRepository<Juego, Integer> {
	
	/**
	 * Método para buscar un juego dado su nombre
	 * @param nombre Nombre del juego
	 * @return Objeto Optional que contiene el juego encontrado si existe y sino estará vacío
	 */
	Optional<Juego> findByNombre(String nombre);
	
	@Query("SELECT j.id FROM Juego j WHERE j.nombre= :nombre AND j.plataforma= :plataforma AND j.editor= :editor")
    Integer idJuegoExistente(@Param("nombre") String nombre,
    					@Param("plataforma") Platform plataforma,
    					@Param("editor") String editor);
	
}
