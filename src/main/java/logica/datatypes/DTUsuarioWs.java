package logica.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuarioWs {

	private String tipoUser;
	private String nickname;
	private String nombre;
	private String apellido;
	private String fechaNac;
	private String mail;
	private String contrasenia;
	private String biografia;
	private String descripcion;
	private String link;
	
	public DTUsuarioWs() {
		super();
	}	
	
public DTUsuarioWs(String tipoUser, String nickname, String nombre, String apellido, String fechaNac, String mail, String contrasenia, String bio, String link, String desc) {
		super();
		this.tipoUser = tipoUser;
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.biografia = bio;
		this.link = link;
		this.descripcion = desc;
		
	}

	public String getTipoUser() {
		return tipoUser;
	}

	public String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMail() {
		return mail;
	}

	public String getFechaNac() {
		return fechaNac;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}	
	
}
