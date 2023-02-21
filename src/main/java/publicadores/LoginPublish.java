package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.datatypes.DTUsuarioLogin;
import logica.interfaces.Fabrica;
import logica.interfaces.IControladorLogin;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class LoginPublish {

	private Fabrica fabrica;
	private IControladorLogin iLogin;
	private Endpoint endpoint;
	
	public LoginPublish() {
		fabrica = Fabrica.getInstancia();
		iLogin = fabrica.getIControladorLogin();
	}
	
	@WebMethod(exclude=true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorLogin", this);
		System.out.println("http://127.0.0.1:12500/controladorLogin");
	}
	
	@WebMethod(exclude=true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod	
	public DTUsuarioLogin logueoPorNickname(String nickname) {
		return iLogin.logueoPorNickname(nickname);
	}
	
	@WebMethod
	public DTUsuarioLogin logueoPorCorreo(String correo) {
		return iLogin.logueoPorCorreo(correo);
	}
	
}
