package logica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import logica.entidades.Espectaculo;
import logica.entidades.Paquete;
import logica.entidades.Plataforma;
import logica.excepciones.YaContieneEspectaculo;
import logica.interfaces.IControladorAgregarEspectaculoAPaquete;
import logica.manejadores.ManejadorEspectaculo;
import logica.manejadores.ManejadorPaquete;
import logica.manejadores.ManejadorPlataforma;
import persistencia.Conexion;

public class ControladorAgregarEspectaculoAPaquete implements IControladorAgregarEspectaculoAPaquete {

	@Override
	public void agregarEspectaculoAPaquete(String nombrePaquete, String nombreEspectaculo) throws YaContieneEspectaculo {
		ManejadorPaquete mP= ManejadorPaquete.getInstancia();
		Paquete p = mP.buscarPaquete(nombrePaquete);		
		ManejadorEspectaculo mE= ManejadorEspectaculo.getInstancia();
		Espectaculo e = mE.buscarEspectaculo(nombreEspectaculo);
		if(p.tieneEspectaculo(nombreEspectaculo)) {
			throw new YaContieneEspectaculo("Ya existe en el paquete un espectaculo con el nombre: " + nombreEspectaculo);			
		}
		else {
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			p.agregarEspectaculo(e);	
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}
	}
	
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
