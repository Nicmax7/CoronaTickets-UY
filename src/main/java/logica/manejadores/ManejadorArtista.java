package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.entidades.Artista;
import logica.entidades.Usuario;
import persistencia.Conexion;

public class ManejadorArtista {
	private static ManejadorArtista instancia = null;
	
	private ManejadorArtista(){}
	
	public static ManejadorArtista getInstancia() {
		if (instancia == null)
			instancia = new ManejadorArtista();
		return instancia; 
	}

	public ArrayList<String> obtenerArtistas(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u", Usuario.class);	
		List<Usuario> listArtistas = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Usuario u:listArtistas) {
			if(u instanceof Artista) {
				aRetornar.add(u.getNickname());
			}
		}		
		return aRetornar;
	}
	public Artista buscarArtista(String nombreArtista){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u", Usuario.class);	
		List<Usuario> listArtistas = query.getResultList();
		Artista artista = null;
		for(Usuario u:listArtistas) {
			if(u instanceof Artista) {
				if(u.getNickname().equals(nombreArtista));
					artista = (Artista) u;
			}
		}		
		return artista;
	}
}
