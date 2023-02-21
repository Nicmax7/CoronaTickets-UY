package logica.interfaces;

import logica.controller.ControladorAgregarEspectaculoAPaquete;
import logica.controller.ControladorAltaEspectaculo;
import logica.controller.ControladorAltaFuncionEspectaculo;
import logica.controller.ControladorAltaPaquete;
import logica.controller.ControladorAltaPlataforma;
import logica.controller.ControladorAltaUsuario;
import logica.controller.ControladorConsultaEspectaculo;
import logica.controller.ControladorConsultaPlataforma;
import logica.controller.ControladorLogin;
import logica.controller.ControladorConsultaFuncion;
import logica.controller.ControladorConsultaPaquete;
import logica.controller.ControladorModificarUsuario;
import logica.controller.ControladorSeguirUsuarios;



public class Fabrica {

	private static Fabrica instancia=null;
	private Fabrica() {}
	public static Fabrica getInstancia() {
		if(instancia==null)
			instancia= new Fabrica();
		return instancia;
	}
  
	public IControladorAltaUsuario getIControladorAltaUsuario(){
		return new ControladorAltaUsuario();
	}
	
	public IControladorAltaPlataforma getIControladorAltaPlataforma() {
		return new ControladorAltaPlataforma();
	}
	
	public IControladorAltaEspectaculo getIControladorAltaEspectaculo() {
		return new ControladorAltaEspectaculo();
	}
	
	public IControladorAltaFuncionEspectaculo getIControladorAltaFuncionEspectaculo(){
		return new ControladorAltaFuncionEspectaculo();
    }
	
	public IControladorConsultaPlataforma getIControladorConsultaPlataforma() {
		return new ControladorConsultaPlataforma();
	}
	
	public IControladorConsultaFuncion getIControladorConsultaFuncion() {
		return new ControladorConsultaFuncion();
	}

	public IControladorConsultaEspectaculo getIControladorConsultaEspectaculo() {
		return new ControladorConsultaEspectaculo();
	}
	
	public IControladorAltaPaquete getIControladorAltaPaquete() {
		return new ControladorAltaPaquete();
	}
	
	public IControladorAgregarEspectaculoAPaquete getIControladorAgregarEspectaculoAPaquete() {
		return new ControladorAgregarEspectaculoAPaquete();
	}
	
	public IControladorConsultaPaquete getIControladorConsultaPaquete() {
		return new ControladorConsultaPaquete();
	}
	
	public IControladorModificarUsuario getIControladorModificarUsuario() {
		return new ControladorModificarUsuario();
	}
	
	public IControladorLogin getIControladorLogin() {
		return new ControladorLogin();
	}
	
	public IControladorSeguirUsuarios getIControladorSeguirUsuarios() {
		return new ControladorSeguirUsuarios();
	}
}
