package logica.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Espectaculo {
	@Id
	private String nombre;
	private String descripcion;
	private String duracion;
	private String url;
	private float costo;
	private Integer cantMin;
	private Integer cantMax;
	private Date fechaRegistro;
	@OneToMany(cascade = CascadeType.ALL)

	private List<Funcion> funciones = new ArrayList<>();

	
	public Espectaculo() {
		super();
	}

	public Espectaculo(String nombre, String descripcion, String duracion, String url, float costo, Integer cantMin,
			Integer cantMax, Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.url = url;
		this.costo = costo;
		this.cantMin = cantMin;
		this.cantMax = cantMax;
		this.fechaRegistro = fechaRegistro;
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Integer getCantMin() {
		return cantMin;
	}

	public void setCantMin(Integer cantMin) {
		this.cantMin = cantMin;
	}

	public Integer getCantMax() {
		return cantMax;
	}

	public void setCantMax(Integer cantMax) {
		this.cantMax = cantMax;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public List<String> getFunciones() {
		//return funciones;
		List<String> nombresFunciones = new ArrayList<String>();
		for(Funcion i:funciones) {
			nombresFunciones.add(i.getNombre());
		}
		return nombresFunciones;
	}
	
	public void setFunciones(List<Funcion> f) {
		this.funciones = f;
	}
	
	public void agregarFuncion(Funcion f) {
		this.funciones.add(f);
		//f.setEespectaculo(this);
	}
	

	public Funcion buscarFuncion(String nombreF) {
		Funcion ret = null;
		for(int i=0;i<funciones.size();i++) {		
			if(funciones.get(i).getNombre().equals(nombreF))
				ret = funciones.get(i);
		}
		return ret;	
	}
}
