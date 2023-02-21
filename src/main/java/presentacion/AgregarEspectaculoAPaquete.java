package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.excepciones.YaContieneEspectaculo;
import logica.interfaces.IControladorAgregarEspectaculoAPaquete;
import logica.interfaces.IControladorConsultaPlataforma;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AgregarEspectaculoAPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorAgregarEspectaculoAPaquete iconAEP;
	private IControladorConsultaPlataforma iconCP;
	
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxPaquete;
	private JComboBox<String> comboBoxPlataforma;
	
	DefaultComboBoxModel<String> modelClear = new DefaultComboBoxModel<String>();


	public AgregarEspectaculoAPaquete(IControladorAgregarEspectaculoAPaquete iconAEP, IControladorConsultaPlataforma iconCP){
		this.iconAEP = iconAEP;
		this.iconCP = iconCP;
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Agregar Espectaculo A Paquete");
		setBounds(100, 100, 411, 251);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Espectaculo");
		lblNewLabel.setBounds(42, 137, 80, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Paquete");
		lblNewLabel_1.setBounds(42, 48, 64, 14);
		getContentPane().add(lblNewLabel_1);
						
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(42, 94, 80, 14);
		getContentPane().add(lblPlataforma);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.setBounds(116, 44, 224, 22);
		getContentPane().add(comboBoxPaquete);
			
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconAEP.consultarEspectaculosPlataforma(comboBoxPlataforma.getSelectedItem().toString()));
				comboBoxEspectaculo.setModel(modelEspectaculo);	
			}
		});
		comboBoxPlataforma.setBounds(116, 90, 224, 22);
		getContentPane().add(comboBoxPlataforma);

		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(116, 133, 224, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					limpiarFormularios();
					setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		Cancelar.setBounds(209, 187, 89, 23);
		getContentPane().add(Cancelar);
		
		JButton Aceptar = new JButton("Aceptar");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Metodo para cuando se acepta
				try {
					AceptarActionPerformed(arg0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
		Aceptar.setBounds(81, 187, 89, 23);
		getContentPane().add(Aceptar);

	}
	

	//Accion del boton aceptar
	private void AceptarActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String nombrePaquete = this.comboBoxPaquete.getSelectedItem().toString();
		String nombreEspectaculo = this.comboBoxEspectaculo.getSelectedItem().toString();
		try {
			iconAEP.agregarEspectaculoAPaquete(nombrePaquete, nombreEspectaculo);
			JOptionPane.showMessageDialog(null, "Se agregó con éxito el espactaculo  " + nombreEspectaculo + " al paquete " + nombrePaquete, "Agregar Espectaculo a Paquete" , JOptionPane.INFORMATION_MESSAGE);
			limpiarFormularios();
			setVisible(false);
		
		}catch (YaContieneEspectaculo msg) {
			JOptionPane.showMessageDialog(this, msg.getMessage(), "Agregar Espectaculo a Paquete", JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	
	public void inicializarComboBoxes() throws Exception {	
		try {
			
			DefaultComboBoxModel<String> modelPaquete = new DefaultComboBoxModel<String>(iconAEP.listarPaquetes());
			comboBoxPaquete.setModel(modelPaquete);	
			
			DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconCP.listarPlataformas());
			comboBoxPlataforma.setModel (modelPlataforma);
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan ingresar datos", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}	
	}
	
	private void limpiarFormularios() {
		comboBoxPaquete.setModel(modelClear);
		comboBoxPlataforma.setModel(modelClear);
		comboBoxEspectaculo.setModel(modelClear);
	}
}
