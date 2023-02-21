package logica.interfaces;

import logica.excepciones.YaContieneEspectaculo;

public interface IControladorAgregarEspectaculoAPaquete {

	void agregarEspectaculoAPaquete(String nombrePaquete, String nombreEspectaculo) throws YaContieneEspectaculo;

	String[] consultarEspectaculosPlataforma(String nombrePlataforma);
	
	public String[] listarPaquetes();
}
