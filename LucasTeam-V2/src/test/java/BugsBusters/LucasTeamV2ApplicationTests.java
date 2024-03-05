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

import controller.JuegosController;
import repository.JuegoDao;
import service.JuegosService;
import service.JuegosServiceImpl;

import java.util.List;

@SpringBootTest
class LucasTeamV2ApplicationTests {

	private static byte cont = 1;
	private static Logger logger;
	
	private JuegosService service = new JuegosServiceImpl();

	private JuegosController controller = new JuegosController();

	static {
		try {
			logger = LogManager.getLogger(JuegoDao.class);
		} catch (Throwable e) {
			System.out.println("No funciona JUnit");
		}
	}

	@BeforeAll
	public static void onceExecutedBeforeAll() {
		logger.info(">>> Iniciando pruebas...");
	}

	@BeforeEach
	public void executedBeforeEach() {
		System.out.println("");
		logger.info(">>> PRUEBA UNITARIA " + (cont++) + " <<<");
	}

	@AfterAll
	public static void onceExecutedAfterAll() {
		logger.info(">>> Terminado las pruebas unitarias");
	}

//	@Test
//	void contextLoads() {
//	}
	
	@Test
	public void testUltimoValorCargadoLocal() {
		logger.info("Test::testUltimoValorCargadoLocal(): Que el id del último valor cargado en la BBDD con JPA sea igual al número de datos contenidos en nuestro CSV inicial.");
		int longitudCSV = service.cargarListaInicial();
		String responseTest = "Se han cargado " + longitudCSV + " juegos en la BBDD.";
		String responseExpected = "Se han cargado 16598 juegos en la BBDD.";
		assertTrue(responseTest.equals(responseExpected));
	}
	
	 @Test
	public void testRespuestaHttpCargaDatosLocal() {
		logger.info("Test::testRespuestaHttpCargaDatosLocal(): Que el código y el cuerpo de la respuesta al endpoint \"/local\" sea 200 (OK) y contenga el número de datos del CSV inicial.");
		ResponseEntity<?> responseEntity = controller.cargarListaLocal();
		ResponseEntity<?> responseExpected = ResponseEntity.ok("Se han cargado 16598 juegos en la BBDD.");
		assertTrue(responseEntity.equals(responseExpected));
	 }
	 
	 @Test
	 public void testListadoDevuelto() {
		logger.info("Test::testListadoDevuelto(): Que la cantidad de juegos a mostrar por el servicio sea igual a la longitud del CSV inicial, ya que no hemos subido ningun juego todavía");
		int longitudCSV = service.cargarListaInicial();
		List<Juego> listado = service.findAll();
		assertTrue(longitudCSV == listado.size);
	 }
}
