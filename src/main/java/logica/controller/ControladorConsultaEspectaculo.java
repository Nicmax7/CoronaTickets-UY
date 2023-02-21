package logica.controller;

import java.util.ArrayList;
import java.util.List;

import logica.datatypes.DTInfoEspectaculo;
import logica.entidades.Espectaculo;
import logica.interfaces.IControladorConsultaEspectaculo;
import logica.manejadores.ManejadorEspectaculo;
import logica.manejadores.ManejadorPaquete;
import logica.manejadores.ManejadorPlataforma;

public class ControladorConsultaEspectaculo implements IControladorConsultaEspectaculo {

	@Override
	public DTInfoEspectaculo consultaEspectaculo(String nombreEspectaculo) {
		
		ManejadorEspectaculo mE=ManejadorEspectaculo.getInstancia();
		Espectaculo e = mE.buscarEspectaculo(nombreEspectaculo);
		DTInfoEspectaculo dtInfoEspectaculo = new DTInfoEspectaculo(nombreEspectaculo, e.getDescripcion(), e.getDuracion(), e.getUrl(), e.getCosto(), e.getCantMin(), e.getCantMax(), e.getFechaRegistro());
		
		return dtInfoEspectaculo;
	}
	
	@Override
	public String[] listarPaquetesDelEspectaculo(String nombreEspectaculo) {
		List<String> paquetes;
		ManejadorPaquete mP = ManejadorPaquete.getInstancia();
		paquetes = mP.listarPaquetesDeEspectaculo(nombreEspectaculo);
		String[] paquetes_string = new String[paquetes.size()];
		int i=0;
		for(String nombre:paquetes) {
			paquetes_string[i]=nombre;
			i++;
		}
		return paquetes_string;
	}
	
	@Override
	public String[] listarPlataformas() {
		ArrayList<String> plataformas;
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		plataformas = mP.obtenerPlataformas();
		String[] plataformas_ret = new String[plataformas.size()];
        int i=0;
        for(String nombre:plataformas) {
        	plataformas_ret[i]=nombre;
        	i++;
        }
        return plataformas_ret;
	}
}
