package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.datatypes.DTEspectaculo;
import logica.excepciones.EspectaculoRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaEspectaculo;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class AltaEspectaculoPublish {
	private Fabrica fabrica;
	private IControladorAltaEspectaculo iconAE;
	private Endpoint endpoint;
	
	public AltaEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		iconAE = fabrica.getIControladorAltaEspectaculo();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorAltaEspectaculo", this);
		System.out.println("http://127.0.0.1:12500/controladorAltaEspectaculo");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public int agregarEspectaculo(String nombrePlataforma, String nombreArtista, DTEspectaculo dtEspectaculo) throws EspectaculoRepetidoException {
		int ret;
		try {
			iconAE.agregarEspectaculo(nombrePlataforma, nombreArtista, dtEspectaculo);
			ret = 0;
		} catch (EspectaculoRepetidoException e) {
			ret = 1;
		}
		return ret;
	};
	
	@WebMethod
	public String[] listarPlataformas() {
		return iconAE.listarPlataformas();
	};
	
	@WebMethod
	public String[] listarArtistas() {
		return iconAE.listarArtistas();
	};
	
}
