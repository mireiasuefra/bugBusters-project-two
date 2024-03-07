package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.MULTI_STATUS)
public class JuegoDataException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public JuegoDataException(String mensaje) {
        super(mensaje);
    }

    public void action1() {
        
    }
}
