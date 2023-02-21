package logica.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcion {
	@Id
	private String nombre;
	private LocalDateTime fecha;
	private LocalDate fechaRegistro;
	//@ManyToMany(mappedBy = "funcioones")
	//private List<Artista> artistas = new ArrayList<>();
	private String artista;
	
	public Funcion() {
		super();
	}
	
	public Funcion(String nombre, LocalDateTime fechaFunc, LocalDate fechaReg) {
		super();
		this.nombre = nombre;
		this.fecha = fechaFunc;
		this.fechaRegistro = fechaReg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setArtistas(String a) {
		this.artista = a;
	}	
	
	public String getArtistas() {
		return artista;
	}	
}
