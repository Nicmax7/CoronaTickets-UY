package logica.controller;

import logica.datatypes.DTPlataforma;
import logica.entidades.Plataforma;
import logica.excepciones.PlataformaRepetidaException;
import logica.interfaces.IControladorAltaPlataforma;
import logica.manejadores.ManejadorPlataforma;

public class ControladorAltaPlataforma implements IControladorAltaPlataforma {

	@Override
	public void agregarPlataforma(DTPlataforma dtPlataforma) throws PlataformaRepetidaException{
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma p = mP.buscarPlataforma(dtPlataforma.getNombrePlataforma());
		if (p != null) {
			throw new PlataformaRepetidaException("La Plataforma " + dtPlataforma.getNombrePlataforma() + " ya esta registrada");
		}
		p = new Plataforma(dtPlataforma.getNombrePlataforma(),dtPlataforma.getDescripcion(),dtPlataforma.getUrl());
		mP.agregarPlataforma(p);
	}
}
