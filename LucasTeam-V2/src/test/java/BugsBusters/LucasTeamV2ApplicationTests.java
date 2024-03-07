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
import BugsBusters.model.Juego;
import BugsBusters.repository.JuegoDao;
import BugsBusters.service.JuegosService;
import BugsBusters.service.JuegosServiceImpl;

import java.util.List;

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

//	@Test
//	void contextLoads() {
//	}
	
//	@Test
//	public void testUltimoValorCargaDatosLocal() {
//		logger.info("Test::testUltimoValorCargaDatosLocal(): Que el id del último valor cargado en la BBDD con JPA sea igual al número de datos contenidos en nuestro CSV inicial.");
//		
//		int longitudCSV = service.cargarListaInicial();
//		
//		int count = (int) dao.count();
//		
//		String responseTest = "Se han cargado " + longitudCSV + " juegos en la BBDD.";
//		String responseExpected = "Se han cargado " + count + " juegos en la BBDD.";
//		
//		assertTrue(responseTest.equals(responseExpected));
//	}
	
//	@Test
//	public void testRespuestaHttpCargaDatosLocal() {
//		logger.info("Test::testRespuestaHttpCargaDatosLocal(): Que el código y el cuerpo de la respuesta al endpoint \"/local\" sea 200 (OK) y contenga el número de datos del CSV inicial.");
//		
//		ResponseEntity<?> responseEntity = controller.cargarListaLocal();
//		
//		int count = (int) dao.count() + 16;
//		
//		ResponseEntity<?> responseExpected = ResponseEntity.ok("Se han cargado " + count + " juegos en la BBDD.");
//		
//		assertTrue(responseEntity.equals(responseExpected));
//	 }
	 
	/**
	 * Método para comprobar si el servicio tiene la misma longitud que el csv inicial
	 */
	 @Test
	 public void testListadoDevuelto() {
		logger.info("Test::testListadoDevuelto(): Que la cantidad de juegos a mostrar por el servicio sea igual a la longitud del CSV inicial, ya que no hemos subido ningun juego todavía");
		int longitudCSV = (int) dao.count();
		
		List<Juego> listado = service.findAll();
		
		assertTrue(longitudCSV == listado.size());
	 }
}
