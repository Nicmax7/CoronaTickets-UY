package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.datatypes.DTEspectaculo;
import logica.excepciones.EspectaculoRepetidoException;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorConsultaPlataforma;

public class AltaEspectaculo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private static IControladorAltaEspectaculo iconAE;
	private static IControladorConsultaPlataforma iconCP;

	
	private JTextField nombreEspectaculo;
	private JTextField descripcion;
	private JTextField duracion;
	private JTextField capacidadMin;
	private JTextField capacidadMax;
	private JTextField costo;
	private JTextField url;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxArtista;
	

	public AltaEspectaculo(IControladorAltaEspectaculo iconAE, IControladorConsultaPlataforma iconCP) {
		this.iconAE = iconAE;
		this.iconCP = iconCP;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar un Espectaculo");
		setBounds(100, 100, 492, 543);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		nombreEspectaculo = new JTextField();
		nombreEspectaculo.setBounds(128, 28, 195, 20);
		getContentPane().add(nombreEspectaculo);
		nombreEspectaculo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre Espect\u00E1culo");
		lblNewLabel.setBounds(10, 31, 106, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plataforma");
		lblNewLabel_1.setBounds(10, 63, 106, 14);
		getContentPane().add(lblNewLabel_1);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.setBounds(128, 59, 195, 22);
		
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblNewLabel_2 = new JLabel("Organizador");
		lblNewLabel_2.setBounds(10, 96, 106, 14);
		getContentPane().add(lblNewLabel_2);
		
		comboBoxArtista = new JComboBox<String>();
		comboBoxArtista.setBounds(128, 92, 195, 22);
		getContentPane().add(comboBoxArtista);
		
		JLabel lblNewLabel_3 = new JLabel("Informaci\u00F3n b\u00E1sica");
		lblNewLabel_3.setBounds(10, 152, 106, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n");
		lblNewLabel_4.setBounds(55, 187, 60, 14);
		getContentPane().add(lblNewLabel_4);
		
		descripcion = new JTextField();
		descripcion.setBounds(128, 184, 296, 59);
		getContentPane().add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Duraci\u00F3n");
		lblNewLabel_4_1.setBounds(55, 265, 60, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		duracion = new JTextField();
		duracion.setBounds(128, 262, 86, 20);
		getContentPane().add(duracion);
		duracion.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Capacidad");
		lblNewLabel_4_1_1.setBounds(55, 303, 60, 14);
		getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("M\u00EDn");
		lblNewLabel_4_1_1_1.setBounds(128, 303, 29, 14);
		getContentPane().add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("M\u00E1x");
		lblNewLabel_4_1_1_2.setBounds(224, 303, 29, 14);
		getContentPane().add(lblNewLabel_4_1_1_2);
		
		capacidadMin = new JTextField();
		capacidadMin.setBounds(152, 300, 60, 20);
		capacidadMin.setColumns(10);
		getContentPane().add(capacidadMin);
		
		capacidadMax = new JTextField();
		capacidadMax.setBounds(252, 300, 60, 20);
		capacidadMax.setColumns(10);
		getContentPane().add(capacidadMax);
		
		JLabel lblNewLabel_4_1_1_3 = new JLabel("Costo");
		lblNewLabel_4_1_1_3.setBounds(55, 343, 60, 14);
		getContentPane().add(lblNewLabel_4_1_1_3);
		
		JLabel lblNewLabel_4_1_1_3_1 = new JLabel("URL");
		lblNewLabel_4_1_1_3_1.setBounds(55, 381, 60, 14);
		getContentPane().add(lblNewLabel_4_1_1_3_1);
		
		costo = new JTextField();
		costo.setBounds(128, 340, 86, 20);
		costo.setColumns(10);
		getContentPane().add(costo);
		
		url = new JTextField();
		url.setBounds(128, 378, 296, 20);
		url.setColumns(10);
		getContentPane().add(url);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(212, 454, 100, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEspectaculoActionPerformed(e);
			}
		});
		getContentPane().add(btnNewButton);

	}
	
	public void inicializarComboBoxes() throws Exception {
		try {
			DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconCP.listarPlataformas());
			comboBoxPlataforma.setModel (modelPlataforma);
			DefaultComboBoxModel<String> modelArtista = new DefaultComboBoxModel<String>(iconAE.listarArtistas());
			comboBoxArtista.setModel(modelArtista);		
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan ingresar datos de Plataformas y/o Artistas", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}	
		
	}

	private void altaEspectaculoActionPerformed(ActionEvent e) {
		DTEspectaculo dtEspectaculo;
		
		if (checkFormulario()) {
			
			Calendar fechaSistema = Calendar.getInstance();
			String nombre = this.nombreEspectaculo.getText();
			String descripcion = this.descripcion.getText();
			String duracion = this.duracion.getText();
			Integer capacidadMin;
			Integer capacidadMax;
			float costo;
			String url = this.url.getText();
			String nombrePlataforma = this.comboBoxPlataforma.getSelectedItem().toString();
			String nombreArtista = this.comboBoxArtista.getSelectedItem().toString();
			
			try {
				capacidadMin = Integer.parseInt(this.capacidadMin.getText());
				capacidadMax = Integer.parseInt(this.capacidadMax.getText());
				costo = Float.parseFloat(this.costo.getText());
				//dtEspectaculo = new DTEspectaculo(nombre, descripcion, duracion, url, costo, capacidadMin, capacidadMax, fechaSistema.getTime());
				dtEspectaculo = new DTEspectaculo(nombre, descripcion, duracion, url, costo, capacidadMin, capacidadMax, fechaSistema);
				AltaEspectaculo.iconAE.agregarEspectaculo(nombrePlataforma, nombreArtista, dtEspectaculo);
				JOptionPane.showMessageDialog(null, "Se agrega con exito el espectaculo: " + nombre, "Alta Espectaculo" , JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
				setVisible(false);
			}catch (EspectaculoRepetidoException msg) {
				JOptionPane.showMessageDialog(this, msg.getMessage(), "Min, Max y Costo solo admiten numeros", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}
	
	private boolean checkFormulario() {
		
		String nombre = this.nombreEspectaculo.getText();
		String descripcion = this.descripcion.getText();
		String duracion = this.duracion.getText();
		String url = this.url.getText();

		Object nombrePlataforma = this.comboBoxPlataforma.getSelectedItem();
		Object nombreArtista = this.comboBoxArtista.getSelectedItem();
		
		if(nombreArtista==null||nombrePlataforma==null)  {
			if(nombrePlataforma==null) {
				JOptionPane.showMessageDialog(this, "No existen plataformas en el sistema", "Alta Espectaculo",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
			}
			else{
				JOptionPane.showMessageDialog(this, "No existen Artistas en el sistema", "Alta Espectaculo",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
				
			}
		}
		else if(nombre.isEmpty()||descripcion.isEmpty()||duracion.isEmpty()||url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos", "Alta Espectaculo",JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
        return true;
	}

	private void limpiarFormulario() {
		nombreEspectaculo.setText("");
		descripcion.setText("");
		duracion.setText("");
		capacidadMin.setText("");
		capacidadMax.setText("");
		costo.setText("");
		url.setText("");
	}	
}
