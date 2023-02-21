package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import logica.datatypes.DTFuncion;
import logica.datatypes.DTInfoEspectaculo;
import logica.datatypes.DTPaquete;
import logica.interfaces.IControladorConsultaEspectaculo;
import logica.interfaces.IControladorConsultaFuncion;
import logica.interfaces.IControladorConsultaPaquete;
import logica.interfaces.IControladorConsultaPlataforma;

public class ConsultaEspectaculo extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorConsultaFuncion iconCF;
	private IControladorConsultaPlataforma iconCP;
	private IControladorConsultaEspectaculo iconCE;
	private IControladorConsultaPaquete iconCPaq;
	
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxFuncion;
	private JComboBox<String> comboBoxPaquete;
	private JTextPane textPaneInfoEspectaculo;
	private JTextPane textPaneInfoGeneral;
	
	DefaultComboBoxModel<String> modelClear = new DefaultComboBoxModel<String>();

	public ConsultaEspectaculo(IControladorConsultaPaquete iconCPaq, IControladorConsultaFuncion iconCF, IControladorConsultaPlataforma iconCP, IControladorConsultaEspectaculo iconCE) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		/*INICIALIZACION DE LOS ICONTROLLERS*/
		this.iconCF=iconCF;
		this.iconCP=iconCP;
		this.iconCE=iconCE;
		this.iconCPaq=iconCPaq;
		
		/*CONFIGURACION DE LA PANTALLA*/		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Consulta de Espectaculo");
        setBounds(100, 100, 430, 780);
		getContentPane().setLayout(null);
		
		/*ESPACIO DE LOS JLABELS*/
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(10, 41, 68, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Espect\u00E1culo");
		lblNewLabel_1.setBounds(10, 74, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funci\u00F3n");
		lblNewLabel_1_1.setBounds(10, 347, 68, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		/*CREACION DE LOS COMBOBOXES*/
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.setBounds(88, 37, 276, 22);
		getContentPane().add(comboBoxPlataforma);
		
		comboBoxFuncion = new JComboBox<String>();
		comboBoxFuncion.setBounds(88, 343, 276, 22);
		getContentPane().add(comboBoxFuncion);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(88, 70, 276, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		/*CREACION DEL BOTON VER INFO*/
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.setBounds(10, 116, 117, 25);
		getContentPane().add(btnVerInfo);
		
		/*CREACION DEL TEXTPANE*/
		textPaneInfoEspectaculo = new JTextPane();
		textPaneInfoEspectaculo.setBounds(10, 152, 354, 184);
		getContentPane().add(textPaneInfoEspectaculo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Paquetes");
		lblNewLabel_1_1_1.setBounds(10, 395, 68, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.setBounds(88, 391, 276, 22);
		getContentPane().add(comboBoxPaquete);
		
		textPaneInfoGeneral = new JTextPane();
		textPaneInfoGeneral.setBounds(10, 503, 354, 206);
		getContentPane().add(textPaneInfoGeneral);
		
		JButton btnVerInfoFuncion = new JButton("Ver Info Funcion");
		btnVerInfoFuncion.setBounds(48, 456, 117, 25);
		getContentPane().add(btnVerInfoFuncion);
		
		JButton btnVerInfoPaquete = new JButton("Ver Info Paquete");
		btnVerInfoPaquete.setBounds(204, 456, 117, 25);
		getContentPane().add(btnVerInfoPaquete);
		
		
		/*ACCION DEL COMBOBOX PLATAFORMA */
		comboBoxPlataforma.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconCF.listarEspectaculos(comboBoxPlataforma.getSelectedItem().toString()));
				comboBoxEspectaculo.setModel(modelEspectaculo);	
			}
		});
		
		/* ACCION DEL BOTON DE VER INFO */
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					infoEspectaculoActionPerformed(e);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnVerInfoFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					infoFuncionActionPerformed(e);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnVerInfoPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					infoPaqueteActionPerformed(e);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}
	
	/* SE USA PARA CARGAR COMBOBOX DE PLATAFORMAS SE LLAMA DESDE PRINCIPAL*/
	public void inicializarComboBoxes() throws Exception {
		try {
			DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconCP.listarPlataformas());
			comboBoxPlataforma.setModel(modelPlataforma);	
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan ingresar datos de Plataformas", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}		
	}
	
	private void infoEspectaculoActionPerformed(ActionEvent e) {
		
		String strEspectaculo = this.comboBoxEspectaculo.getSelectedItem().toString();
		
		if(checkFormulario()) {
			
			textPaneInfoEspectaculo.setText("");
			String datos = "INFORMACION_DE_ESPECTACULO";
			DTInfoEspectaculo infoEspectaculo;
			infoEspectaculo = iconCE.consultaEspectaculo(strEspectaculo);
			datos = datos + "\n\n" + infoEspectaculo.toString();
			textPaneInfoEspectaculo.setText(datos);
			DefaultComboBoxModel<String> modelFuncion = new DefaultComboBoxModel<String>(iconCF.listarFunciones(comboBoxEspectaculo.getSelectedItem().toString()));
			comboBoxFuncion.setModel(modelFuncion);	
			DefaultComboBoxModel<String> modelPaquete = new DefaultComboBoxModel<String>(iconCE.listarPaquetesDelEspectaculo(comboBoxEspectaculo.getSelectedItem().toString()));
			comboBoxPaquete.setModel(modelPaquete);
		}
	}
	
	private void infoFuncionActionPerformed(ActionEvent e) {
		
		String strFuncion = this.comboBoxFuncion.getSelectedItem().toString();
		
		if(checkFormularioGeneral()) {
			
			textPaneInfoGeneral.setText("");
			String datos = "INFORMACION_DE_FUNCION";
			DTFuncion infoFuncion;
			infoFuncion = iconCF.consultarFuncion(strFuncion);
		
			datos = datos + "\n\n" + infoFuncion.toString();
			
			textPaneInfoGeneral.setText(datos);
			
		}
	}
	
	private void infoPaqueteActionPerformed(ActionEvent e) {
		
		String strPaquete = this.comboBoxPaquete.getSelectedItem().toString();
		
		if(checkFormularioGeneral()) {
			
			textPaneInfoGeneral.setText("");
			String datos = "INFORMACION_DE_Paquete";
			DTPaquete infoPaquete;
			infoPaquete = iconCPaq.infoPaquete(strPaquete);	
			datos = datos + "\n\n" + infoPaquete.toString();	
			textPaneInfoGeneral.setText(datos);			
		}
	}
		
	private boolean checkFormulario() {
		String strEspectaculo = this.comboBoxEspectaculo.getSelectedItem().toString();
		if(strEspectaculo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo funcion esta vacio", "Ver Info de Espectaculo",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private boolean checkFormularioGeneral() {
		String strEspectaculo = this.comboBoxFuncion.getSelectedItem().toString();
		if(strEspectaculo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo funcion esta vacio", "Ver Info de Espectaculo",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void limpiarFormulario() {
		comboBoxEspectaculo.setModel(modelClear);
		comboBoxFuncion.setModel(modelClear);
		comboBoxPaquete.setModel(modelClear);
		textPaneInfoGeneral.setText("");
		textPaneInfoEspectaculo.setText("");
	}
	
}
