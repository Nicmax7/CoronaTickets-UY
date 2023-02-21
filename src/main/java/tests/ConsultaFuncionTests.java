package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectaculo;
import logica.datatypes.DTFuncion;
import logica.datatypes.DTFuncionE;
import logica.datatypes.DTFuncionWS;
import logica.datatypes.DTPlataforma;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.EspectaculoRepetidoException;
import logica.excepciones.FuncionRepetidaException;
import logica.excepciones.NicknameRepetidoException;
import logica.excepciones.PlataformaRepetidaException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorAltaFuncionEspectaculo;
import logica.interfaces.IControladorAltaPlataforma;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorConsultaFuncion;

public class ConsultaFuncionTests {
	
	Calendar dateTest= Calendar.getInstance();
	LocalDate dateLocalDate= LocalDate.of(2020, 12, 31);
	LocalTime horaInicioTest = LocalTime.of(10,10);
	LocalDateTime dateLocalDateTime= LocalDateTime.of(dateLocalDate, horaInicioTest);
	
	
	
	
	static IControladorAltaPlataforma iconAP;
	static IControladorConsultaFuncion iconCF;
	static IControladorAltaEspectaculo iconAE;
	static IControladorAltaUsuario iconAU;
	static IControladorAltaFuncionEspectaculo iconAF;
	
	DTPlataforma dtP = new DTPlataforma("nombreConsultaFuncion", "descripcionTest", "urlTest");
	DTEspectaculo dtE1 = new DTEspectaculo("nombreConsultaFuncion1", "descripcionTest", "30", "urlTest", 40, 5, 10, dateTest);
	DTEspectaculo dtE2 = new DTEspectaculo("nombreConsultaFuncion2", "descripcionTest", "30", "urlTest", 40, 5, 10, dateTest);
	DTEspectaculo dtE3 = new DTEspectaculo("nombreConsultaFuncion3", "descripcionTest", "30", "urlTest", 40, 5, 10, dateTest);
	DTArtista dtA = new DTArtista("nickTestConsultaFuncion", "nombreTest", "apellidoTest",  LocalDate.of(2000,01,01), "emailCF@test.com","descripcionTest", "biografiaTest", "linkTest", "contraseniaTest");
	DTFuncionE dtF = new DTFuncionE("nombreConsultaFuncion", dateLocalDateTime.toString(), dateLocalDate.toString(), dtE1.getNombre(), dtA.getNombre());
	DTFuncionE dtF2 = new DTFuncionE("nombreConsultaFuncion2", dateLocalDateTime.toString(), dateLocalDate.toString(), dtE1.getNombre(), dtA.getNombre());
	DTFuncionE dtF3 = new DTFuncionE("nombreConsultaFuncion3", dateLocalDateTime.toString(), dateLocalDate.toString(), dtE1.getNombre(), dtA.getNombre());


	
	@Test
	public void testConsultaFuncion() {
		Fabrica fabrica = Fabrica.getInstancia();
		iconAP = fabrica.getIControladorAltaPlataforma();
		iconAE = fabrica.getIControladorAltaEspectaculo();
		iconAU = fabrica.getIControladorAltaUsuario();
		iconCF = fabrica.getIControladorConsultaFuncion();
		iconAF = fabrica.getIControladorAltaFuncionEspectaculo();
		
		try {
	    	iconAU.agregarUsuario(dtA);
	    } catch (NicknameRepetidoException | CorreoRepetidoException e) {
	    	
	    fail(e.getMessage());
	    e.printStackTrace();
	    }
		
		try {
			iconAP.agregarPlataforma(dtP);
		} catch (PlataformaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		try {
	    	iconAE.agregarEspectaculo(dtP.getNombrePlataforma(), dtA.getNombre(), dtE1 );
	    	iconAE.agregarEspectaculo(dtP.getNombrePlataforma(), dtA.getNombre(), dtE2 );
	    	iconAE.agregarEspectaculo(dtP.getNombrePlataforma(), dtA.getNombre(), dtE3 );
	    	
	    } catch (EspectaculoRepetidoException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
		
		try {
	    	iconAF.ingresarFuncionEspectaculo(dtF);
	    	iconAF.ingresarFuncionEspectaculo(dtF2);
	    	iconAF.ingresarFuncionEspectaculo(dtF3);
	    } catch (FuncionRepetidaException e) {
	      fail(e.getMessage());
	      e.printStackTrace();
	    }
		
		//Test Consultar Funcion
		DTFuncion resultadoConsultarFuncion = iconCF.consultarFuncion(dtF.getNombreFuncion());
		assertEquals(resultadoConsultarFuncion.getNombre(), dtF.getNombreFuncion());
		assertEquals(resultadoConsultarFuncion.getFecha().toString() + "T" + resultadoConsultarFuncion.getHoraInicio().toString() , dtF.getFechaFunc());
		assertEquals(resultadoConsultarFuncion.getfechaRegistro().toString(), dtF.getFechaReg());
		//assertEquals(resultadoConsultarFuncion.toString(), dtF.toString());
		
		//Test Listar Plataformas
		String[] resultado = iconCF.listarPlataformas(); 
		assertThat(Arrays.asList(resultado), hasItems(dtP.getNombrePlataforma()));
		
		//Test Listar Espectaculos
		
		String[] resultadoListarEspectaculos = iconCF.listarEspectaculos(dtP.getNombrePlataforma()); 
		assertThat(Arrays.asList(resultadoListarEspectaculos), hasItems(dtE1.getNombre(),dtE2.getNombre(),dtE3.getNombre()));
		
		//Test Listar Funciones
		String[] resultadoListarFunciones = iconCF.listarFunciones(dtE1.getNombre()); 
		assertThat(Arrays.asList(resultadoListarFunciones), hasItems(dtF.getNombreFuncion(),dtF2.getNombreFuncion(),dtF3.getNombreFuncion()));
		
		try {
	    	iconAF.ingresarFuncionEspectaculo(dtF);
	    } catch (FuncionRepetidaException e) {
	    	assertEquals(e.getMessage(),"Ya existe una función con el nombre: " + dtF.getNombreFuncion());
	    	e.printStackTrace();
	    }
	
	}
}
