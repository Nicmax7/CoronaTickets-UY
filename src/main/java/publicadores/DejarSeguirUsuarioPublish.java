
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
public class DejarSeguirUsuarioPublish {
	private Fabrica fabrica;
	private IControladorSeguirUsuarios iconDSU;
	private Endpoint endpoint;
	
	public DejarSeguirUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		iconDSU = fabrica.getIControladorSeguirUsuarios();
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:12500/controladorDejarSeguirUsuarios", this);
		System.out.println("http://127.0.0.1:12500/controladorDejarSeguirUsuarios");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public void dejarSeguirUsuario(String nombreUsuario, String nombreSeguido) {
		iconDSU.dejarSeguirUsuario(nombreUsuario, nombreSeguido);
	}
	
	
	@WebMethod
	public String[] listarNoSeguidos(String nombreUsuario) {
		return iconDSU.listarNoSeguidos(nombreUsuario);
	}
	
	
	@WebMethod
	public void seguirUsuario(String nombreUsuario, String nombreSeguido) {
		iconDSU.seguirUsuario(nombreUsuario, nombreSeguido);
	}
	
	@WebMethod
	public String[] listarSeguidos(String nombreUsuario) {
		return iconDSU.listarSeguidos(nombreUsuario);
	}
	
	
}