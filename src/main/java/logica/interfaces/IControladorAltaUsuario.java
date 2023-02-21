package logica.interfaces;

import logica.datatypes.DTUsuarioBasico;
import logica.datatypes.DTUsuarioWs;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;

public interface IControladorAltaUsuario {
	public void agregarUsuario(DTUsuarioBasico dtUsuario) throws NicknameRepetidoException, CorreoRepetidoException;
	public void agregarUsuarioWS(DTUsuarioWs dtUsuario) throws NicknameRepetidoException, CorreoRepetidoException;

}
