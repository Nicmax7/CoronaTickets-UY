package logica.controller;

import logica.datatypes.DTPaquete;
import logica.entidades.Paquete;
import logica.excepciones.PaqueteRepetidoException;
import logica.interfaces.IControladorAltaPaquete;
import logica.manejadores.ManejadorPaquete;

public class ControladorAltaPaquete implements IControladorAltaPaquete {

	@Override
	public void agregarPaquete(DTPaquete dtPaquete) throws PaqueteRepetidoException{
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete paquete = mP.buscarPaquete(dtPaquete.getNombre());
		
		if(paquete != null) {
			throw new PaqueteRepetidoException("Ya existe un paquete con el nombre: "+ dtPaquete.getNombre());
		}
		else {
			paquete = new Paquete(dtPaquete.getNombre(), dtPaquete.getDescripcion(), Integer.parseInt(dtPaquete.getDescuento()), dtPaquete.getFechaInicio(), dtPaquete.getFechaFin());
			mP.agregarPaquete(paquete);
		}
	}
}