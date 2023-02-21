package logica.entidades;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Espectador")
public class Espectador extends Usuario {

	public Espectador() {
		super();
	}
	
	public Espectador(String nickname, String nombre, String apellido, LocalDate fechaNac, String mail, String contrasenia) {
		super(nickname, nombre, apellido, fechaNac, mail, contrasenia);
	}

}
