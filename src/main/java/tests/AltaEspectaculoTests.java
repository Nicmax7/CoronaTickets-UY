package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectaculo;
import logica.datatypes.DTInfoEspectaculo;
import logica.datatypes.DTPlataforma;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.EspectaculoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.excepciones.PlataformaRepetidaException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorAltaPlataforma;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorConsultaEspectaculo;

public class AltaEspectaculoTests {
	
	Calendar dateTest= Calendar.getInstance();
	
	private static IControladorAltaEspectaculo iconAE;
	private static IControladorAltaUsuario iconAU;
	private static IControladorAltaPlataforma iconAP;
	private static IControladorConsultaEspectaculo iconCE;
	
	DTArtista dtA = new DTArtista("nickTest", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "email@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTPlataforma dtP = new DTPlataforma("nombreAgregarEspectaculo", "descripcionTest", "urlTest");
	DTEspectaculo dtE = new DTEspectaculo("nombreTest", "descripcionTest", "30", "urlTest", 40, 5, 10, dateTest);
	
	
	@Test
	 public void testAgregarEspectaculo() {
	    Fabrica fabrica = Fabrica.getInstancia();
	    iconAU = fabrica.getIControladorAltaUsuario();
	    iconAE = fabrica.getIControladorAltaEspectaculo();
	    iconAP = fabrica.getIControladorAltaPlataforma();
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
	    
	    DTInfoEspectaculo expectedEspectaculo = iconCE.consultaEspectaculo(dtE.getNombre());
	    assertEquals(expectedEspectaculo.getNombre(), dtE.getNombre());
	    assertEquals(expectedEspectaculo.getDescripcion(), dtE.getDescripcion());
	    assertEquals(expectedEspectaculo.getDuracion(), dtE.getDuracion());
	    assertEquals(expectedEspectaculo.getUrl(), dtE.getUrl());
	    assertEquals(expectedEspectaculo.getCosto(), dtE.getCosto(), 0);
	    assertEquals(expectedEspectaculo.getCantMin(), dtE.getCantMin());
	    assertEquals(expectedEspectaculo.getCantMax(), dtE.getCantMax());
	    assertEquals(expectedEspectaculo.getFechaRegistro(), dtE.getFechaRegistro().getTime());
	    //assertEquals(expectedEspectaculo.toString(), dtE.toString());
	    
	    String[] realPlataformas = iconAE.listarPlataformas();
	    String[] realArtistas = iconAE.listarArtistas();
	    
	    assertThat(Arrays.asList(realPlataformas), hasItems(dtP.getNombrePlataforma()));
	    assertThat(Arrays.asList(realArtistas), hasItems(dtA.getNickname()));
	    
	}
}
