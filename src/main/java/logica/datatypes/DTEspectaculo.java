package logica.datatypes;

import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTEspectaculo {

    private String nombre;
    private String descripcion;
    private String duracion;
    private String url;
    private float costo;
    private Integer cantMin;
    private Integer cantMax;
    private Calendar fechaRegistro;

    public DTEspectaculo() {
		super();
	}

	public DTEspectaculo(String nombre, String descripcion, String duracion, String url, float costo, Integer cantMin, Integer cantMax, Calendar fechaRegistro) {
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

    public Calendar getFechaRegistro() {
        return fechaRegistro;
    }
    
    public String toString() {
		return "NOMBRE: " + nombre + "\nDESCRIPCION: " + descripcion + "\nDURACION: " + duracion + "\nURL: " + url + "\nCOSTO: " + costo + "\nCANTIDAD MINIMA: " + cantMin + "\nCANTIDAD MAXIMA: " + cantMax + "\nFECHA DE REGISTRO: " + fechaRegistro;
	}
}
