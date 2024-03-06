package service;

import java.util.List;
import java.util.Optional;
import model.Juego;

public interface JuegosService {


	int cargarListaInicial();

	List<Juego> listadoJuegos();

	Optional<Juego> encontrarJuego(int id);
	
	Juego altaJuego(Juego juego);
	
}
