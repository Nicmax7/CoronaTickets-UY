package logica.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTFuncionWS {
	private String nombre;
	private String fecha;
	private String HoraInicio;
	private String fechaRegistro;
		
	public DTFuncionWS() {
		super();
	}
	
	public DTFuncionWS(String nombre, String fecha, String horaInicio, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.HoraInicio = horaInicio;
		this.fechaRegistro = fechaRegistro;
	}
	public String getNombre() {
		return nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHoraInicio() {
		return HoraInicio;
	}
	
	public String getfechaRegistro() {
		return fechaRegistro;
	}

	@Override
	public String toString() {
		return "NOMBRE: " + nombre + "\nFECHA: " + fecha + "\nHORA INICIO: " + HoraInicio + "\nFECHA REGISTRO: " + fechaRegistro;
	}
}
