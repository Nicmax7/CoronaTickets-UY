package logica.datatypes;

import java.time.LocalDate;

public class DTArtista extends DTUsuarioBasico {
	private String descripcion;
	private String biografia;
	private String link;
	
	public DTArtista(String nickname, String nombre, String apellido, LocalDate fechaNac, String mail,
			String descripcion, String biografia, String link, String contrasenia) {
		super(nickname, nombre, apellido, fechaNac, mail, contrasenia);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.link = link;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getLink() {
		return link;
	}
	
	public DTUsuarioBasico getDTUsuarioBasico() {
		return new DTArtista(this.getNickname(), this.getNombre(), this.getApellido(), this.getFechaNac(), this.getMail(),
			this.getDescripcion(), this.getBiografia(), this.getLink(), this.getContrasenia());
	}

}
