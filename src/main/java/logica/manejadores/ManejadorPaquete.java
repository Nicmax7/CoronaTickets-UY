package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.entidades.Paquete;
import persistencia.Conexion;

public class ManejadorPaquete {

	private static ManejadorPaquete instancia = null;
	private ManejadorPaquete(){}
	
	public static ManejadorPaquete getInstancia() {
		if (instancia == null)
			instancia = new ManejadorPaquete();
		return instancia; 
	}

	public void agregarPaquete(Paquete paquete) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(paquete);
		em.getTransaction().commit();
	}
	
	public Paquete buscarPaquete(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Paquete paquete = em.find(Paquete.class, nombre);
		return paquete;
	}
	
	public List<String> listarPaquetes() {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p from Paquete p");	
		List<Paquete> listPaquetes = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Paquete p:listPaquetes) {
				aRetornar.add(p.getNombre());
		}		
		return aRetornar;
	}

	public List<String> listarPaquetesDeEspectaculo(String nombreEspectaculo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p from Paquete p");	
		List<Paquete> listPaquetes = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Paquete p:listPaquetes) {
			if (p.tieneEspectaculo(nombreEspectaculo)) {
				aRetornar.add(p.getNombre());
			}
		}		
		return aRetornar;
	}
}
