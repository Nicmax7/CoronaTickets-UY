package logica.controller;

import logica.datatypes.DTUsuarioLogin;
import logica.entidades.Artista;
import logica.entidades.Espectador;
import logica.entidades.Usuario;
import logica.interfaces.IControladorLogin;
import logica.manejadores.ManejadorUsuario;

public class ControladorLogin implements IControladorLogin {
	
	public DTUsuarioLogin logueoPorNickname(String nickname) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		DTUsuarioLogin dtUsuarioLogin = null; 
		Usuario usuario = mu.buscarUsuario(nickname);
		
		if(usuario==null) {
			dtUsuarioLogin= null;
		}else if(usuario instanceof Artista) {
			dtUsuarioLogin = new DTUsuarioLogin(usuario.getNickname(),usuario.getContrasenia(),"Artista");
		}else if(usuario instanceof Espectador) {
			dtUsuarioLogin = new DTUsuarioLogin(usuario.getNickname(),usuario.getContrasenia(),"Espectador");
		}
		return dtUsuarioLogin;
	}
	
	public DTUsuarioLogin logueoPorCorreo(String correo) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		DTUsuarioLogin dtUsuarioLogin = null;
		Usuario usuario = mu.buscarUsuarioPorCorreo(correo);
		
		if(usuario==null) {
			dtUsuarioLogin= null;
		}else if(usuario instanceof Artista) {
			dtUsuarioLogin = new DTUsuarioLogin(usuario.getNickname(),usuario.getContrasenia(),"Artista");
		}else if(usuario instanceof Espectador) {
			dtUsuarioLogin = new DTUsuarioLogin(usuario.getNickname(),usuario.getContrasenia(),"Espectador");
		}
		return dtUsuarioLogin;
		
	}

}
