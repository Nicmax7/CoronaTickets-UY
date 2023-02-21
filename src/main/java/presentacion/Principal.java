package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.interfaces.Fabrica;
import logica.interfaces.IControladorAgregarEspectaculoAPaquete;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorAltaFuncionEspectaculo;
import logica.interfaces.IControladorAltaPaquete;
import logica.interfaces.IControladorAltaPlataforma;
import logica.interfaces.IControladorAltaUsuario;
import logica.interfaces.IControladorConsultaEspectaculo;
import logica.interfaces.IControladorConsultaFuncion;
import logica.interfaces.IControladorConsultaPaquete;
import logica.interfaces.IControladorConsultaPlataforma;
import logica.interfaces.IControladorModificarUsuario;
import publicadores.AltaEspectaculoPublish;
import publicadores.AltaFuncionPublish;
import publicadores.AltaUsuarioPublish;

import publicadores.ConsultaEspectaculoPublish;
import publicadores.ConsultaFuncionPublish;
import publicadores.DejarSeguirUsuarioPublish;
import publicadores.LoginPublish;
import publicadores.SeguirAUsuarioPublish;

import java.awt.Dimension;
import java.awt.Rectangle;


public class Principal {

	private JFrame frmCoronaticketsuyPantalla;
	
	private AltaUsuario altaUsuarioInternalFrame;
	private AltaEspectaculo altaEspectaculoInternalFrame;
	private AltaFuncionEspectaculo altaFuncionEspectaculoInternalFrame;
	private AltaPlataforma altaPlataformaInternalFrame;
	private ConsultaFuncionEspectaculo consultaFuncionEspectaculoInternalFrame;
	private ConsultaEspectaculo consultaEspectaculoInternalFrame;
	private AltaPaquete AltaPaqueteInternalFrame;
	private AgregarEspectaculoAPaquete AgregarEspectaculoAPaqueteInternalFrame;
	private ConsultaPaquete ConsultaPaqueteInternalFrame;
	private ModificarUsuario ModificarUsuarioInternalFrame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmCoronaticketsuyPantalla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		Fabrica fabrica= Fabrica.getInstancia();
		
		IControladorAltaUsuario iconAltaUsuario = fabrica.getIControladorAltaUsuario();
		IControladorAltaEspectaculo iconAE = fabrica.getIControladorAltaEspectaculo();
		IControladorAltaFuncionEspectaculo iconAFE = fabrica.getIControladorAltaFuncionEspectaculo();
		IControladorAltaPlataforma iconAP = fabrica.getIControladorAltaPlataforma();
		IControladorConsultaFuncion iconCF = fabrica.getIControladorConsultaFuncion();
		IControladorConsultaPlataforma iconCP = fabrica.getIControladorConsultaPlataforma();
		IControladorConsultaEspectaculo iconCE = fabrica.getIControladorConsultaEspectaculo();
		IControladorAltaPaquete iconAPaquete = fabrica.getIControladorAltaPaquete();
		IControladorAgregarEspectaculoAPaquete iconAEP = fabrica.getIControladorAgregarEspectaculoAPaquete();
		IControladorConsultaPaquete iconCPaq = fabrica.getIControladorConsultaPaquete();
		IControladorModificarUsuario iconMU = fabrica.getIControladorModificarUsuario();
		
		//Publicaciones de WebServices
		AltaEspectaculoPublish ae = new AltaEspectaculoPublish();
		ae.publicar();
		AltaFuncionPublish af = new AltaFuncionPublish();
		af.publicar();
		AltaUsuarioPublish au = new AltaUsuarioPublish();
		au.publicar();
		
		ConsultaEspectaculoPublish ce = new ConsultaEspectaculoPublish();
		ce.publicar();
		
		ConsultaFuncionPublish cf = new ConsultaFuncionPublish();
		cf.publicar();

		LoginPublish login = new LoginPublish();
		login.publicar();
		
		SeguirAUsuarioPublish su = new SeguirAUsuarioPublish();
		su.publicar();
		
		DejarSeguirUsuarioPublish dsu = new DejarSeguirUsuarioPublish();
		dsu.publicar();
		
		
		//Alta Usuario Internal Frame
		altaUsuarioInternalFrame = new AltaUsuario(iconAltaUsuario);
		altaUsuarioInternalFrame.setSize(new Dimension(375, 432));
		altaUsuarioInternalFrame.setMinimumSize(new Dimension(375, 432));
		altaUsuarioInternalFrame.setMaximumSize(new Dimension(375, 432));
		altaUsuarioInternalFrame.setLocation(15,59);
		altaUsuarioInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().setLayout(null);
		frmCoronaticketsuyPantalla.getContentPane().add(altaUsuarioInternalFrame);
	
