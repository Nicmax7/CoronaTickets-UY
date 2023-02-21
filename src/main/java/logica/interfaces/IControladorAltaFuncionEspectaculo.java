package logica.interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import logica.datatypes.DTFuncionE;
import logica.excepciones.FuncionRepetidaException;

public interface IControladorAltaFuncionEspectaculo {

	public String[] consultarEspectaculosPlataforma(String nombrePlataforma);
	
	public List<String> consultaArtistas();
	
	public void ingresarFuncionEspectaculo(DTFuncionE funcion) throws FuncionRepetidaException;

}
