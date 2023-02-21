package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

import logica.datatypes.DTArtista;
import logica.datatypes.DTUsuarioLogin;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorLogin;

public class LoginTests {
	
	private static IControladorAltaUsuario iconAU;
	private static IControladorLogin iconL;
	
	
	DTArtista dtA = new DTArtista("nickLogin", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "login@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTArtista dtA2 = new DTArtista("nickLogin2", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "login2@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	
	DTUsuarioLogin dtPorNickname= new DTUsuarioLogin(dtA.getNickname(), dtA.getContrasenia(), "Artista");
	DTUsuarioLogin dtPorCorreo= new DTUsuarioLogin(dtA2.getNickname(), dtA2.getContrasenia(), "Artista");
	
	@Test
	public void testLogin() {
	
		Fabrica fabrica = Fabrica.getInstancia();
	    iconAU = fabrica.getIControladorAltaUsuario();
	    iconL = fabrica.getIControladorLogin();
	    
	    try {
	    	iconAU.agregarUsuario(dtA);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	
	    fail(e.getMessage());
	    e.printStackTrace();
	    }
	    
	    try {
	    	iconAU.agregarUsuario(dtA2);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	
	    fail(e.getMessage());
	    e.printStackTrace();
	    }
	    
	    DTUsuarioLogin expectedPorNickname= iconL.logueoPorNickname(dtA.getNickname());
	    
	    DTUsuarioLogin expectedPorCorreo= iconL.logueoPorCorreo(dtA2.getMail());
	    
	    assertEquals(expectedPorNickname.getNickname(), dtPorNickname.getNickname());
	    assertEquals(expectedPorNickname.getContrasenia(), dtPorNickname.getContrasenia());
	    assertEquals(expectedPorNickname.getTipoUsuario(), dtPorNickname.getTipoUsuario());
	    
	    assertEquals(expectedPorCorreo.getNickname(), dtPorCorreo.getNickname());
	    assertEquals(expectedPorCorreo.getContrasenia(), dtPorCorreo.getContrasenia());
	    assertEquals(expectedPorCorreo.getTipoUsuario(), dtPorCorreo.getTipoUsuario());
	    
	}
	
}
