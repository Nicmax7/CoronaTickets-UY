package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import logica.interfaces.Fabrica;
import logica.interfaces.IControladorSeguirUsuarios;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class SeguirAUsuarioPublish {
	private Fabrica fabrica;
	private IControladorSeguirUsuarios iconSU;
	private Endpoint endpoint;
	
	public SeguirAUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconSU = fabrica.getIControladorSeguirUsuarios();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorSeguirUsuarios", this);
		System.out.println("http://127.0.0.1:12500/controladorSeguirUsuarios");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public void seguirUsuario(String nombreUsuario, String nombreSeguido) {
		iconSU.seguirUsuario(nombreUsuario, nombreSeguido);
	}
	
	@WebMethod
	public String[] listarSeguidos(String nombreUsuario) {
		return iconSU.listarSeguidos(nombreUsuario);
	}
	
	
	@WebMethod
	public void dejarSeguirUsuario(String nombreUsuario, String nombreSeguido) {
		iconSU.dejarSeguirUsuario(nombreUsuario, nombreSeguido);
	}

	@WebMethod
	public String[] listarNoSeguidos(String nombreUsuario) {
		return iconSU.listarNoSeguidos(nombreUsuario);
	}
	
	
}

