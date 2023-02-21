package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.datatypes.DTEspectaculo;
import logica.datatypes.DTFuncion;
import logica.datatypes.DTFuncionWS;
import logica.excepciones.EspectaculoRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorConsultaFuncion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ConsultaFuncionPublish {
	private Fabrica fabrica;
	private IControladorConsultaFuncion iconCF;
	private Endpoint endpoint;
	
	public ConsultaFuncionPublish() {
		fabrica = Fabrica.getInstancia();
		iconCF = fabrica.getIControladorConsultaFuncion();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorConsultaFuncion", this);
		System.out.println("http://127.0.0.1:12500/controladorConsultaFuncion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DTFuncionWS consultarFuncion(String nombreFuncion) {
		
		DTFuncion dtF = iconCF.consultarFuncion(nombreFuncion);
		DTFuncionWS dtWS = new DTFuncionWS();
		dtWS.setNombre(dtF.getNombre());
		dtWS.setFecha(dtF.getFecha().toString());
		dtWS.setFechaRegistro(dtF.getfechaRegistro().toString());
		dtWS.setHoraInicio(dtF.getHoraInicio().toString());
		
		return dtWS;
	};
	
	@WebMethod
	public String[] listarPlataformas() {
		return iconCF.listarPlataformas();
	};
	
	@WebMethod
	public String[] listarEspectaculos(String nombrePlataforma) {
		return iconCF.listarEspectaculos(nombrePlataforma);
	};
	
	@WebMethod
	public String[] listarFunciones(String nombreEspectaculo) {
		return iconCF.listarFunciones(nombreEspectaculo);
	};
	
}
