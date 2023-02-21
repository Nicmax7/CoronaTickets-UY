package presentacion;

import javax.swing.JInternalFrame;

import logica.datatypes.DTModificarUsuario;
import logica.interfaces.IControladorModificarUsuario;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ModificarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private IControladorModificarUsuario iconMU;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtContrasenia;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JComboBox<String> cmbUsuarios;
	private JButton btnCargarDatos;
	private JLabel lblNickname;
	
	public ModificarUsuario(IControladorModificarUsuario iconMU) {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Modificar Usuario");
		
		this.iconMU = iconMU;
		
		setBounds(100, 100, 395, 543);
		getContentPane().setLayout(null);
		
		cmbUsuarios = new JComboBox();
		cmbUsuarios.setBounds(45, 38, 273, 31);
		getContentPane().add(cmbUsuarios);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(45, 11, 52, 28);
		getContentPane().add(lblUsuarios);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(45, 163, 52, 28);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(45, 188, 273, 31);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(45, 230, 52, 28);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(45, 254, 273, 31);
		getContentPane().add(txtApellido);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(45, 323, 273, 31);
		getContentPane().add(txtContrasenia);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(45, 296, 70, 28);
		getContentPane().add(lblContrasenia);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(45, 365, 132, 43);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(45, 397, 78, 31);
		getContentPane().add(txtDia);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(133, 397, 78, 31);
		getContentPane().add(txtMes);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(221, 397, 97, 31);
		getContentPane().add(txtAnio);
		
		JButton btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					actualizarDatosActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificarDatos.setBounds(45, 464, 273, 23);
		getContentPane().add(btnModificarDatos);
		
		btnCargarDatos = new JButton("Cargar Datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarDatosUsuarioActionPerfomed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCargarDatos.setBounds(86, 80, 184, 23);
		getContentPane().add(btnCargarDatos);
		
		lblNickname = new JLabel("");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNickname.setBounds(45, 121, 273, 31);
		getContentPane().add(lblNickname);

	}
	
	
	//Funciones
	
	public void inicializarComboBoxes() throws Exception {
		try {
			DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(iconMU.listarUsuarios());
			cmbUsuarios.setModel(modelUsuarios);
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan Usuarios ingresados", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}		
	}
	
	private void cargarDatosUsuarioActionPerfomed(ActionEvent e) throws Exception {
		
		if(checkFormulario()) {
			String strUsuario = this.cmbUsuarios.getSelectedItem().toString();
			DTModificarUsuario usuario = iconMU.consultarUsuario(strUsuario);
			
			lblNickname.setText(usuario.getNickname());
			txtNombre.setText(usuario.getNombre());
			txtApellido.setText(usuario.getApellido());
			txtContrasenia.setText(usuario.getContrasenia());
			
			int dia = usuario.getFechaNacimiento().getDayOfMonth();
			int mes = usuario.getFechaNacimiento().getMonthValue();
			int anio = usuario.getFechaNacimiento().getYear();
			
			txtDia.setText(Integer.toString(dia));
			txtMes.setText(Integer.toString(mes));
			txtAnio.setText(Integer.toString(anio));
			
		}
		
	}
	
	private void actualizarDatosActionPerformed(ActionEvent e) throws Exception {
		if(checkFormulario()) {
			String nickname = lblNickname.getText();
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String contrasenia = txtContrasenia.getText();
			String dia = txtDia.getText();
			String mes = txtMes.getText();
			String anio = txtAnio.getText();
			
			LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
			
			DTModificarUsuario dtUsuario = new DTModificarUsuario(nickname,nombre,apellido,contrasenia,fechaNacimiento);
			this.iconMU.actualizarUsuario(dtUsuario);
			JOptionPane.showMessageDialog(this, "El Usuario se ha modificado con exito", "Alta Usuario", JOptionPane.INFORMATION_MESSAGE);
		}
		limpiarFormulario();
		setVisible(false);
	}
	
	private boolean checkFormulario() throws Exception {
		
		try {
			String strUsuario = this.cmbUsuarios.getSelectedItem().toString();
			if(strUsuario.isEmpty()) {
				return false;
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "El campo Usuario esta vacio", "Modificar Usuario",JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}
		
		return true;

	}
	
	private void limpiarFormulario() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtContrasenia.setText("");
		txtDia.setText("");
		txtMes.setText("");
		txtAnio.setText("");
	}
	
}
