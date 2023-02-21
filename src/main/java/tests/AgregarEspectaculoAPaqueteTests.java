package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.Test;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectaculo;
import logica.datatypes.DTPaquete;
import logica.datatypes.DTPlataforma;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.EspectaculoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.excepciones.PaqueteRepetidoException;
import logica.excepciones.PlataformaRepetidaException;
import logica.excepciones.YaContieneEspectaculo;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAgregarEspectaculoAPaquete;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorAltaPaquete;
import logica.interfaces.IControladorAltaPlataforma;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorConsultaEspectaculo;
import logica.interfaces.IControladorConsultaPaquete;

public class AgregarEspectaculoAPaqueteTests {

	LocalDate dateLocalDate= LocalDate.of(2020, 12, 31);
	Calendar dateTest= Calendar.getInstance();
	
	private static IControladorAltaPaquete iconAPa;
	private static IControladorAltaEspectaculo iconAE;
	private static IControladorAltaUsuario iconAU;
	private static IControladorAltaPlataforma iconAP;
	private static IControladorAgregarEspectaculoAPaquete iconAEP;
	private static IControladorConsultaPaquete iconCP;
	private static IControladorConsultaEspectaculo iconCE;
	
	DTPaquete dtPa = new DTPaquete("nombreAgregarEspectaculoAPaquete", "descripcionAgregarEspectaculoAPaquete", dateLocalDate, dateLocalDate, 5);
	DTArtista dtA = new DTArtista("nickAgregarEspectaculoAPaquete", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "nickAgregarEspectaculoAPaquete@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTPlataforma dtP = new DTPlataforma("nombreAgregarEspectaculoAPaquete", "descripcionTest", "urlTest");
	DTEspectaculo dtE = new DTEspectaculo("nombreAgregarEspectaculoAPaquete", "descripcionTest", "30", "urlTest", 40, 5, 10, dateTest);
	
	
	@Test
	 public void testAgregarEspectaculoAPaquete() {
	    
		Fabrica fabrica = Fabrica.getInstancia();
	    iconAU = fabrica.getIControladorAltaUsuario();
	    iconAE = fabrica.getIControladorAltaEspectaculo();
	    iconAP = fabrica.getIControladorAltaPlataforma();
	    iconAPa = fabrica.getIControladorAltaPaquete();
	    iconAEP = fabrica.getIControladorAgregarEspectaculoAPaquete();
	    iconCP = fabrica.getIControladorConsultaPaquete();
	    iconCE = fabrica.getIControladorConsultaEspectaculo();
	    
	    try {
	    	iconAU.agregarUsuario(dtA);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	
	    fail(e.getMessage());
	    e.printStackTrace();
	    }
	    
	    //Agrego Plataforma
	    try {
	      iconAP.agregarPlataforma(dtP);
	    } catch (PlataformaRepetidaException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
	    
	    //Agrego Espectaculo
	    try {
	    	iconAE.agregarEspectaculo(dtP.getNombrePlataforma(), dtA.getNombre(), dtE );
	    } catch (EspectaculoRepetidoException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
	    //Agrego Paquete
	    try {
			iconAPa.agregarPaquete(dtPa);
		 } catch (PaqueteRepetidoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		 }
	    
	  //Agrego Espectaculo A Paquete
	    try {
			iconAEP.agregarEspectaculoAPaquete(dtPa.getNombre(), dtE.getNombre());
		 } catch (YaContieneEspectaculo e) {

			e.printStackTrace();
			fail(e.getMessage());
		 }
	    
	    try {
			iconAEP.agregarEspectaculoAPaquete(dtPa.getNombre(), dtE.getNombre());
		 } catch (YaContieneEspectaculo e) {

			assertEquals(e.getMessage(),"Ya existe en el paquete un espectaculo con el nombre: " + dtE.getNombre());
			e.printStackTrace();
		 }
	    
	    
	    String [] expectedEspectaculos = {dtE.getNombre()};
	    String [] expectedPaquetes = {dtPa.getNombre()};
	    
	    String [] real = iconCP.obtenerEspectaculosPaquete(dtPa.getNombre());
	    assertArrayEquals(expectedEspectaculos, real);
	    
	    String [] real2 = iconCE.listarPaquetesDelEspectaculo(dtE.getNombre());
	    assertArrayEquals(expectedPaquetes, real2);
	    
	    String [] real3= iconAEP.consultarEspectaculosPlataforma(dtP.getNombrePlataforma());
	    assertArrayEquals(expectedEspectaculos, real3);
	    
	    String [] real4= iconAEP.listarPaquetes();
	    assertArrayEquals(expectedPaquetes, real4);
	    
	    String [] real5= iconCP.listarPaquetes();
	    assertArrayEquals(expectedPaquetes, real5);
	    
	    
	}
}
