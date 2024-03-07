package BugsBusters.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BugsBusters.model.Genre;
import BugsBusters.model.Juego;
import BugsBusters.model.Platform;
import BugsBusters.repository.JuegoDao;

/**
 * JuegosServiceImpl
 * Es la implementación de la interfaz service para pasar las métodos de la aplicación
 * 06/03/2024
 * V2
 * BugsBusters
 */
@Service
public class JuegosServiceImpl implements JuegosService {
	
	@Autowired
	private JuegoDao juegoDao;
	
	/**
	 * Método para mostrar la lista de juegos guardados en la base de datos
	 */
	@Override
	public int cargarListaInicial() {
		int datosCargados = 0;
		int lineas = 0;
		Integer control = null;
		Juego juegoEntity = null;

        try (Scanner scanner = new Scanner(new File("res/juegos.csv"))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				++lineas;
				Juego nextJuego = leerJuegoString(scanner.nextLine());
				control = juegoDao.idJuegoExistente(nextJuego.getNombre(),
						nextJuego.getPlataforma(),
						nextJuego.getEditor());
				if(control == null) {
					++datosCargados;
					juegoEntity = juegoDao.save(nextJuego);
//					juegoDao.save(nextJuego);
					
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "res/juegos.csv not found");
		}
//        return datosCargados;
        if(lineas == datosCargados) return 1;
        else if (datosCargados == 0) return 0;
        else return 2;
	}
	
	/**
	 * Método para dejar limpio el fichero csv de posibles fallos
	 * @param linea Linea del fichero
	 * @return Juego ya cargado del csv
	 */
	private Juego leerJuegoString(String linea) {
		Juego juego = new Juego();
		int fecha = 0;
		
		if (linea.startsWith("\"")) {
			//Primero separamos el nombre
			String[] datos = linea.split("\"\"");
			String[] datosNombre = datos[1].split(",");
			String nombre = "";
			for(int i = 0; i < datosNombre.length; i++) {
				nombre += datosNombre[i];
			}
			juego.setNombre(nombre);
			
			//Resto de datos
			String[] restoDatos = datos[2].split(",");
			juego.setPlataforma(Platform.fromString(restoDatos[1]));
			try {
				fecha = Integer.parseInt(restoDatos[2]);
			} catch (NumberFormatException e) {
				e.getMessage();
			} finally {
				juego.setFechaPublicacion(fecha);
			}
			
			juego.setGenero(Genre.fromString(restoDatos[3]));
			juego.setEditor(restoDatos[4]);
			juego.setVentas(Float.parseFloat(restoDatos[6]));
		} else {
			String[] datosJuego = linea.split(",");
			juego.setNombre(datosJuego[1]);
			juego.setPlataforma(Platform.fromString(datosJuego[2]));
			try {
				fecha = Integer.parseInt(datosJuego[3]);
			} catch (NumberFormatException e) {
				e.getMessage();
			} finally {
				juego.setFechaPublicacion(fecha);
			}
			
			juego.setGenero(Genre.fromString(datosJuego[4]));
			juego.setEditor(datosJuego[5]);
			juego.setVentas(Float.parseFloat(datosJuego[7]));
		}
		
		return juego;
	}
	
	/**
	 * Método para mostrar la lista de juegos guardados en la base de datos
	 */
	@Override
	public List<Juego> findAll() {
		return juegoDao.findAll();
	}
	
	
	/**
	 * Método para mostrarte los detalles de un juego buscado por su id en la base de datos
	 */
	@Override
	public Optional<Juego> findById(int id) {
		return juegoDao.findById(id);
	}
	
	/**
	 * Método para mostrarte los detalles de un juego buscado por su nombre en la base de datos
	 */
	@Override
	public Optional<Juego> findByNombre(String nombre) {
		return juegoDao.findByNombre(nombre);
	}
	
	

	@Override
	public Integer idJuegoSiExiste(Juego juego) {
		return juegoDao.idJuegoExistente(juego.getNombre(), juego.getPlataforma(), juego.getEditor());
	}
	
	/**
	 * Método para añadir un juego en la base de datos
	 */
	@Override
	public Juego altaJuego(Juego juego) {
		return juegoDao.save(juego);
	}
	
}
