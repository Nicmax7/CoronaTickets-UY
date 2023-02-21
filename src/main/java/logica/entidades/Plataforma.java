package logica.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Plataforma {
	
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Espectaculo> espectaculos = new ArrayList<>();

	public Plataforma() {
		super();
	}

	public Plataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void agregarEspectaculo(Espectaculo esp) {
		espectaculos.add(esp);
	}

	public List<String> listarEspectaculos(){
		List<String> nombresEspectaculos = new ArrayList<String>();
		for(Espectaculo i:espectaculos) {
			nombresEspectaculos.add(i.getNombre());
		}
		return nombresEspectaculos;
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

}
