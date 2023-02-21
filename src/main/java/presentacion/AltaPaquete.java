package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.datatypes.DTArtista;
import logica.datatypes.DTEspectador;
import logica.datatypes.DTPaquete;
import logica.excepciones.CorreoRepetidoException;
import logica.excepciones.NicknameRepetidoException;
import logica.excepciones.PaqueteRepetidoException;
import logica.interfaces.IControladorAltaPaquete;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private IControladorAltaPaquete iconAP;
	
	private JTextField Txt_nombre;
	private JTextField Txt_descripcion;
	private JTextField Txt_diaInicio;
	private JTextField Txt_mesInicio;
	private JTextField Txt_anioInicio;
	private JTextField Txt_diaFin;
	private JTextField Txt_mesFin;
	private JTextField Txt_anioFin;
	private JTextField Txt_descuento;
	private Button button_Cancelar;

	public AltaPaquete(IControladorAltaPaquete iconAP) {
		this.iconAP = iconAP;
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Crear un Paquete");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 53, 46, 14);
		getContentPane().add(lblNewLabel);
		
		Txt_nombre = new JTextField();
		Txt_nombre.setBounds(97, 50, 274, 20);
		getContentPane().add(Txt_nombre);
		Txt_nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Datos B\u00E1sicos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(41, 109, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		lblNewLabel_2.setBounds(71, 149, 84, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha Inicio");
		lblNewLabel_2_1.setBounds(71, 212, 84, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Fecha Fin");
		lblNewLabel_2_2.setBounds(71, 250, 84, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Descuento");
		lblNewLabel_2_3.setBounds(71, 291, 84, 14);
		getContentPane().add(lblNewLabel_2_3);
		
		Txt_descripcion = new JTextField();
		lblNewLabel_2.setLabelFor(Txt_descripcion);
		Txt_descripcion.setToolTipText("");
		Txt_descripcion.setBounds(165, 146, 237, 51);
		getContentPane().add(Txt_descripcion);
		Txt_descripcion.setColumns(10);
		
		Txt_diaInicio = new JTextField();
		Txt_diaInicio.setColumns(10);
		Txt_diaInicio.setBounds(165, 206, 30, 20);
		getContentPane().add(Txt_diaInicio);
		
		Txt_mesInicio = new JTextField();
		Txt_mesInicio.setColumns(10);
		Txt_mesInicio.setBounds(205, 206, 30, 20);
		getContentPane().add(Txt_mesInicio);
		
		Txt_anioInicio = new JTextField();
		Txt_anioInicio.setColumns(10);
		Txt_anioInicio.setBounds(245, 206, 64, 20);
		getContentPane().add(Txt_anioInicio);
		
		Txt_diaFin = new JTextField();
		Txt_diaFin.setColumns(10);
		Txt_diaFin.setBounds(165, 244, 30, 20);
		getContentPane().add(Txt_diaFin);
		
		Txt_mesFin = new JTextField();
		Txt_mesFin.setColumns(10);
		Txt_mesFin.setBounds(205, 244, 30, 20);
		getContentPane().add(Txt_mesFin);
		
		Txt_anioFin = new JTextField();
		Txt_anioFin.setColumns(10);
		Txt_anioFin.setBounds(245, 244, 64, 20);
		getContentPane().add(Txt_anioFin);
		
		Txt_descuento = new JTextField();
		Txt_descuento.setColumns(10);
		Txt_descuento.setBounds(165, 288, 64, 20);
		getContentPane().add(Txt_descuento);
		
		Button button_Aceptar = new Button("Aceptar");
		button_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaPaqueteActionPerformed(arg0);
			}
		});
		button_Aceptar.setBounds(95, 338, 100, 22);
		getContentPane().add(button_Aceptar);
		
		button_Cancelar = new Button("Cancelar");
		button_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaPaqueteCancelarActionPerformed(arg0);
			}
		});
		button_Cancelar.setBounds(240, 338, 100, 22);
		getContentPane().add(button_Cancelar);

	}
	
	private void altaPaqueteActionPerformed(ActionEvent arg0) {
		
		String nombre = this.Txt_nombre.getText();
		String descripcion = this.Txt_descripcion.getText();
		String diaInicio = this.Txt_diaInicio.getText();
		String mesInicio = this.Txt_mesInicio.getText();
		String anioInicio = this.Txt_anioInicio.getText();
		String diaFin = this.Txt_diaFin.getText();
		String mesFin = this.Txt_mesFin.getText();
		String anioFin = this.Txt_anioFin.getText();
		int descuento = Integer.parseInt(Txt_descuento.getText());
		
		LocalDate dateInicio;
		LocalDate dateFin;
		DTPaquete dtPaquete;
		
		if (checkFormulario()) { 
			
        	dateInicio = LocalDate.of(Integer.parseInt(anioInicio),  Integer.parseInt(mesInicio), Integer.parseInt(diaInicio));		
        	dateFin = LocalDate.of(Integer.parseInt(anioFin), Integer.parseInt(mesFin), Integer.parseInt(diaFin));
        	dtPaquete = new DTPaquete(nombre, descripcion, dateInicio, dateFin, descuento);

	        try {
	        	this.iconAP.agregarPaquete(dtPaquete);
	        	JOptionPane.showMessageDialog(this, "El Paquete se ha creado con exito", "Alta Paquete", JOptionPane.INFORMATION_MESSAGE);
	        } 
	        catch (PaqueteRepetidoException i) {
	        	JOptionPane.showMessageDialog(this, i.getMessage(), "Alta Paquete", JOptionPane.ERROR_MESSAGE);
	        }
	        limpiarFormulario();
	        setVisible(false);
		}
		
		
	}
	
