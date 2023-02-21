package logica.controller;

import java.util.ArrayList;
import java.util.Calendar;

import logica.datatypes.DTEspectaculo;
import logica.entidades.Artista;
import logica.entidades.Espectaculo;
import logica.entidades.Plataforma;
import logica.excepciones.EspectaculoRepetidoException;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.manejadores.ManejadorArtista;
import logica.manejadores.ManejadorEspectaculo;
import logica.manejadores.ManejadorPlataforma;

public class ControladorAltaEspectaculo implements IControladorAltaEspectaculo{

	@Override
	public void agregarEspectaculo(String nombrePlataforma, String nombreArtista, DTEspectaculo dtEspectaculo) throws EspectaculoRepetidoException{
		
		/* INICIALIZO LOS MANEJADORES */
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		ManejadorArtista mA = ManejadorArtista.getInstancia();
		
		Espectaculo espectaculo = mE.buscarEspectaculo(dtEspectaculo.getNombre());
		Plataforma plataforma = mP.buscarPlataforma(nombrePlataforma);
		Artista artista = mA.buscarArtista(nombreArtista); 
		
		/* EVALUO SI EL ESPECTACULO EXISTE */
		if(espectaculo != null) {
			throw new EspectaculoRepetidoException("Ya existe un espectaculo con el nombre: "+ dtEspectaculo.getNombre());
		}
		else {
			espectaculo = new Espectaculo(dtEspectaculo.getNombre(), dtEspectaculo.getDescripcion(), dtEspectaculo.getDuracion(), 
					dtEspectaculo.getUrl(), dtEspectaculo.getCosto(), dtEspectaculo.getCantMin(), dtEspectaculo.getCantMax(), dtEspectaculo.getFechaRegistro().getTime());
			
			plataforma.agregarEspectaculo(espectaculo);
			artista.organizarEspectaculo(espectaculo);
			mE.agregarEspectaculo(espectaculo);
		}	
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
	public String[] listarArtistas() {
		ArrayList<String> artistas;
		ManejadorArtista mA = ManejadorArtista.getInstancia();
		artistas = mA.obtenerArtistas();
		String[] artistas_ret = new String[artistas.size()];
        for(int i=0;i<artistas.size();i++) {
        	artistas_ret[i]=artistas.get(i);
        }
        return artistas_ret;
	}

}
