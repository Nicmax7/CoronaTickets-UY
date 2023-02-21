package logica.interfaces;

import logica.datatypes.DTPaquete;

public interface IControladorConsultaPaquete {
	
	public DTPaquete infoPaquete (String nombre);

	public String[] obtenerEspectaculosPaquete(String nombrePaquete);

	String[] listarPaquetes();
}
