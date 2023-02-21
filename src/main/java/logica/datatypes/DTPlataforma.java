package logica.datatypes;

public class DTPlataforma {

	private String nombrePlataforma;
	private String descripcion;
	private String url;
	
	public DTPlataforma(String nombrePlataforma, String descripcion, String url) {
		super();
		this.nombrePlataforma = nombrePlataforma;
		this.descripcion = descripcion;
		this.url = url;
	}

	public String getNombrePlataforma() {
		return nombrePlataforma;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}
	
}
