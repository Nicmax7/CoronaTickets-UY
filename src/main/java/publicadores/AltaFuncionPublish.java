package publicadores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.excepciones.FuncionRepetidaException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaFuncionEspectaculo;
import logica.datatypes.DTFuncion;
import logica.datatypes.DTFuncionE;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
	public class AltaFuncionPublish {
	private Fabrica fabrica;
	private IControladorAltaFuncionEspectaculo iconAF;
	private Endpoint endpoint;
	
	public AltaFuncionPublish() {
		fabrica = Fabrica.getInstancia();
		iconAF = fabrica.getIControladorAltaFuncionEspectaculo();
		
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorAltaFuncion", this);
		System.out.println("http://127.0.0.1:12500/controladorAltaFuncion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public int agregarFuncion(DTFuncionE dtf)throws FuncionRepetidaException{
		int ret;
		try {
			iconAF.ingresarFuncionEspectaculo(dtf);
			ret = 0;
		} catch (FuncionRepetidaException e) {
			ret = 1;
		}
		return ret;
	};
	
	@WebMethod
	public String[] listarArtistas() {
		List<String> aux = iconAF.consultaArtistas();
		String[] ret = null;
		int i = 0;
		for(String u:aux) {
			ret[i] = u.toString();
			i++;
		}
		return ret;
	};
	
	@WebMethod
	public String[] listarEspectaculosPlataforma(String nombrePlataforma) {
		String[] ret = iconAF.consultarEspectaculosPlataforma(nombrePlataforma); 
		return ret;
	};
	
}
