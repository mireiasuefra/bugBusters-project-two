package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * JuegoDataException
 * Clase de excepción personalizada para tratar los posibles errores de datos del juego
 * 06/03/2024
 * V1
 * BugsBusters
 */
@ResponseStatus(HttpStatus.MULTI_STATUS)
public class JuegoDataException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor para tratar la excepción de los errores de datos del juego
     * @param mensaje El mensaje descriptivo de la excepción
     */
    public JuegoDataException(String mensaje) {
        super(mensaje);
    }
    
    /**
     * Método para la accción 1 de la excepción de los errores de datos del juego
     */
    public void action1() {
        
    }
}
