package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.datatypes.DTPlataforma;
import logica.excepciones.PlataformaRepetidaException;
import logica.interfaces.IControladorAltaPlataforma;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaPlataforma extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaPlataforma iconAP;
	
	private JTextField nombrePlataforma;
	private JTextField descripcion;
	private JTextField url;

	public AltaPlataforma(IControladorAltaPlataforma iconAP) {
		this.iconAP = iconAP;
		
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Agregar una plataforma");
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 450, 300);
		//capaz haya que volver a agregar un setBounds
		getContentPane().setLayout(null);
		
		JLabel nombrePlataformaLabel = new JLabel("Nombre Plataforma");
		nombrePlataformaLabel.setBounds(40, 41, 104, 14);
		getContentPane().add(nombrePlataformaLabel);
		
		nombrePlataforma = new JTextField();
		nombrePlataforma.setBounds(154, 38, 216, 20);
		getContentPane().add(nombrePlataforma);
		nombrePlataforma.setColumns(10);
		
		JLabel descripcionLabel = new JLabel("Descripci\u00F3n");
		descripcionLabel.setBounds(40, 87, 64, 14);
		getContentPane().add(descripcionLabel);
		
		descripcion = new JTextField();
		descripcion.setBounds(154, 87, 216, 76);
		getContentPane().add(descripcion);
		descripcion.setColumns(10);
		
		JLabel urlLabel = new JLabel("URL");
		urlLabel.setBounds(40, 186, 64, 14);
		getContentPane().add(urlLabel);
		
		url = new JTextField();
		url.setColumns(10);
		url.setBounds(154, 183, 216, 20);
		getContentPane().add(url);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					altaPlataformaActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(161, 236, 89, 23);
		getContentPane().add(btnAceptar);

	}		
	

	private void altaPlataformaActionPerformed(ActionEvent arg0){
		String nombre = this.nombrePlataforma.getText();
		String descripcion = this.descripcion.getText();
		String url = this.url.getText();
		
		DTPlataforma dtPlataforma = new DTPlataforma(nombre, descripcion, url);
		
		if(checkFormulario()) {
			try {
				this.iconAP.agregarPlataforma(dtPlataforma);
				JOptionPane.showMessageDialog(this, "Plataforma creada con exito", "Agregar Plataforma",
						JOptionPane.INFORMATION_MESSAGE);
			}
			catch(PlataformaRepetidaException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Agregar Plataforma", JOptionPane.ERROR_MESSAGE);
			}
			this.nombrePlataforma.setText("");
			this.descripcion.setText("");
			this.url.setText("");
			setVisible(false);
		}
	}
	
	private boolean checkFormulario() {
		String nombrePlataforma = this.nombrePlataforma.getText();
		String descripcion = this.descripcion.getText();
		String url = this.url.getText();
		if(nombrePlataforma.isEmpty() || descripcion.isEmpty() || url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Plataforma",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	
}
