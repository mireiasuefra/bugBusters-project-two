package BugsBusters.error;

import java.util.List;
import java.util.Map;

/**
 * ErrorMesaage
 * Es la clase que se encarga de los mensajes de error de la aplicación
 * 06/03/2024
 * V1
 * BugsBusters
 */
public class ErrorMessage {
	private String codigo;
	private List<Map<String, String>> mensajes;
	
	/**
	 * Constructor para tratar los mensajes de error 
	 */
	public ErrorMessage() {
		super();
	}
	
	/**
	 * Constructor para tratar los mensajes de error con parámetros
	 * @param codigo Código de error
	 * @param mensajes List Map de los mensajes de error
	 */
	public ErrorMessage(String codigo, List<Map<String, String>> mensajes) {
		super();
		this.codigo = codigo;
		this.mensajes = mensajes;
	}
	
	/**
	 * Método que devuelve el código
	 * @return Código del error
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Método que modifica el código
	 * @param codigo Codigo del error
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Método que devuelve un List Map de mensajes de error
	 * @return List Map de mensajes de error
	 */
	public List<Map<String, String>> getMensajes() {
		return mensajes;
	}
	
	/**
	 * Método que modifica un List Map de mensajes de error
	 * @param mensajes List Map de mensajes de error
	 */
	public void setMensajes(List<Map<String, String>> mensajes) {
		this.mensajes = mensajes;
	}
	
	/**
	 * Método de la clase que imprime por pantalla
	 */
	@Override
	public String toString() {
		return "ErrorMessage [codigo=" + codigo + ", mensajes=" + mensajes + "]";
	}
}
