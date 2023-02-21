package logica.datatypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTFuncionE {
	private String nombreFuncion;
	private String fechaFunc;
	private String fechaReg;
	private String nombreEspectaculo;
	private String artistas;
		
	public DTFuncionE() {
		super();
	}

	public DTFuncionE(String nombreFuncion, String fechaFunc, String fechaReg, String nombreEspectaculo, String artistas) {
		super();
		this.nombreFuncion = nombreFuncion;
		this.fechaFunc = fechaFunc;
		this.fechaReg = fechaReg;
		this.nombreEspectaculo = nombreEspectaculo;
		this.artistas = artistas;
	}

	public String getNombreFuncion() {
		return nombreFuncion;
	}

	public String getFechaFunc() {
		return fechaFunc;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public String getNombreEspectaculo() {
		return nombreEspectaculo;
	}

	public String getArtistas() {
		return artistas;
	}
}
