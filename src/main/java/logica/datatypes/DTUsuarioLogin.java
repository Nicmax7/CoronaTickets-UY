package logica.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuarioLogin {

	private String nickname;
	private String contrasenia;
	private String tipoUsuario;
	
	public DTUsuarioLogin() {
		super();
	}

	public DTUsuarioLogin(String nickname, String contrasenia, String tipoUsuario) {
		super();
		this.nickname = nickname;
		this.contrasenia = contrasenia;
		this.tipoUsuario = tipoUsuario;
	}

	public String getNickname() {
		return nickname;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	
	
	
}
