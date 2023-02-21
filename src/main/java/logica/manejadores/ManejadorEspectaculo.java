package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.entidades.Espectaculo;
import logica.entidades.Plataforma;
import persistencia.Conexion;



public class ManejadorEspectaculo {

	private static ManejadorEspectaculo instancia = null;
	
	private ManejadorEspectaculo(){}
	
	public static ManejadorEspectaculo getInstancia() {
		if (instancia == null)
			instancia = new ManejadorEspectaculo();
		return instancia; 
	}

	public void agregarEspectaculo(Espectaculo espectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(espectaculo);
		em.getTransaction().commit();
	}
	
	public Espectaculo buscarEspectaculo(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Espectaculo espetaculo = em.find(Espectaculo.class, nombre);
		return espetaculo;
	}
	
	public void agregarFuncion(Espectaculo espectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		Espectaculo e = em.find(Espectaculo.class, espectaculo.getNombre());
		e = espectaculo;
		em.persist(e);
		em.getTransaction().commit();
	}
	
	
	public ArrayList<String> obtenerEspectaculos(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select e from Espectaculos e");	
		List<Espectaculo> listEspectaculos = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Espectaculo e:listEspectaculos) {
				aRetornar.add(e.getNombre());
		}		
		return aRetornar;
	}

	
	
	
	
}


