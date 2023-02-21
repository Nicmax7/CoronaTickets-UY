package logica.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import logica.datatypes.DTFuncion;
import logica.entidades.Espectaculo;
import logica.entidades.Funcion;
import logica.entidades.Plataforma;
import logica.interfaces.IControladorConsultaFuncion;
import logica.manejadores.ManejadorEspectaculo;
import logica.manejadores.ManejadorFuncion;
import logica.manejadores.ManejadorPlataforma;

public class ControladorConsultaFuncion implements IControladorConsultaFuncion {
	//private Espectaculo espectaculo;
	
	@Override
	public DTFuncion consultarFuncion(String nombreFuncion) {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		Funcion funcionRetorno = mF.buscarFuncion(nombreFuncion);
		
		int hora = funcionRetorno.getFecha().getHour();
		int minuto = funcionRetorno.getFecha().getMinute();
		LocalTime horaInicio = LocalTime.of(hora, minuto);
		
		DTFuncion dtFuncion = new DTFuncion(nombreFuncion, funcionRetorno.getFecha().toLocalDate(),horaInicio ,funcionRetorno.getFechaRegistro());
		return dtFuncion;
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

	@Override
	public String[] listarEspectaculos(String nombrePlataforma) {
		List<String> espectaculos;
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
		espectaculos = plataforma.listarEspectaculos();
		String[] espectaculos_string = new String[espectaculos.size()];
		int i=0;
		for(String nombre:espectaculos) {
			espectaculos_string[i]=nombre;
			i++;
		}
		return espectaculos_string;
	}
	
	@Override
	public String[] listarFunciones(String nombreEspectaculo) {
		List<String> funciones;
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = mE.buscarEspectaculo(nombreEspectaculo);
		funciones = espectaculo.getFunciones();
		String[] listaFunciones = new String[funciones.size()];
		int i=0;
		for(String f:funciones) {
			listaFunciones[i]=f;
			i++;
		}
		return listaFunciones;
	}


}
