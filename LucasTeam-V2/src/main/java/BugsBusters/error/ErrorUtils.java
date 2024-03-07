package BugsBusters.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ErrorUtils
 * Es la clase que se encarga de los mensajes de error del objeto json
 * 06/03/2024
 * V1
 * BugsBusters
 */
public class ErrorUtils {
	
	/**
	 * Método que se encarga de formatear los mensajes de error a partir de un objeto BindingResult en formato json
	 * @param result Objeto BindingResult que contiene los errores de validación
	 * @return Una cadena json que contiene los mensajes de error formateados
	 */
	public static String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), "Problema: "+err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        
        ErrorMessage errorMessage = new ErrorMessage("01",errors);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
