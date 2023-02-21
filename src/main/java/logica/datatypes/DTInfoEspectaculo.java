package logica.datatypes;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInfoEspectaculo {
	private String nombre;
	private String descripcion;
	private String duracion;
	private String url;
	private float costo;
	private Integer cantMin;
	private Integer cantMax;
	private Date fechaRegistro;
	
	public DTInfoEspectaculo(String nombre, String descripcion, String duracion, String url, float costo,
			Integer cantMin, Integer cantMax, Date fechaRegistro) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public String getDuracion() {
		return duracion;
	}

	public String getUrl() {
		return url;
	}

	public float getCosto() {
		return costo;
	}

	public Integer getCantMin() {
		return cantMin;
	}

	public Integer getCantMax() {
		return cantMax;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	@Override
	public String toString() {
		return "NOMBRE: " + nombre + "\nDESCRIPCION: " + descripcion + "\nDURACION: " + duracion + "\nURL: " + url + "\nCOSTO: " + costo + "\nCANTIDAD MINIMA: " + cantMin + "\nCANTIDAD MAXIMA: " + cantMax + "\nFECHA DE REGISTRO: " + fechaRegistro;
	}
	
	
	
}
