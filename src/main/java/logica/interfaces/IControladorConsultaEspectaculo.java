package logica.interfaces;

import logica.datatypes.DTInfoEspectaculo;

public interface IControladorConsultaEspectaculo {

	public DTInfoEspectaculo consultaEspectaculo(String nombreEspectaculo);

	String[] listarPaquetesDelEspectaculo(String nombreEspectaculo);

	String[] listarPlataformas();
}
