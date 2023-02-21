package logica.interfaces;

import logica.datatypes.DTPaquete;
import logica.excepciones.PaqueteRepetidoException;

public interface IControladorAltaPaquete {

	public void agregarPaquete(DTPaquete dtPaquete) throws PaqueteRepetidoException;
}
