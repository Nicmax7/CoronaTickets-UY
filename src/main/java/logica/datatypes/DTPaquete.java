package logica.datatypes;

import java.time.LocalDate;

public class DTPaquete {
	
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String descuento;
	
	
	public DTPaquete(String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, int descuento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = Integer.toString(descuento);
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public String getDescuento() {
		return descuento;
	}
	@Override
	public String toString() {
		return "NOMBRE: " + nombre + "\nDESCRICPION: " + descripcion + "\nFECHA INICIO: " + fechaInicio + "\nFECHA FIN: " + fechaFin + "\nDESCUENTO: " + descuento + "%";
	}
	
	
}
