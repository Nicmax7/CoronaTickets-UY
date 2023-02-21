package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import logica.datatypes.DTEspectador;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorSeguirUsuarios;

public class SeguirUsuariosTests {
	
	private static IControladorAltaUsuario iconAU;
	private static IControladorSeguirUsuarios iconSU;
	
	static DTEspectador dtE = new DTEspectador("nickTestSU", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "emailSU@test.com", "contraseniaTest");
	static DTEspectador dtE2 = new DTEspectador("nickTest2SU", "nombreTest2", "apellidoTest2",  LocalDate.of(2000,01,01), "email2SU@test.com", "contraseniaTest2");
	DTEspectador dtNoSeguido = new DTEspectador("nickTestNoSeguidoSU", "nombreTest", "apellidoTest2",  LocalDate.of(2000,01,01), "email3SU@test.com", "contraseniaTest2");
	
	@BeforeClass
	public static void before() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		iconAU = fabrica.getIControladorAltaUsuario();
		iconSU = fabrica.getIControladorSeguirUsuarios();
		
		//Agrego Usuarios
		try {
	    	iconAU.agregarUsuario(dtE);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
		
		try {
	    	iconAU.agregarUsuario(dtE2);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
	}
	
	@Test
	public void testSeguirAUsuario() {
		
		try {
	    	iconSU.seguirUsuario(dtE.getNickname(),dtE2.getNickname());
	    } catch (NullPointerException e) {
	      
	    }
		String [] seguidos = {dtE2.getNickname()};
		String[] expectedResult = iconSU.listarSeguidos(dtE.getNickname());
		assertArrayEquals(expectedResult, seguidos);
		
	}
	@Test
	public void testDejarSeguirAUsuario() {
		
		try {
	    	iconSU.dejarSeguirUsuario(dtE.getNickname(),dtE2.getNickname());
	    } catch (NullPointerException e) {
	      
	    }
		String [] noSeguidos = {dtE2.getNickname()};
		String[] expectedResult = iconSU.listarNoSeguidos(dtE.getNickname());
		assertArrayEquals(expectedResult, noSeguidos);
		
	}
}
