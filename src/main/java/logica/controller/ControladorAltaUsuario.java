package logica.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectador;
import logica.datatypes.DTUsuarioBasico;
import logica.datatypes.DTUsuarioWs;
import logica.entidades.Artista;
import logica.entidades.Espectador;
import logica.entidades.Usuario;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.IControladorAltaUsuario;
import logica.manejadores.ManejadorUsuario;

public class ControladorAltaUsuario implements IControladorAltaUsuario {

	@Override
	public void agregarUsuario(DTUsuarioBasico dtUsuario) throws NicknameRepetidoException, CorreoRepetidoException {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		Usuario usuario = mu.buscarUsuario(dtUsuario.getNickname());
		if( usuario != null) {
			throw new NicknameRepetidoException("Ya existe el nickname  en el sistema");   
		}
		
		Boolean existeUsuarioPorCorreo;
		existeUsuarioPorCorreo = mu.obtenerUsuarioPorCorreo(dtUsuario.getMail());
		if(existeUsuarioPorCorreo) {
			throw new CorreoRepetidoException("Ya existe el correo  en el sistema");   
		}
		
		if(dtUsuario instanceof DTEspectador) {
			usuario = new Espectador(dtUsuario.getNickname(),dtUsuario.getNombre(),dtUsuario.getApellido(),dtUsuario.getFechaNac(),dtUsuario.getMail(), dtUsuario.getContrasenia());
		}
		
		if(dtUsuario instanceof DTArtista) {
			usuario = new Artista(dtUsuario.getNickname(),dtUsuario.getNombre(),dtUsuario.getApellido(),dtUsuario.getFechaNac(),dtUsuario.getMail(),((DTArtista)dtUsuario).getDescripcion(),((DTArtista)dtUsuario).getBiografia(),((DTArtista)dtUsuario).getLink(), dtUsuario.getContrasenia());
		}
		
		mu.agregarUsuario(usuario);
		
	}
	
	
	@Override
	public void agregarUsuarioWS(DTUsuarioWs dtUsuario) throws NicknameRepetidoException, CorreoRepetidoException {
		System.out.println("llego agregar usu");

		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		Usuario usuario = mu.buscarUsuario(dtUsuario.getNickname());
		if( usuario != null) {
			throw new NicknameRepetidoException("Ya existe el nickname  en el sistema");   
		}
		
		Boolean existeUsuarioPorCorreo;
		existeUsuarioPorCorreo = mu.obtenerUsuarioPorCorreo(dtUsuario.getMail());
		if(existeUsuarioPorCorreo) {
			throw new CorreoRepetidoException("Ya existe el correo  en el sistema");   
		}
		
		//convierto string a fecha
		DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fechaNac = LocalDate.parse(dtUsuario.getFechaNac(), formatterFR);
		System.out.println(fechaNac);
		
		if(dtUsuario.getTipoUser().equals("artista")) {
			System.out.println("entro artista");

			usuario = new Artista(dtUsuario.getNickname(), dtUsuario.getNombre(), dtUsuario.getApellido(), fechaNac, dtUsuario.getMail(), dtUsuario.getDescripcion(), dtUsuario.getBiografia(), dtUsuario.getLink(), dtUsuario.getContrasenia());
		} else {
			usuario = new Espectador(dtUsuario.getNickname(), dtUsuario.getNombre(), dtUsuario.getApellido(), fechaNac, dtUsuario.getMail(), dtUsuario.getContrasenia());
		}
	
		mu.agregarUsuario(usuario);
		
	}
}


