package logica.interfaces;

import logica.datatypes.DTUsuarioLogin;

public interface IControladorLogin {
	
	public DTUsuarioLogin logueoPorNickname(String nickname);
	public DTUsuarioLogin logueoPorCorreo(String correo);

}
