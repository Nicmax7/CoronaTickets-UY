package logica.interfaces;

import logica.excepciones.EspectaculoRepetidoException;
import logica.datatypes.DTEspectaculo;
import logica.interfaces.IControladorAltaEspectaculo;


public interface IControladorAltaEspectaculo {

	public void agregarEspectaculo(String nombrePlataforma, String nombreArtista, DTEspectaculo dtEspectaculo) throws EspectaculoRepetidoException;
	
	public String[] listarPlataformas();
	
	public String[] listarArtistas();
}