private boolean checkFormulario() {
		
		String nombre = this.Txt_nombre.getText();
		String descripcion = this.Txt_descripcion.getText();
		String diaInicio = this.Txt_diaInicio.getText();
		String mesInicio = this.Txt_mesInicio.getText();
		String anioInicio = this.Txt_anioInicio.getText();
		String diaFin = this.Txt_diaFin.getText();
		String mesFin = this.Txt_mesFin.getText();
		String anioFin = this.Txt_anioFin.getText();
		String descuento = this.Txt_descuento.getText();

		LocalDate dateInicio;
		LocalDate dateFin;
		
		if(nombre.isEmpty() || descripcion.isEmpty() || descuento.isEmpty() || diaInicio.isEmpty() || mesInicio.isEmpty() || anioInicio.isEmpty() || diaFin.isEmpty() || mesFin.isEmpty() || anioFin.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Por favor completar campos", "Alta Paquete",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		
		try {
			dateInicio = LocalDate.of(Integer.parseInt(anioInicio),  Integer.parseInt(mesInicio), Integer.parseInt(diaInicio));
		}catch (Exception dateE) {
			JOptionPane.showMessageDialog(this, "La fecha de inicio ingresada no es correcta", "Alta Paquete",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try {
			dateFin = LocalDate.of(Integer.parseInt(anioFin), Integer.parseInt(mesFin), Integer.parseInt(diaFin));
		}catch (Exception dateE) {
			JOptionPane.showMessageDialog(this, "La fecha de fin ingresada no es correcta", "Alta Paquete",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
        return true;
	}

	private void altaPaqueteCancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
        setVisible(false);
	}
	
	private void limpiarFormulario() {
		Txt_nombre.setText("");
		Txt_descripcion.setText("");
		Txt_diaInicio.setText("");
		Txt_mesInicio.setText("");
		Txt_anioInicio.setText("");
		Txt_diaFin.setText("");
		Txt_mesFin.setText("");
		Txt_anioFin.setText("");
		Txt_descuento.setText("");
	 }
}
