package logica.entidades;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity

public class Paquete {
	@Id
	private String nombre;
	private String descripcion;

	private int descuento;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos  = new ArrayList<>();

	
	public Paquete() {
		super();
	}
	public Paquete(String nombre, String descripcion, int descuento, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void agregarEspectaculo(Espectaculo espectaculo) {
		espectaculos.add(espectaculo);
	}
	
	public Boolean tieneEspectaculo (String nombreEspectaculo) {
		int i=0;
		Espectaculo e;
		boolean encontre=false;
		while((i<espectaculos.size()) && (!encontre)) {
			e=espectaculos.get(i);
			if(e.getNombre().equals(nombreEspectaculo)) {
				encontre=true;
			}
		}
		return encontre;
	}		

	public List<String> getEspectaculos() {
		List<String> nombresEspectaculos = new ArrayList<String>();
		for(Espectaculo e:espectaculos) {
			nombresEspectaculos.add(e.getNombre());
		}
		return nombresEspectaculos;
	}
	
}
