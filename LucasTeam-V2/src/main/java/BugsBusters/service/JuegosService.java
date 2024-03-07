package BugsBusters.service;

import java.util.List;
import java.util.Optional;

import BugsBusters.model.Juego;

public interface JuegosService {


	int cargarListaInicial();

	List<Juego> findAll();

	Optional<Juego> findById(int id);
	
	Optional<Juego> findByNombre(String nombre);
	
	Integer idJuegoSiExiste(Juego juego);
	
	Juego altaJuego(Juego juego);
	
}
