package logica.datatypes;

import java.time.LocalDate;

public class DTEspectador extends DTUsuarioBasico {

	public DTEspectador(String nickname, String nombre, String apellido, LocalDate fechaNac, String mail, String contrasenia) {
		super(nickname, nombre, apellido, fechaNac, mail, contrasenia);
	}
	
}
