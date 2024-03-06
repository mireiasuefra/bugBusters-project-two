package service;

import java.util.List;
import java.util.Optional;
import model.Juego;

public interface JuegosService {


	int cargarListaInicial();

	List<Juego> findAll();

	Optional<Juego> findById(int id);
	
	Juego altaJuego(Juego juego);
	
}