		//Modificar Usuario Internal Frame
		ModificarUsuarioInternalFrame = new ModificarUsuario(iconMU);
		ModificarUsuarioInternalFrame.setNormalBounds(new Rectangle(100, 100, 500, 500));
		ModificarUsuarioInternalFrame.setSize(new Dimension(375, 543));
		ModificarUsuarioInternalFrame.setMinimumSize(new Dimension(500, 500));
		ModificarUsuarioInternalFrame.setMaximumSize(new Dimension(500, 500));
		ModificarUsuarioInternalFrame.setLocation(15,59);
		ModificarUsuarioInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().setLayout(null);
		frmCoronaticketsuyPantalla.getContentPane().add(ModificarUsuarioInternalFrame);
		
		//Alta Espectaculo Internal Frame
		altaEspectaculoInternalFrame = new AltaEspectaculo(iconAE, iconCP);
		altaEspectaculoInternalFrame.setSize(new Dimension(492, 543));
		altaEspectaculoInternalFrame.setMinimumSize(new Dimension(492, 543));
		altaEspectaculoInternalFrame.setMaximumSize(new Dimension(492, 543));
		altaEspectaculoInternalFrame.setLocation(15,59);
		altaEspectaculoInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(altaEspectaculoInternalFrame);
		
		//Alta Plataforma Internal Frame
		altaPlataformaInternalFrame = new AltaPlataforma(iconAP);
		altaPlataformaInternalFrame.setSize(443, 313);
		altaPlataformaInternalFrame.setLocation(15,15);
		altaPlataformaInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(altaPlataformaInternalFrame);
		
		//Alta Funcion Internal Frame
		altaFuncionEspectaculoInternalFrame = new AltaFuncionEspectaculo(iconAFE, iconCP, iconAE);
		altaFuncionEspectaculoInternalFrame.setSize(529, 548);
		altaFuncionEspectaculoInternalFrame.setLocation(50,50);
		altaFuncionEspectaculoInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(altaFuncionEspectaculoInternalFrame);
		
		//Consulta Espectaculo
		consultaEspectaculoInternalFrame = new ConsultaEspectaculo(iconCPaq, iconCF, iconCP, iconCE);
		consultaEspectaculoInternalFrame.setSize(407, 777);
    
		consultaEspectaculoInternalFrame.setMinimumSize(new Dimension(430, 780));
		consultaEspectaculoInternalFrame.setMaximumSize(new Dimension(430, 780));
		consultaEspectaculoInternalFrame.setLocation(50, 50);
		consultaEspectaculoInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(consultaEspectaculoInternalFrame);
		
		//Consulta Funcion Espectaculo Internal Frame
		consultaFuncionEspectaculoInternalFrame = new ConsultaFuncionEspectaculo(iconCF, iconCP);
		consultaFuncionEspectaculoInternalFrame.setSize(383, 477);
		consultaFuncionEspectaculoInternalFrame.setMinimumSize(new Dimension(383, 477));
		consultaFuncionEspectaculoInternalFrame.setMaximumSize(new Dimension(383, 477));
		consultaFuncionEspectaculoInternalFrame.setLocation(50, 50);
		frmCoronaticketsuyPantalla.getContentPane().add(consultaFuncionEspectaculoInternalFrame);
		//consultaFuncionEspectaculoInternalFrame.getContentPane().setLayout(null);
		
		//Alta Paquete Internal Frame
		AltaPaqueteInternalFrame = new AltaPaquete(iconAPaquete);
		AltaPaqueteInternalFrame.setSize(392, 449);
		AltaPaqueteInternalFrame.setMinimumSize(new Dimension(430, 780));
		AltaPaqueteInternalFrame.setMaximumSize(new Dimension(430, 780));
		AltaPaqueteInternalFrame.setLocation(15, 59);
		AltaPaqueteInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(AltaPaqueteInternalFrame);
		
		//Agregar Espectaculo A Paquete Internal Frame
		AgregarEspectaculoAPaqueteInternalFrame = new AgregarEspectaculoAPaquete(iconAEP, iconCP);
		AgregarEspectaculoAPaqueteInternalFrame.setSize(450, 300);
		AgregarEspectaculoAPaqueteInternalFrame.setMinimumSize(new Dimension(430, 780));
		AgregarEspectaculoAPaqueteInternalFrame.setMaximumSize(new Dimension(430, 780));
		AgregarEspectaculoAPaqueteInternalFrame.setLocation(15, 59);
		AgregarEspectaculoAPaqueteInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(AgregarEspectaculoAPaqueteInternalFrame);
		
		//Consultar Paquete
		ConsultaPaqueteInternalFrame = new ConsultaPaquete(iconCPaq, iconCE);
		ConsultaPaqueteInternalFrame.setSize(450, 300);
		ConsultaPaqueteInternalFrame.setMinimumSize(new Dimension(430, 780));
		ConsultaPaqueteInternalFrame.setMaximumSize(new Dimension(430, 780));
		ConsultaPaqueteInternalFrame.setLocation(15, 59);
		ConsultaPaqueteInternalFrame.setVisible(false);
		frmCoronaticketsuyPantalla.getContentPane().add(ConsultaPaqueteInternalFrame);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoronaticketsuyPantalla = new JFrame();
		frmCoronaticketsuyPantalla.setTitle("CoronaticketsUY - Pantalla Principal");
		frmCoronaticketsuyPantalla.setBounds(100, 100, 902, 800);
		frmCoronaticketsuyPantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCoronaticketsuyPantalla.setJMenuBar(menuBar);

