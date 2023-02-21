package logica.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DTFuncion {
	private String nombre;
	private LocalDate fecha;
	private LocalTime HoraInicio;
	private LocalDate fechaRegistro;
		
	public DTFuncion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalDate fechaRegistro) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.HoraInicio = horaInicio;
		this.fechaRegistro = fechaRegistro;
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public LocalTime getHoraInicio() {
		return HoraInicio;
	}
	
	public LocalDate getfechaRegistro() {
		return fechaRegistro;
	}
	@Override
	public String toString() {
		return "NOMBRE: " + nombre + "\nFECHA: " + fecha + "\nHORA INICIO: " + HoraInicio + "\nFECHA REGISTRO: " + fechaRegistro;
	}
}
