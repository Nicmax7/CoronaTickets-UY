package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.datatypes.DTUsuarioWs;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAltaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class AltaUsuarioPublish {
	private Fabrica fabrica;
	private IControladorAltaUsuario iconAU;
	private Endpoint endpoint;
	
	public AltaUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconAU = fabrica.getIControladorAltaUsuario();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorAltaUsuario", this);
		System.out.println("http://127.0.0.1:12500/controladorAltaUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public int agregarUsuarioWs(DTUsuarioWs dtUsuario) throws NicknameRepetidoException, CorreoRepetidoException {
		int ret;
		try {
			iconAU.agregarUsuarioWS(dtUsuario); 
			ret = 0;
		} catch (NicknameRepetidoException e) {
			ret = 1;
		} catch (CorreoRepetidoException e) {
			ret = 2;
		}
		return ret;
	};
	
	
}
