package logica.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import logica.entidades.Usuario;
import logica.interfaces.IControladorSeguirUsuarios;
import logica.manejadores.ManejadorPlataforma;
import logica.manejadores.ManejadorUsuario;

public class ControladorSeguirUsuarios implements IControladorSeguirUsuarios {
	
	@Override
	public void seguirUsuario(String nombreUsuario, String nombreSeguido) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario base = mU.buscarUsuario(nombreUsuario);
		Usuario seguido = mU.buscarUsuario(nombreSeguido);
		
		List<Usuario> s = new ArrayList<>();
		s = base.getSeguidos();
		s.add(seguido);
		
		base.setSeguidos(s);
		mU.actualizarSeguidos(base);
	}
	
	@Override
	public void dejarSeguirUsuario(String nombreUsuario, String nombreSeguido) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario base = mU.buscarUsuario(nombreUsuario);
		Usuario seguido = mU.buscarUsuario(nombreSeguido);
		
		List<Usuario> s = new ArrayList<>();
		s = base.getSeguidos();
		s.remove(seguido);
		
		base.setSeguidos(s);	
		mU.actualizarSeguidos(base);
	}
	
	@Override
	public String[] listarSeguidos(String nombreUsuario) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<String> s;
		s = mU.obtenerSeguidos(nombreUsuario);
		String[] usuarios = new String[s.size()];
		int i=0;
		for(String aux:s) {
			usuarios[i] =aux;
			i++;
		}
		return usuarios;		
	}

	@Override
	public String[] listarNoSeguidos(String nombreUsuario) {		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		//obtengo seguidos
		List<String> s;
		s = mU.obtenerSeguidos(nombreUsuario);
		//obtengo todos los usuarios
		ArrayList<String> u;
		u = mU.obtenerUsuarios();
		
		//resto total-seguidos-nombreUsuario
		String[] noSeguidos = new String[u.size()-s.size()-1];
		
		int z=0;
		for(String aux:u) {
			if(!s.contains(aux) && !aux.equals(nombreUsuario)) {
				noSeguidos[z] = aux;
				//System.out.println(aux);
				z++;
			}
		}				
		return noSeguidos;		
	}
}



