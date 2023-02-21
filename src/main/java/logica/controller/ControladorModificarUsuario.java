package logica.controller;

import java.util.ArrayList;

import logica.datatypes.DTModificarUsuario;
import logica.entidades.Usuario;
import logica.interfaces.IControladorModificarUsuario;
import logica.manejadores.ManejadorUsuario;

public class ControladorModificarUsuario implements IControladorModificarUsuario {

	public ControladorModificarUsuario() {
		super();
	}
	
	@Override
	public String[] listarUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		ArrayList<String> p;
		p = mU.obtenerUsuarios();
		String[] usuarios = new String[p.size()];
		int i=0;
		for(String aux:p) {
			usuarios[i] =aux;
			i++;
		}
		return usuarios;		
	}

	@Override
	public DTModificarUsuario consultarUsuario(String usuario) {
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario usuarioRetorno = mU.buscarUsuario(usuario);
		
		DTModificarUsuario dtUsuario;
		
		dtUsuario = new DTModificarUsuario(usuarioRetorno.getNickname(), usuarioRetorno.getNombre(), usuarioRetorno.getApellido(), usuarioRetorno.getContrasenia(), usuarioRetorno.getfechaNac());
		
		return dtUsuario;
	}

	@Override
	public void actualizarUsuario(DTModificarUsuario usuario) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.actualizarUsuario(usuario);	
	}

}
