package logica.excepciones;

public class FuncionRepetidaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public FuncionRepetidaException(String string) {
		super(string);
	}
}