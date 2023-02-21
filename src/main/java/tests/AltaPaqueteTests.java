package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

import logica.datatypes.DTPaquete;
import logica.excepciones.PaqueteRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaPaquete;
import logica.interfaces.IControladorConsultaPaquete;

public class AltaPaqueteTests {
	
	LocalDate dateLocalDate= LocalDate.of(2020, 12, 31);
	
	static IControladorAltaPaquete iconAP;
	static IControladorConsultaPaquete iconCP;
	
	DTPaquete dtP = new DTPaquete("nombreAltaPaquete", "descripcionAltaPaquete", dateLocalDate, dateLocalDate, 5);
	
	
	@Test
	public void testAltaPaquete() {
		
		Fabrica fabrica = Fabrica.getInstancia();
		iconAP = fabrica.getIControladorAltaPaquete();
		iconCP = fabrica.getIControladorConsultaPaquete();

		 try {
			iconAP.agregarPaquete(dtP);
		 } catch (PaqueteRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		 }
		 
	DTPaquete resultadoPaquete= iconCP.infoPaquete(dtP.getNombre());
	assertEquals(resultadoPaquete.getNombre(), dtP.getNombre());
	assertEquals(resultadoPaquete.getDescripcion(), dtP.getDescripcion());
	assertEquals(resultadoPaquete.getFechaInicio(), dtP.getFechaInicio());
	assertEquals(resultadoPaquete.getFechaFin(), dtP.getFechaFin());
	assertEquals(resultadoPaquete.getDescuento(), dtP.getDescuento());
	assertEquals(resultadoPaquete.toString(), dtP.toString());
	
	}
	
	@Test
	public void testPaqueteRepetido(){
		
		
		 try {
				iconAP.agregarPaquete(dtP);
			 } catch (PaqueteRepetidoException e) {
				// TODO Auto-generated catch block
				assertEquals(e.getMessage(),"Ya existe un paquete con el nombre: nombreAltaPaquete");
				e.printStackTrace();
			 }
		
	}
}
