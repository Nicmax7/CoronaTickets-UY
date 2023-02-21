package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.entidades.Plataforma;
import persistencia.Conexion;

public class ManejadorPlataforma {
	
	private static ManejadorPlataforma instancia = null;
	
	private ManejadorPlataforma(){}
	
	public static ManejadorPlataforma getInstancia() {
		if (instancia == null)
			instancia = new ManejadorPlataforma();
		return instancia; 
	}

	public void agregarPlataforma(Plataforma plataforma) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(plataforma);
		em.getTransaction().commit();
	}
	
	public Plataforma buscarPlataforma(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Plataforma plataforma = em.find(Plataforma.class, nombre);
		return plataforma;
	}
	
	public ArrayList<String> obtenerPlataformas(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p from Plataforma p", Plataforma.class);	
		List<Plataforma> listPlataformas = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Plataforma p:listPlataformas) {
				aRetornar.add(p.getNombre());
		}		
		return aRetornar;
	}
	
	public List<String> obtenerEspectaculosPlataforma(String nombrePlataforma){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Plataforma plataforma = em.find(Plataforma.class, nombrePlataforma);
		List<String> espectaculoPlataforma = plataforma.listarEspectaculos();
		return espectaculoPlataforma;
	}


}
