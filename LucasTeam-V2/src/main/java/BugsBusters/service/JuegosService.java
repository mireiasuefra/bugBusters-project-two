package BugsBusters.service;

import java.util.List;
import java.util.Optional;

import BugsBusters.model.Juego;

/**
 * JuegosService
 * Es la interfaz service para pasar las métodos de la aplicación
 * 06/03/2024
 * V2
 * BugsBusters
 */

public interface JuegosService {

	/**
	 * Método para cargar la lista inicial csv
	 * @return Longitud del csv
	 */
	int cargarListaInicial();
	
	/**
	 * Método para mostrar la lista de juegos guardados en la base de datos
	 * @return La lista de juegos
	 */
	List<Juego> findAll();
	
	/**
	 * Método para mostrarte los detalles de un juego buscado por su id en la base de datos
	 * @param id ID del juego
	 * @return El juego buscado
	 */
	Optional<Juego> findById(int id);
	
	/**
	 *  Método para mostrarte los detalles de un juego buscado por su nombre en la base de datos
	 * @param nombre Nombre del juego
	 * @return El juego buscado
	 */
	Optional<Juego> findByNombre(String nombre);
	
	/**
	 * Método para añadir un juego en la base de datos
	 * @param juego Juego a añadir
	 * @return Juego añadido
	 */
	Juego altaJuego(Juego juego);
	
}
