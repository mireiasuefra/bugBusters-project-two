package BugsBusters.controller;

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

import BugsBusters.model.Juego;
import BugsBusters.service.JuegosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/juegos")
@Tag(name = "juego", description = "LucaSteam API")
public class JuegosController {

	@Autowired
	private JuegosService service;
	
	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);
	
	@Operation(
			summary = "Cargar lista", description = "Carga la lista de juegos del CSV y los guarda en la base de datos", tags= {"juego"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista cargada y guardada", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Juego.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No se ha encontrado el CSV", content = @Content)})
	@GetMapping("/local")
	public ResponseEntity<?> cargarListaLocal() {
		int datosCargados = service.cargarListaInicial();
		String responseBody;
		if(datosCargados == 0) {
			responseBody = "Ha habido un error al cargar los datos.";
			return ResponseEntity.ok(responseBody);
		}
		else {
			responseBody = "Se han cargado " + datosCargados + " juegos en la BBDD.";
			return ResponseEntity.ok(responseBody);
		}
	}
	
	@Operation(
			summary = "Listar juegos", description = "Lista todos los juegos de la base de datos", tags= {"juego"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Juegos listados", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Juego.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "No hay ningun juego", content = @Content)})
	@GetMapping("/all")
	public ResponseEntity<?> listadoJuegos() {
		List<Juego> listado = service.findAll();
		String responseBody;
		if(listado.size() == 0) {
			responseBody = "La BBDD no contiene ningun juego.";
			return ResponseEntity.ok(responseBody);
		}
		else
			return ResponseEntity.ok(listado);
	}
	
	@Operation(
			summary = "Buscar juego ID", description = "Busca y devuelve un juego dentro de la base de datos mediante id", tags= {"juego"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Juego localizado", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Juego.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Juego no encontrado", content = @Content)})
	@GetMapping("/id={id}")
	public Juego encontrarJuegoId(@PathVariable int id) {
		return service.findById(id).orElseThrow(JuegoNotFoundException::new);
	}
	
	@Operation(
			summary = "Buscar juego nombre", description = "Busca y devuelve un juego dentro de la base de datos mediante nombre", tags= {"juego"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Juego localizado", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Juego.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Juego no encontrado", content = @Content)})
	@GetMapping("/nombre={nombre}")
	public Juego encontrarJuegoNombre(@PathVariable String nombre) {
		return service.findByNombre(nombre).orElseThrow(JuegoNotFoundException::new);
	}
	
	@Operation(
			summary = "Subir juego", description = "Agrega un juego a la base de datos", tags= {"juego"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Juego agregado", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Juego.class))}),
			@ApiResponse(responseCode = "400", description = "No valido ", content = @Content),
			@ApiResponse(responseCode = "404", description = "El juego proporcionado ya existe en la base de datos", content = @Content)})
	@PostMapping
	public ResponseEntity<?> altaJuego(@RequestBody Juego juego) {
		if(service.findByNombre(juego.getNombre()).isPresent()) {
			return ResponseEntity.ok("Ya existe el juego: " + juego.getNombre() + " en la BBDD de BugsBusters.");
		}
		else {
			Juego result = service.altaJuego(juego);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
	}
}
