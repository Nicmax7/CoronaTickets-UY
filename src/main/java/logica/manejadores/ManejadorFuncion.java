package logica.manejadores;

import javax.persistence.EntityManager;

import logica.entidades.Funcion;
import persistencia.Conexion;

public class ManejadorFuncion {

	private static ManejadorFuncion instancia = null;
	
	private ManejadorFuncion(){}
	
	public static ManejadorFuncion getInstancia() {
		if (instancia == null)
			instancia = new ManejadorFuncion();
		return instancia; 
	}

	public Funcion buscarFuncion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Funcion funcion = em.find(Funcion.class, nombre);
		return funcion;
	}

}
