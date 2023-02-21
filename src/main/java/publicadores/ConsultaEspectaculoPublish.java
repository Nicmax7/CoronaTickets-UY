package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.datatypes.DTInfoEspectaculo;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorConsultaEspectaculo;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ConsultaEspectaculoPublish {
	private Fabrica fabrica;
	private IControladorConsultaEspectaculo iconCE;
	private Endpoint endpoint;
	
	public ConsultaEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		iconCE = fabrica.getIControladorConsultaEspectaculo();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorConsultaEspectaculo", this);
		System.out.println("http://127.0.0.1:12500/controladorConsultaEspectaculo");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DTInfoEspectaculo consultaEspectaculo(String nombreEspectaculo){
		return iconCE.consultaEspectaculo(nombreEspectaculo);
	};
	
	@WebMethod
	public String[] listarPlataformas() {
		return iconCE.listarPlataformas();
	};
	
	@WebMethod
	public String[] listarPaquetesDelEspectaculo(String nombreEspectaculo){
		return iconCE.listarPaquetesDelEspectaculo(nombreEspectaculo);
	};	
}
