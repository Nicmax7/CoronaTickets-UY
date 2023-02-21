package logica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
    private String nickname;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String email;
    private String contrasenia;
    
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<>();
    
    public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, LocalDate fechaNac, String email, String contrasenia) {
        super();
		this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getfechaNac() {
        return fechaNac;
    }

    public void setfechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}    
	
	public void setSeguidos(List<Usuario> s) {
		this.seguidos = s;
	}	
	
	public List<Usuario> getSeguidos() {
		return seguidos;
	}	
	
	public List<String> listarSeguidos(){
		List<String> nombreSeguidos = new ArrayList<String>();
		for(Usuario i:seguidos) {
			nombreSeguidos.add(i.getNickname());
		}
		return nombreSeguidos;
	}
}
