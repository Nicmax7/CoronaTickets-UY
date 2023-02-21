package logica.interfaces;

import logica.datatypes.DTPlataforma;
import logica.excepciones.PlataformaRepetidaException;

public interface IControladorAltaPlataforma {
	
	public void agregarPlataforma(DTPlataforma dtPlataforma) throws PlataformaRepetidaException;
	
}
