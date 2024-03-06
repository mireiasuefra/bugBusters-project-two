package BugsBusters.service;

import java.util.List;
import java.util.Optional;

import BugsBusters.model.Juego;

public interface JuegosService {


	int cargarListaInicial();

	List<Juego> findAll();

	Optional<Juego> findById(int id);
	
	Juego altaJuego(Juego juego);
	
}
