package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JuegoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public JuegoNotFoundException() {
		super("No existe el juego");
	}
	
	public JuegoNotFoundException(Long id) {
		super("No existe el juego con id " + id);
	}
	
}
