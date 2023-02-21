package logica.controller;

import java.util.ArrayList;
import java.util.List;

import logica.datatypes.DTPaquete;
import logica.entidades.Paquete;
import logica.interfaces.IControladorConsultaPaquete;
import logica.manejadores.ManejadorPaquete;

public class ControladorConsultaPaquete implements IControladorConsultaPaquete{

	@Override
	public DTPaquete infoPaquete(String nombrePaquete) {
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete paqueteRetorno = mP.buscarPaquete(nombrePaquete);
		DTPaquete dtPaquete = new DTPaquete(nombrePaquete, paqueteRetorno.getDescripcion(), paqueteRetorno.getFechaInicio(), paqueteRetorno.getFechaFin() ,paqueteRetorno.getDescuento());
				
		return dtPaquete;		
	}
	
	@Override
	public String[] obtenerEspectaculosPaquete(String nombrePaquete){
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		Paquete paquete = mP.buscarPaquete(nombrePaquete);
		List<String>espectaculos = paquete.getEspectaculos();
		String[] espectaculos_string = new String[espectaculos.size()];
		int i=0;
		for(String nombre:espectaculos) {
			espectaculos_string[i]=nombre;
			i++;
		}
		return espectaculos_string;
	}		
	
	@Override
	public String[] listarPaquetes() {
		List<String> paquetes = new ArrayList<String>();
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		paquetes = mP.listarPaquetes();		
		
		String[] ret = new String[paquetes.size()];
		for(int i=0;i<paquetes.size();i++) {
			ret[i] = paquetes.get(i);
		}
		return ret;
	}
}
