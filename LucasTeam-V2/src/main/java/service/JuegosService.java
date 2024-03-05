package service;

import java.util.List;

import model.Juego;

public interface JuegosService {

	public void cargarListaInicial();
	
	List<Juego> findAll();
}
