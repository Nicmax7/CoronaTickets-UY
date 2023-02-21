package logica.controller;

import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import logica.datatypes.DTFuncionE;
import logica.entidades.Artista;
import logica.entidades.Espectaculo;
import logica.entidades.Funcion;
import logica.entidades.Plataforma;
import logica.excepciones.FuncionRepetidaException;
import logica.manejadores.ManejadorArtista;
import logica.manejadores.ManejadorEspectaculo;
import logica.manejadores.ManejadorPlataforma;
import logica.interfaces.IControladorAltaFuncionEspectaculo;

public class ControladorAltaFuncionEspectaculo implements IControladorAltaFuncionEspectaculo {

	@Override
	public String[] consultarEspectaculosPlataforma(String nombrePlataforma){
		List<String> e = new ArrayList<String>();
		
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		Plataforma p = new Plataforma();
		
		p = mP.buscarPlataforma(nombrePlataforma);
		e = p.listarEspectaculos();
		
		String[] ret = new String[e.size()];
		for(int i=0;i<e.size();i++) {
			ret[i] = e.get(i);
		}
		return ret;
	}
	
	@Override
	public List<String> consultaArtistas(){
		List<String> nombreArtistas = new ArrayList<>();
		ManejadorArtista mA = ManejadorArtista.getInstancia();
		nombreArtistas = mA.obtenerArtistas();
		return nombreArtistas;
	}
	
	@Override
	public void ingresarFuncionEspectaculo(DTFuncionE dtF) throws FuncionRepetidaException {
		ManejadorArtista mA = ManejadorArtista.getInstancia();
		Artista artistaAux = new Artista();
		//List<Artista> a = new ArrayList<>() ;
	
		ManejadorEspectaculo mE= ManejadorEspectaculo.getInstancia();
		Espectaculo e = new Espectaculo();
		Funcion f = new Funcion();
		
		e = mE.buscarEspectaculo(dtF.getNombreEspectaculo());
		f = e.buscarFuncion(dtF.getNombreFuncion());
		
		if(f != null) {
			throw new FuncionRepetidaException("Ya existe una función con el nombre: " + dtF.getNombreFuncion());
		}
		
		
		System.out.println(dtF.getFechaFunc()+ " " +  dtF.getFechaReg());
		DateTimeFormatter formatterFF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime fechaFunc = LocalDateTime.parse(dtF.getFechaFunc(), formatterFF);	
		
		DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaReg = LocalDate.parse(dtF.getFechaReg(), formatterFR);	
			
		f = new Funcion(dtF.getNombreFuncion(), fechaFunc, fechaReg);
		
		/*
		for(int i = 0; i < artistas.size(); i++) {
			artistaAux = mA.buscarArtista(artistas.get(i));
			artistaAux.agregarFuncion(f);
			a.add(artistaAux);	
		}
		*/
		
		f.setArtistas(dtF.getArtistas());
		e.agregarFuncion(f);
		
		mE.agregarFuncion(e);
	}
		
}
