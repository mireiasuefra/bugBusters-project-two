package error;

import java.util.List;
import java.util.Map;

public class ErrorMessage {
	private String codigo;
	private List<Map<String, String>> mensajes;
	
	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String codigo, List<Map<String, String>> mensajes) {
		super();
		this.codigo = codigo;
		this.mensajes = mensajes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Map<String, String>> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Map<String, String>> mensajes) {
		this.mensajes = mensajes;
	}

	@Override
	public String toString() {
		return "ErrorMessage [codigo=" + codigo + ", mensajes=" + mensajes + "]";
	}
}
