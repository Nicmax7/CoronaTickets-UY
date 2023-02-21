package presentacion;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import logica.datatypes.DTFuncionE;
import logica.excepciones.FuncionRepetidaException;
import logica.interfaces.IControladorAltaEspectaculo;
import logica.interfaces.IControladorAltaFuncionEspectaculo;
import logica.interfaces.IControladorConsultaPlataforma;




public class AltaFuncionEspectaculo extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static IControladorAltaFuncionEspectaculo iconAFE;
	private static IControladorAltaEspectaculo iconAE;
	private IControladorConsultaPlataforma iconCP;
	
	private JComboBox<String> cbPlataforma;
	private JComboBox<String> cbEspectaculo;
	private JComboBox<String> cbArtistas;
	private JTextField tfNombreFuncion;
	
	/*JSpinner para Hora, Minuto, Dia, Mes y Año*/
	private JSpinner spinnerM;
	private JSpinner spinnerH;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	
	//List<String> artistas = new ArrayList<>();
	//DefaultTableModel modelTableA = null;
	DefaultComboBoxModel<String> modelClear = new DefaultComboBoxModel<String>();
	//boolean aux = false;

	//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	

	public AltaFuncionEspectaculo(IControladorAltaFuncionEspectaculo iconAFE, IControladorConsultaPlataforma iconCP, IControladorAltaEspectaculo iconAE) {
		setSize(new Dimension(476, 473));
		setPreferredSize(new Dimension(531, 550));
		setNormalBounds(new Rectangle(10, 10, 531, 550));
		setMinimumSize(new Dimension(531, 550));
		setMaximumSize(new Dimension(531, 550));
		this.iconAFE = iconAFE;
		this.iconCP = iconCP;
		this.iconAE = iconAE;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar una Funcion");
		setBounds(100, 100, 509, 518);
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel_1_1 = new JLabel("Artista seleccionado");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(96, 268, 284, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ALTA FUNCI\u00D3N DE ESPECT\u00C1CULO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(78, 11, 284, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha Funci\u00F3n");
		lblNewLabel_3.setBounds(66, 173, 94, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Hora Inicio");
		lblNewLabel_4.setBounds(66, 209, 82, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Funci\u00F3n");
		lblNewLabel_2.setBounds(66, 72, 89, 14);
		getContentPane().add(lblNewLabel_2);
				
		JLabel lblEspectculo = new JLabel("Espect\u00E1culo");
		lblEspectculo.setBounds(66, 138, 77, 14);
		getContentPane().add(lblEspectculo);
		
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(66, 105, 77, 14);
		getContentPane().add(lblNewLabel);
		
		cbEspectaculo = new JComboBox<String>();
		cbEspectaculo.setBounds(167, 134, 213, 22);
		getContentPane().add(cbEspectaculo);
		
		cbPlataforma = new JComboBox<String>();
		cbPlataforma.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconAFE.consultarEspectaculosPlataforma(cbPlataforma.getSelectedItem().toString()));
				cbEspectaculo.setModel(modelEspectaculo);	
			}
		});
		cbPlataforma.setBounds(167, 101, 213, 22);
		getContentPane().add(cbPlataforma);

		
		cbArtistas = new JComboBox<String>();
		cbArtistas.setBounds(96, 310, 284, 22);
		getContentPane().add(cbArtistas);
		
		tfNombreFuncion = new JTextField();
		tfNombreFuncion.setBounds(168, 69, 212, 20);
		getContentPane().add(tfNombreFuncion);
		tfNombreFuncion.setColumns(10);
		
		spinnerH = new JSpinner();
		spinnerH.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinnerH.setBounds(167, 206, 52, 20);
		getContentPane().add(spinnerH);
		
		spinnerM = new JSpinner();
		spinnerM.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinnerM.setBounds(229, 206, 52, 20);
		getContentPane().add(spinnerM);
		

		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo para cuando se acepta
				try {
					agregarFuncionEspectaculoAceptarActionPerformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAceptar.setBounds(96, 367, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					limpiarFormularios();
					setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancelar.setBounds(291, 367, 89, 23);
		getContentPane().add(btnCancelar);
		
		txtDia = new JTextField();
		txtDia.setBounds(167, 170, 52, 25);
		getContentPane().add(txtDia);
		txtDia.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(229, 170, 52, 25);
		getContentPane().add(txtMes);
		
		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(291, 170, 75, 25);
		getContentPane().add(txtAnio);
	}
		
	private void agregarFuncionEspectaculoAceptarActionPerformed(ActionEvent arg0) throws Exception {
		
		//Nombre Espectaculo y Nombre de Funcion
		String nombreEspectaculo;
		String nombreFuncion;
		
		//Fecha del momento en el cual se hizo el registro
		LocalDate fechaRegistro = LocalDate.now();
		
		nombreEspectaculo = cbEspectaculo.getSelectedItem().toString();
		nombreFuncion = tfNombreFuncion.getText();
		
		//Construccion de fecha

		String dia = this.txtDia.getText();
		String mes = this.txtMes.getText();
		String anio = this.txtAnio.getText();
		
		//Construccion de Hora
		int hora = (int)spinnerH.getValue();
		int minuto = (int)spinnerM.getValue();
		
		//Construccion de fecha + horaInicio = fechaFuncion
		LocalDate fecha = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
		LocalTime horaInicio = LocalTime.of(hora, minuto);
		LocalDateTime fechaFuncion = LocalDateTime.of(fecha, horaInicio);
		
		//Construccion de artista
		String artista = cbArtistas.getSelectedItem().toString();
		
		//Construccion DTFuncion
		DTFuncionE dtF = new DTFuncionE(nombreFuncion, fechaFuncion.toString(), fechaRegistro.toString(), nombreEspectaculo, artista);
		
		try {
			iconAFE.ingresarFuncionEspectaculo(dtF);
			JOptionPane.showMessageDialog(null, "Se agrega con exito la funcion: " + nombreFuncion, "Alta Funcion" , JOptionPane.INFORMATION_MESSAGE);
			limpiarFormularios();
			setVisible(false);
		} catch (FuncionRepetidaException msg) {
			JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Funcion", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void inicializarComboBoxes() throws Exception {	
		try {
			DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconCP.listarPlataformas());
			cbPlataforma.setModel (modelPlataforma);
			
			DefaultComboBoxModel<String> modelArtista = new DefaultComboBoxModel<String>(iconAE.listarArtistas());
			cbArtistas.setModel(modelArtista);	
			
			/*
			for (int i=0;i<artistas.size();i++) {
				System.out.println(artistas.get(i));
			}
			*/
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Faltan ingresar datos de Plataformas y/o Artistas", "No hay datos" , JOptionPane.ERROR_MESSAGE);
			throw new Exception();
		}	
	}
	
	public void limpiarFormularios() throws Exception {
		//Metodo para limpiar formularios
		tfNombreFuncion.setText("");
		spinnerM.setValue(0);
		spinnerH.setValue(0);
		txtDia.setText("");
		txtMes.setText("");
		txtAnio.setText("");
		cbEspectaculo.setModel (modelClear);
		cbPlataforma.setModel (modelClear);
		cbArtistas.setModel (modelClear);
		//artistas.clear();
		/*
		if(modelTableA != null)
			modelTableA.setRowCount(0);
		*/
	}	
}
