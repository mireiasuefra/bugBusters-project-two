package service;

import java.util.List;

public interface JuegosService {

	public int cargarListaInicial();
	
	List<Juego> findAll();
}
