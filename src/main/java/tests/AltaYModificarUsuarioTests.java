package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

import logica.datatypes.DTArtista;
import logica.datatypes.DTModificarUsuario;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorModificarUsuario;

public class AltaYModificarUsuarioTests {
	
	private static IControladorAltaUsuario iconAU;
	private static IControladorModificarUsuario iconMU;
	
	DTArtista dtA = new DTArtista("nickAltaUsuario", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "altaUsuario@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTArtista dtACorreoRepetido = new DTArtista("nickAltaUsuarioCorreoRepetido", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "altaUsuario@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTArtista dtANickNameRepetido = new DTArtista("nickAltaUsuario", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "altaUsuarioNoRepetido@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTModificarUsuario dtMU  = new DTModificarUsuario("nickAltaUsuario", "nombresito", "apellidito", "unaContrasenia", LocalDate.of(2000,01,01));
			
	@Test
	public void testAltaUsuario() {
	
		Fabrica fabrica = Fabrica.getInstancia();
	    iconAU = fabrica.getIControladorAltaUsuario();
	    iconMU = fabrica.getIControladorModificarUsuario();
	    
	    try {
	    	iconAU.agregarUsuario(dtA);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	
	    fail(e.getMessage());
	    e.printStackTrace();
	    }
	    
	    try {
	    	iconAU.agregarUsuario(dtANickNameRepetido);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	assertEquals(e.getMessage(),"Ya existe el nickname  en el sistema");
			e.printStackTrace();
	    }
	    
	    try {
	    	iconAU.agregarUsuario(dtACorreoRepetido);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	assertEquals(e.getMessage(),"Ya existe el correo  en el sistema");
			e.printStackTrace();
	    }
	

	    
	    String[] real = iconMU.listarUsuarios();
	    
	    
	    DTModificarUsuario usuarioReal = iconMU.consultarUsuario(dtA.getNickname());
	    
	    assertEquals(usuarioReal.getNickname(), dtA.getNickname());
	    assertEquals(usuarioReal.getNombre(), dtA.getNombre());
	    assertEquals(usuarioReal.getApellido(), dtA.getApellido());
	    assertEquals(usuarioReal.getContrasenia(), dtA.getContrasenia());
	    assertEquals(usuarioReal.getFechaNacimiento(), dtA.getFechaNac());
	    
	    iconMU.actualizarUsuario(dtMU);
	    
	    DTModificarUsuario usuarioModificado = iconMU.consultarUsuario(dtMU.getNickname());
	    
	    assertEquals(usuarioModificado.getNickname(), dtMU.getNickname());
	    assertEquals(usuarioModificado.getNombre(), dtMU.getNombre());
	    assertEquals(usuarioModificado.getApellido(), dtMU.getApellido());
	    assertEquals(usuarioModificado.getContrasenia(), dtMU.getContrasenia());
	    assertEquals(usuarioModificado.getFechaNacimiento(), dtMU.getFechaNacimiento());
	    
	   
	}
}
