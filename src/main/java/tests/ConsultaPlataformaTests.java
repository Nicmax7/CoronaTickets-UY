package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

import logica.datatypes.DTPlataforma;
import logica.excepciones.PaqueteRepetidoException;
import logica.excepciones.PlataformaRepetidaException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaPlataforma;
import logica.interfaces.IControladorConsultaPlataforma;

public class ConsultaPlataformaTests {
	
	static IControladorConsultaPlataforma iconCP;
	static IControladorAltaPlataforma iconAP;
	
	
	DTPlataforma dtP = new DTPlataforma("nombreConsultaPlataforma", "descripcionTest", "urlTest");
	

	
	@Test
	 public void testConsultaPlataforma() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		iconCP = fabrica.getIControladorConsultaPlataforma();
		iconAP = fabrica.getIControladorAltaPlataforma();
		
		
		 try {
			iconAP.agregarPlataforma(dtP);
		 } catch (PlataformaRepetidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		String[] resultado = iconCP.listarPlataformas(); 
		assertThat(Arrays.asList(resultado), hasItems(dtP.getNombrePlataforma()));
		
	        
	}
	
	@Test
	public void testPlataformaRepetida() {
		 try {
				iconAP.agregarPlataforma(dtP);
			 } catch (PlataformaRepetidaException e) {
				// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"La Plataforma " + dtP.getNombrePlataforma() + " ya esta registrada");
				e.printStackTrace();
			 }
	}
}
