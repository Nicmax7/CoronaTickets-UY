package logica.interfaces;

import java.util.List;

import logica.datatypes.DTFuncion;

public interface IControladorConsultaFuncion {

	public String[] listarFunciones(String nombreEspectaculo);
	
	public DTFuncion consultarFuncion(String nombreFuncion);

	public String[] listarPlataformas();

	public String[] listarEspectaculos(String nombrePlataforma);

}
