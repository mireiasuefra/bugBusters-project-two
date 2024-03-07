package BugsBusters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import BugsBusters.controller.JuegosController;
import BugsBusters.model.Genre;
import BugsBusters.model.Juego;
import BugsBusters.model.Platform;
import BugsBusters.repository.JuegoDao;
import BugsBusters.service.JuegosService;
import BugsBusters.service.JuegosServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * LucasTeamV2ApplicationTests
 * Es la clase que se encarga de llevar a cabo las pruebas unitarias de la aplicación
 * 06/03/2024
 * V1
 * BugsBusters
 */
@SpringBootTest
class LucasTeamV2ApplicationTests {

	private static byte cont = 1;
	private static Logger logger;
	
	@Autowired
	private JuegosService service;

	@Autowired
	private JuegosController controller;
	
	@Autowired
	private JuegoDao dao;

	static {
		try {
			logger = LogManager.getLogger(LucasTeamV2ApplicationTests.class);
		} catch (Throwable e) {
			System.out.println("No funciona JUnit");
		}
	}
	
	/**
	 * Método ejecutado una vez antes de que se ejecuten las pruebas
	 */
	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas...");
	}
	
	/**
	 * Método ejecutado antes de cada prueba
	 */
	@BeforeEach
	public void executedBeforeEach() {
		System.out.println("");
		logger.info(">>> PRUEBA UNITARIA " + (cont++) + " <<<");
	}
	
	/**
	 * Método ejecutado una vez después de que se ejecuten las pruebas
	 */
	@AfterAll
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas unitarias");
	}

	@Test
	void contextLoads() {
	}
	

	@Test
	public void testRespuestaHttpPrimeraCarga() {
		logger.info("Test::testRespuestaHttpPrimeraCarga(): Que el código y el cuerpo de la respuesta al endpoint \"/local\" sea 200 (OK) y contenga la respuesta esperada: se han cargado todos los juegos.");
		
		ResponseEntity<?> responseEntity = controller.cargarListaLocal();
				
		ResponseEntity<?> responseExpected = ResponseEntity.ok("Se han cargado todos los juegos del CSV en la BBDD.");
		
		assertTrue(responseEntity.equals(responseExpected));
	 }
	
	@Test
	public void testRespuestaHttpCargaRepetida() {
		logger.info("Test::testRespuestaHttpCargaRepetida(): Que el código y el cuerpo de la respuesta al endpoint \"/local\" sea 200 (OK) y contenga la respuesta esperada: juegos ya estaban cargados.");
		
		ResponseEntity<?> responseEntity = controller.cargarListaLocal();
		
		ResponseEntity<?> responseExpected = ResponseEntity.ok("Ya estaban todos los datos cargados.");
		
		assertTrue(responseEntity.equals(responseExpected));
	 }
	
	 @Test
	 public void testListadoDevuelto() {
		logger.info("Test::testListadoDevuelto(): Que la cantidad de juegos a mostrar por el servicio sea igual a la longitud del CSV inicial, ya que no hemos subido ningun juego todavía");
		int longitudCSV = (int) dao.count();
		
		List<Juego> listado = service.findAll();
		
		assertTrue(longitudCSV == listado.size());
	 }
	 
	 @Test
	 public void testBuscarJuegoPorId() {
	     logger.info("Test::testBuscarJuegoPorId(): Buscamos un juego en específico por Id y comprobamos que su nombre coincida con Duck Hunt.");
	     
	     Optional<Juego> test = dao.findById(10);
	     String nombreTest = test.get().getNombre();
	     
	     assertTrue(nombreTest.equals("Duck Hunt"));
	 }

	 @Test
	 public void testJuegoRecienSubido() {
	     logger.info("Test::testJuegoRecienSubido(): Creamos un juego y comprobamos que se ha añadido a la base de datos.");
	     
	     Juego test = new Juego();
	     String nombreJuego = "Imagina ser: Antonio";

	     test.setNombre(nombreJuego);
	     test.setPlataforma(Platform.fromString("PC"));
	     test.setFechaPublicacion(1990);
	     test.setGenero(Genre.fromString("Simulation"));
	     test.setEditor("LucaSteam");
	     test.setVentas(8445.03f);

	     dao.save(test);

	     Optional<Juego> ultimo = dao.findByNombre(nombreJuego);
	     
	     assertTrue(ultimo.isPresent());
	 }
}
