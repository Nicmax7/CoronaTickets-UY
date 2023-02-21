package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import logica.datatypes.DTInfoEspectaculo;
import logica.datatypes.DTPaquete;
import logica.interfaces.IControladorConsultaEspectaculo;
import logica.interfaces.IControladorConsultaPaquete;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ConsultaPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorConsultaPaquete iconCP;
	private IControladorConsultaEspectaculo iconCE;
	
	private JComboBox<String> comboBoxPaquete;
	private JComboBox<String> comboBoxEspectaculo;
	private JTextPane textPaneInfoPaquete;
	private JTextPane textPaneInfoEspectaculo;

	public ConsultaPaquete(IControladorConsultaPaquete iconCP, IControladorConsultaEspectaculo iconCE) {
		this.iconCE = iconCE;
		this.iconCP = iconCP;
		setTitle("Consulta Paquete");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 370, 616);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paquete");
		lblNewLabel.setBounds(33, 35, 46, 14);
		getContentPane().add(lblNewLabel);		
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		lblEspectaculo.setBounds(30, 293, 57, 14);
		getContentPane().add(lblEspectaculo);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconCP.obtenerEspectaculosPaquete(comboBoxPaquete.getSelectedItem().toString()));
				comboBoxEspectaculo.setModel(modelEspectaculo);	
			}
		});
		comboBoxPaquete.setBounds(107, 31, 204, 22);
		getContentPane().add(comboBoxPaquete);	
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.setBounds(104, 289, 207, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		textPaneInfoPaquete = new JTextPane();
		textPaneInfoPaquete.setBounds(33, 112, 281, 160);
		getContentPane().add(textPaneInfoPaquete);

		textPaneInfoEspectaculo = new JTextPane();
		textPaneInfoEspectaculo.setBounds(33, 364, 281, 185);
		getContentPane().add(textPaneInfoEspectaculo);
		
		JButton VerInfoPaquete = new JButton("Ver Info");
		VerInfoPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoPaqueteActionPerformed(arg0);
			}
		});
		VerInfoPaquete.setBounds(33, 78, 89, 23);
		getContentPane().add(VerInfoPaquete);
		
		JButton VerInfoEspectaculo = new JButton("Ver Info");
		VerInfoEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoEspectaculoActionPerformed(arg0);
			}
		});
		VerInfoEspectaculo.setBounds(33, 329, 89, 23);
		getContentPane().add(VerInfoEspectaculo);

	}

	//Botones	
	
	private void infoPaqueteActionPerformed(ActionEvent arg0) {	
		String strPaquete = this.comboBoxPaquete.getSelectedItem().toString();	
		if(checkFormulario()) {	
			textPaneInfoPaquete.setText("");
			String datos = "INFORMACION_DE_PAQUETE";
			DTPaquete infoPaquete;
			infoPaquete = iconCP.infoPaquete(strPaquete);
			datos = datos + "\n\n" + infoPaquete.toString();
			textPaneInfoPaquete.setText(datos);
		}
	}
		
	private void infoEspectaculoActionPerformed(ActionEvent arg0) {
		String strEspectaculo = this.comboBoxEspectaculo.getSelectedItem().toString();	
		if(checkFormulario()) {	
			textPaneInfoEspectaculo.setText("");
			String datos = "INFORMACION_DE_ESPECTACULO";
			DTInfoEspectaculo infoEspectaculo;
			infoEspectaculo = iconCE.consultaEspectaculo(strEspectaculo);
			datos = datos + "\n\n" + infoEspectaculo.toString();
			textPaneInfoEspectaculo.setText(datos);
		}
		
	}
	
	//combo boxes
	
	public void inicializarComboBoxes() throws Exception {	
		try {
			DefaultComboBoxModel<String> modelPaquete = new DefaultComboBoxModel<String>(iconCP.listarPaquetes());
			comboBoxPaquete.setModel(modelPaquete);	
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan ingresar datos", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}	
	}
	
	private boolean checkFormulario() {
		String strFuncion = this.comboBoxPaquete.getSelectedItem().toString();
		if(strFuncion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo paquete esta vacio", "Ver Info de Paquete",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}



