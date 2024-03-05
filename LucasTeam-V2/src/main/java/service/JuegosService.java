package service;

import java.util.List;

public interface JuegosService {

	public void cargarListaInicial();
	
	List<Juego> findAll();
}