		//Casos de Usos de Usuarios
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		//Menu Item de CU Alta de Usuario
		JMenuItem mnItemAltaUsuario = new JMenuItem("Crear Usuario");
		mnItemAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioInternalFrame.setVisible(true);
				}
		});
		
		//Menu Item de CU Consulta de Usuario
		JMenuItem mnItemConsultaUsuario = new JMenuItem("Consultar Usuario");
		mnItemConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Menu Item de CU Modificar Datos de Usuario
		JMenuItem mnItemModificarUsuario = new JMenuItem("Modificar Usuario");
		mnItemModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModificarUsuarioInternalFrame.setVisible(true);
					ModificarUsuarioInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnUsuario.add(mnItemAltaUsuario);
		mnUsuario.add(mnItemConsultaUsuario);
		mnUsuario.add(mnItemModificarUsuario);
		
			
		//Casos de Usos de Espectaculo
		JMenu mnEspectaculo = new JMenu("Espectaculo");
		menuBar.add(mnEspectaculo);
		
		//Menu Item de CU Alta de Espectaculo
		JMenuItem mnItemCrearEspectaculo = new JMenuItem("Crear Espectaculo");
		mnItemCrearEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaEspectaculoInternalFrame.setVisible(true);
					altaEspectaculoInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		//Menu Item de CU Consulta de Espectaculo
		JMenuItem mnItemConsultaEspectaculo = new JMenuItem("Consultar Espectaculo");
		mnItemConsultaEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					consultaEspectaculoInternalFrame.setVisible(true);
					consultaEspectaculoInternalFrame.inicializarComboBoxes();
					consultaEspectaculoInternalFrame.limpiarFormulario();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnEspectaculo.add(mnItemCrearEspectaculo);
		mnEspectaculo.add(mnItemConsultaEspectaculo);
		
		
		//Casos de Usos de Funcion
		JMenu mnFuncion = new JMenu("Funcion");
		menuBar.add(mnFuncion);
		
		//Menu Item de CU Alta de Funcion de Espectaculo
		JMenuItem mnItemAgregarFuncion = new JMenuItem("Agregar Funcion");
		mnItemAgregarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaFuncionEspectaculoInternalFrame.setVisible(true);
					altaFuncionEspectaculoInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Menu Item de CU Consulta de Funcion de Espectaculo
		JMenuItem mnItemConsultarFuncion = new JMenuItem("Consultar Funcion");
		mnItemConsultarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					consultaFuncionEspectaculoInternalFrame.setVisible(true);
					consultaFuncionEspectaculoInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Menu Item de CU Registro a Funcion de Espectaculo
		JMenuItem mnItemRegistroFuncion = new JMenuItem("Registrar Funcion");
		mnItemRegistroFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		mnFuncion.add(mnItemAgregarFuncion);
		mnFuncion.add(mnItemConsultarFuncion);
		mnFuncion.add(mnItemRegistroFuncion);
		
		
		//Casos de Usos de Paquete
		JMenu mnPaquete = new JMenu("Paquete");
		menuBar.add(mnPaquete);
		
		JMenuItem mnItemCrearPaquete = new JMenuItem("Crear Paquete");
		mnItemCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AltaPaqueteInternalFrame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JMenuItem mnItemAgregarEspectaculo = new JMenuItem("Agregar Espectaculo a Paquete");
		mnItemAgregarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AgregarEspectaculoAPaqueteInternalFrame.setVisible(true);
					AgregarEspectaculoAPaqueteInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mnItemConsultaPaquete = new JMenuItem("Consultar Paquete");
		mnItemConsultaPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConsultaPaqueteInternalFrame.setVisible(true);
					ConsultaPaqueteInternalFrame.inicializarComboBoxes();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnPaquete.add(mnItemCrearPaquete);
		mnPaquete.add(mnItemAgregarEspectaculo);
		mnPaquete.add(mnItemConsultaPaquete);
		
		
		JMenu mnPlataforma = new JMenu("Plataforma");
		menuBar.add(mnPlataforma);
		
		JMenuItem mnItemCrearPlataforma = new JMenuItem("Crear Plataforma");
		mnPlataforma.add(mnItemCrearPlataforma);
		mnItemCrearPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaPlataformaInternalFrame.setVisible(true);
				} catch (Exception e2) {
					altaPlataformaInternalFrame.setVisible(false);
				}
			}
		});
		
		mnPlataforma.add(mnItemCrearPlataforma);
		
	}
}
