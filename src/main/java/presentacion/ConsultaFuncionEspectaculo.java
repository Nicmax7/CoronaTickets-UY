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
import logica.interfaces.IControladorConsultaFuncion;
import logica.interfaces.IControladorConsultaPlataforma;
import java.awt.Rectangle;
import java.awt.Dimension;

public class ConsultaFuncionEspectaculo extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorConsultaFuncion iconCF;
	private IControladorConsultaPlataforma iconCP;
	
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxFuncion;
	private JTextPane textPaneInfoFuncion;
	
	DefaultComboBoxModel<String> modelClear = new DefaultComboBoxModel<String>();
	public ConsultaFuncionEspectaculo(IControladorConsultaFuncion iconCF, IControladorConsultaPlataforma iconCP) {
		
		/*INICIALIZACION DE LOS ICONTROLLERS*/
		this.iconCF=iconCF;
		this.iconCP=iconCP;
		
		/*CONFIGURACION DE LA PANTALLA*/		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Ver Info de Funcion");
        setBounds(100, 100, 383, 477);
		getContentPane().setLayout(null);
		
		/*ESPACIO DE LOS JLABELS*/
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(10, 41, 68, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Espect\u00E1culo");
		lblNewLabel_1.setBounds(10, 74, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Funci\u00F3n");
		lblNewLabel_1_1.setBounds(10, 126, 68, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		/*CREACION DE LOS COMBOBOXES*/
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.setBounds(88, 37, 213, 22);
		getContentPane().add(comboBoxPlataforma);
		
		comboBoxFuncion = new JComboBox<String>();
		comboBoxFuncion.setBounds(88, 122, 213, 22);
		getContentPane().add(comboBoxFuncion);
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(88, 70, 213, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		/*CREACION DEL BOTON VER INFO*/
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.setBounds(10, 189, 117, 25);
		getContentPane().add(btnVerInfo);
		
		/*CREACION DEL TEXTPANE*/
		textPaneInfoFuncion = new JTextPane();
		textPaneInfoFuncion.setBounds(10, 223, 349, 184);
		getContentPane().add(textPaneInfoFuncion);
		
		
		/*ACCION DEL COMBOBOX PLATAFORMA */
		comboBoxPlataforma.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconCF.listarEspectaculos(comboBoxPlataforma.getSelectedItem().toString()));
				comboBoxEspectaculo.setModel(modelEspectaculo);	
			}
		});
		
		/*ACCION DEL COMBOBOX ESPECTACULO*/
		comboBoxEspectaculo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelFuncion = new DefaultComboBoxModel<String>(iconCF.listarFunciones(comboBoxEspectaculo.getSelectedItem().toString()));
				comboBoxFuncion.setModel(modelFuncion);	
			}
		});

		/* ACCION DEL BOTON DE VER INFO */
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					infoFuncionActionPerformed(e);
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
	
	private void infoFuncionActionPerformed(ActionEvent e) throws Exception {
		
		
		if(checkFormulario()) {
			String strFuncion = this.comboBoxFuncion.getSelectedItem().toString();
			textPaneInfoFuncion.setText("");
			String datos = "INFORMACION_DE_FUNCION";
			DTFuncion infoFuncion;
			infoFuncion = iconCF.consultarFuncion(strFuncion);
		
			datos = datos + "\n\n" + infoFuncion.toString();
			
			textPaneInfoFuncion.setText(datos);
			
		}
	}
	
	private boolean checkFormulario() throws Exception {
		
		try {
			String strFuncion = this.comboBoxFuncion.getSelectedItem().toString();
			if(strFuncion.isEmpty()) {
				return false;
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "El campo funcion esta vacio", "Ver Info de Funcion",JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}
		
		return true;

	}
		
	public void limpiarFormulario() {
		comboBoxEspectaculo.setModel(modelClear);
		comboBoxFuncion.setModel(modelClear);
		textPaneInfoFuncion.setText("");
	}	
}
