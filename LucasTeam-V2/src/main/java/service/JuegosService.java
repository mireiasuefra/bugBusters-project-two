package service;

import java.util.List;
import java.util.Optional;

public interface JuegosService {

	public void cargarListaInicial();
	
	public List<Juego> findAll();
	
}
