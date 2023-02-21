package presentacion;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectador;
import logica.datatypes.DTUsuarioBasico;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.interfaces.IControladorAltaUsuario;

public class AltaUsuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private IControladorAltaUsuario iconAltaUsuario;
	
	private JTextField textField_Nickname;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Email;
	private JTextField textField_Descripcion;
	private JTextField textField_Biografia;
	private JTextField textField_Link;
	private JComboBox<String> comboBoxUsuario;
	private JLabel lblDescripcionOb;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField textField_contrasenia;

	public AltaUsuario(IControladorAltaUsuario iconAltaUsuario) {
		/*INICIALIZACION DE LOS ICONTROLLERS*/
		this.iconAltaUsuario = iconAltaUsuario;

		/*CONFIGURACION DE LA PANTALLA*/
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    setTitle("Alta de un Usuario");
		setBounds(100, 100, 375, 456);
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(50, 31, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(50, 73, 72, 14);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 104, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(50, 135, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(50, 203, 105, 14);
		getContentPane().add(lblFechaDeNacimiento);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(50, 234, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(50, 262, 72, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("Biografia");
		lblBiografia.setBounds(50, 293, 60, 14);
		getContentPane().add(lblBiografia);
		
		JLabel lblLink = new JLabel("Link");
		lblLink.setBounds(50, 321, 60, 14);
		getContentPane().add(lblLink);
		
		JLabel lblNicKnameOb = new JLabel("*");
		lblNicKnameOb.setBounds(31, 73, 11, 14);
		getContentPane().add(lblNicKnameOb);
		
		JLabel lblNombreOb = new JLabel("*");
		lblNombreOb.setBounds(31, 104, 11, 14);
		getContentPane().add(lblNombreOb);
		
		JLabel lblContraseniaOb = new JLabel("*");
		lblContraseniaOb.setBounds(31, 166, 11, 14);
		getContentPane().add(lblContraseniaOb);
		
		JLabel lblFechaNacOb = new JLabel("*");
		lblFechaNacOb.setBounds(31, 203, 11, 14);
		getContentPane().add(lblFechaNacOb);
		
		JLabel lblEmailOb = new JLabel("*");
		lblEmailOb.setBounds(31, 234, 11, 14);
		getContentPane().add(lblEmailOb);
		
		JLabel lblDescripcionOb = new JLabel("*");
		lblDescripcionOb.setBounds(31, 262, 11, 14);
		getContentPane().add(lblDescripcionOb);
		
		JLabel lblUsuarioOb = new JLabel("*");
		lblUsuarioOb.setBounds(31, 31, 11, 14);
		getContentPane().add(lblUsuarioOb);
		
		textField_Nickname = new JTextField();
		textField_Nickname.setBounds(132, 70, 177, 20);
		getContentPane().add(textField_Nickname);
		textField_Nickname.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(132, 101, 177, 20);
		getContentPane().add(textField_Nombre);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(132, 132, 177, 20);
		getContentPane().add(textField_Apellido);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(132, 231, 177, 20);
		getContentPane().add(textField_Email);
		
		textField_Descripcion = new JTextField();
		textField_Descripcion.setColumns(10);
		textField_Descripcion.setBounds(132, 262, 177, 20);
		getContentPane().add(textField_Descripcion);
		
		textField_Biografia = new JTextField();
		textField_Biografia.setColumns(10);
		textField_Biografia.setBounds(132, 290, 177, 20);
		getContentPane().add(textField_Biografia);
		
		textField_Link = new JTextField();
		textField_Link.setColumns(10);
		textField_Link.setBounds(132, 318, 177, 20);
		getContentPane().add(textField_Link);
		
		txtDia = new JTextField();
		txtDia.setBounds(165, 200, 30, 20);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(205, 200, 30, 20);
		getContentPane().add(txtMes);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(245, 200, 64, 20);
		getContentPane().add(txtAnio);
		
		Button button_Aceptar = new Button("Aceptar");
		button_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioAgrgarActionPerformed(arg0);
			}			
		});
		button_Aceptar.setBounds(70, 370, 102, 22);
		getContentPane().add(button_Aceptar);
		
		Button button_Cancelar = new Button("Cancelar");
		button_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUsuarioCancelarActionPerformed(arg0);
			}
		});
		button_Cancelar.setBounds(201, 370, 108, 22);
		getContentPane().add(button_Cancelar);
		

		JComboBox<String> comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxUsuario.getSelectedItem()=="Espectador"){
					textField_Descripcion.setText("");
					textField_Biografia.setText("");
					textField_Link.setText("");
					textField_Descripcion.setEnabled(false);
					textField_Biografia.setEnabled(false);
					textField_Link.setEnabled(false);
					lblDescripcionOb.setVisible(false);
				}
				if(comboBoxUsuario.getSelectedItem()=="Artista"){
					textField_Descripcion.setEnabled(true);
					textField_Biografia.setEnabled(true);
					textField_Link.setEnabled(true);
					lblDescripcionOb.setVisible(true);
				}
				
			}
		});
		comboBoxUsuario.setBounds(132, 27, 177, 22);
		comboBoxUsuario.addItem("Espectador");
		comboBoxUsuario.addItem("Artista");
		comboBoxUsuario.setSelectedItem("Espectador");
		getContentPane().add(comboBoxUsuario);
		
		textField_contrasenia = new JTextField();
		textField_contrasenia.setColumns(10);
		textField_contrasenia.setBounds(132, 163, 177, 20);
		getContentPane().add(textField_contrasenia);
		
		JLabel lblContrasenia = new JLabel("Contrasenia");
		lblContrasenia.setBounds(50, 166, 60, 14);
		getContentPane().add(lblContrasenia);
		
		JLabel lblApellidoOb = new JLabel("*");
		lblApellidoOb.setBounds(31, 135, 11, 14);
		getContentPane().add(lblApellidoOb);

	}
	
	private void altaUsuarioAgrgarActionPerformed(ActionEvent arg0) {
		
		String nickName = this.textField_Nickname.getText();
		String nombre = this.textField_Nombre.getText();
		String apellido = this.textField_Apellido.getText();
		String dia = this.txtDia.getText();
		String mes = this.txtMes.getText();
		String anio = this.txtAnio.getText();
		String email = this.textField_Email.getText();
		String descripcion = this.textField_Descripcion.getText();
		JTextField JTxtDescripcion = textField_Descripcion;
		String biografia = this.textField_Biografia.getText();
		String link = this.textField_Link.getText();
		String contrasenia = this.textField_contrasenia.getText();
		
		DTUsuarioBasico dt;
		LocalDate date;
	
		if (checkFormulario()) { 
			
        	date = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
			if(JTxtDescripcion.isEnabled()) {
				dt = new DTArtista(nickName, nombre, apellido, date,email,descripcion,biografia,link, contrasenia);
			}   	
	        else {
	        	dt = new DTEspectador(nickName, nombre, apellido, date,email, contrasenia);
	        }
	        try {
	        	this.iconAltaUsuario.agregarUsuario(dt);
	        	JOptionPane.showMessageDialog(this, "El Usuario se ha creado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
	        } catch (NicknameRepetidoException i) {
	        	JOptionPane.showMessageDialog(this, i.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
	        }catch (CorreoRepetidoException i) {
	        	JOptionPane.showMessageDialog(this, i.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
	        }
	        limpiarFormulario();
	        setVisible(false);
		}
}
	
	private boolean checkFormulario() {
		
		String nickName = this.textField_Nickname.getText();
		String nombre = this.textField_Nombre.getText();
		String apellido = this.textField_Apellido.getText();
		String email = this.textField_Email.getText();
		String descripcion = this.textField_Descripcion.getText();
		JTextField JTxtDescripcion = textField_Descripcion;
		String biografia = this.textField_Biografia.getText();
		String link = this.textField_Link.getText();
		String dia = this.txtDia.getText();
		String mes = this.txtMes.getText();
		String anio = this.txtAnio.getText();
		String contrasenia = this.textField_contrasenia.getText();
		
		LocalDate date;
		
		if(JTxtDescripcion.isEnabled()) {
			if(nickName.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || email.isEmpty()|| descripcion.isEmpty() || contrasenia.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Por favor completar campos con *", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
			}
		}
		else {
			if(nickName.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty() || email.isEmpty() || contrasenia.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor completar campos con *", "Alta Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
			}
		}
		
		try {
			date = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
		}catch (Exception dateE) {
			JOptionPane.showMessageDialog(this, "La fecha ingresada no es correcta", "Alta Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
        return true;
	}

	private void altaUsuarioCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private void limpiarFormulario() {
		textField_Nickname.setText("");
		textField_Nombre.setText("");
		textField_Apellido.setText("");
		textField_Email.setText("");
		textField_Descripcion.setText("");
		textField_Biografia.setText("");
		textField_Link.setText("");
		txtDia.setText("");
		txtMes.setText("");
		txtAnio.setText("");
		textField_contrasenia.setText("");
	 }
}