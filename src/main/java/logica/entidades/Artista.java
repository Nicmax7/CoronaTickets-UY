package logica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Artista extends Usuario {

	private String descripcion;
	private String biografia;
	private String link;

	//@ManyToMany(cascade = CascadeType.ALL)
	//private List<Funcion> funcioones = new ArrayList<>();
	@OneToMany
	private List<Espectaculo> organizador = new ArrayList<>();
	

	public Artista() {
		super();
	}	
	
	public Artista(String nickname, String nombre, String apellido,LocalDate fechaNac, String email, String descripcion,
			String biografia, String link, String contrasenia) {
		super(nickname, nombre, apellido, fechaNac, email, contrasenia);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.link = link;
	}
	
	public Artista(String descripcion, String biografia, String link) {
		super();
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.link = link;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	/*
	public void agregarFuncion(Funcion funcion) {
		this.funcioones.add(funcion);
	}
	*/
	
	public void organizarEspectaculo(Espectaculo espectaculo) {
		organizador.add(espectaculo);
	}
	
	public List<String> getEspectaculos() {
		List<String> nombresEspectaculos = new ArrayList<String>();
		for(Espectaculo e:organizador) {
			nombresEspectaculos.add(e.getNombre());
		}
		return nombresEspectaculos;
	}
	
}
