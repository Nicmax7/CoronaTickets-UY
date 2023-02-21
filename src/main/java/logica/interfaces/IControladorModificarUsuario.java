package logica.interfaces;

import logica.datatypes.DTModificarUsuario;

public interface IControladorModificarUsuario {
	
	public String[] listarUsuarios();
	public DTModificarUsuario consultarUsuario(String usuario);
	public void actualizarUsuario(DTModificarUsuario usuario);
}
