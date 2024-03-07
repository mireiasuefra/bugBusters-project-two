package BugsBusters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * JuegoNOtFounfException
 * Clase de excepción personalizada para tratar el error de que el juego no haya sido encontrado
 * 06/03/2024
 * V1
 * BugsBusters
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class JuegoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor para tratar la excepción de el error de que el juego no haya sido encontrado
	 */
	public JuegoNotFoundException() {
		super("No existe el juego");
	}
	
	/**
	 * Constructor para tratar la excepción de el error de que el juego no haya sido encontrado pasandole el id del juego
	 * @param id ID del juego no encontrado
	 */
	public JuegoNotFoundException(Long id) {
		super("No existe el juego con id " + id);
	}
	
}
