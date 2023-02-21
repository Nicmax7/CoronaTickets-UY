package logica.excepciones;

public class YaContieneEspectaculo extends Exception {

	private static final long serialVersionUID = 1L;

	public YaContieneEspectaculo(String message) {
		super(message);
	}
}