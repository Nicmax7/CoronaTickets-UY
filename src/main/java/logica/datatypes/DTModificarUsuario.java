package logica.datatypes;

import java.time.LocalDate;

public class DTModificarUsuario {
	
	private String nickname;
	private String nombre;
	private String apellido;
	private String contrasenia;
	private LocalDate fechaNacimiento;

	public DTModificarUsuario(String nickname, String nombre, String apellido, String contrasenia, LocalDate fechaNacimiento) {
		super();
		this.nickname=nickname;
		this.nombre=nombre;
		this.apellido=apellido;
		this.contrasenia=contrasenia;
		this.fechaNacimiento=fechaNacimiento;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	
	
}
