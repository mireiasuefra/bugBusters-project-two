package controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import model.Juego;
import service.JuegosService;

@RestController
@RequestMapping("/juegos")
@Tag(name = "Juegos", description = "LucaSteam API")
public class JuegosController {

	@Autowired
	private JuegosService service;
	
	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);
	
	@GetMapping("/local")
	public ResponseEntity<?> cargarListaLocal() {
		int datosCargados = service.cargarListaInicial();
		String responseBody;
		if(datosCargados == 0) {
			responseBody = "Ha habido un error al cargar los datos.";
			return ResponseEntity.internalServerError().body(responseBody);
		}
		else {
			responseBody = "Se han cargado " + datosCargados + " juegos en la BBDD.";
			return ResponseEntity.ok(responseBody);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listadoJuegos() {
		List<Juego> listado = service.findAll();
		String responseBody;
		if(listado.size() == 0) {
			responseBody = "La BBDD no contiene ningun juego.";
			return ResponseEntity.internalServerError().body(responseBody);
		}
		else
			return ResponseEntity.ok(listado);
	}
	
	@GetMapping("/{id}")
	public Juego encontrarJuego(@PathVariable int id) {
		return service.findById(id).orElseThrow(JuegoNotFoundException::new);
	}
	
	@PostMapping
	public ResponseEntity<?> altaJuego(@RequestBody Juego juego) {
		Juego result = service.altaJuego(juego);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
