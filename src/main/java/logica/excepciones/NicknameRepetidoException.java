package logica.excepciones;


public class NicknameRepetidoException extends Exception{
	private static final long serialVersionUID = 1L;

	public NicknameRepetidoException(String message) {
		super(message);
	}
}

