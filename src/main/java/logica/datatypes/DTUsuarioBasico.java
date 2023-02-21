package logica.datatypes;

import java.time.LocalDate;

public abstract class DTUsuarioBasico {
	
	private String nickname;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String mail;
	private String contrasenia;
	
	public DTUsuarioBasico(String nickname, String nombre, String apellido, LocalDate fechaNac, String mail, String contrasenia) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.mail = mail;
		this.contrasenia = contrasenia;
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

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	@Override
	public String toString() {
		return "DTUsuarioBasico [" + (nickname != null ? "nickname=" + nickname + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellido != null ? "apellido=" + apellido + ", " : "")
				+ ((fechaNac != null ? "fechaNac=" + fechaNac + ", " : "" ) + (mail != null ? "mail=" + mail : "")
				+ "]");
	}
	
	
}
