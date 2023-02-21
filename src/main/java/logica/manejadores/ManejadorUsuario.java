package logica.manejadores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.datatypes.DTModificarUsuario;
import logica.entidades.Espectaculo;
import logica.entidades.Plataforma;
import logica.entidades.Usuario;
import persistencia.Conexion;

public class ManejadorUsuario {

	private static ManejadorUsuario instancia = null;
	
	private ManejadorUsuario(){}
	
	public static ManejadorUsuario getInstancia() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia; 
	}

	public void agregarUsuario(Usuario usuario) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario buscarUsuario(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, nombre);
		return usuario;
	}
	
	public void actualizarUsuario(DTModificarUsuario usuarioModificado) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario = em.find(Usuario.class, usuarioModificado.getNickname());
		usuario.setNombre(usuarioModificado.getNombre());
		usuario.setApellido(usuarioModificado.getApellido());
		usuario.setContrasenia(usuarioModificado.getContrasenia());
		usuario.setfechaNac(usuarioModificado.getFechaNacimiento());
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	public Boolean obtenerUsuarioPorCorreo(String mail) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		for(Usuario u:listUsuario) {
			if(u.getEmail().equals(mail)) {
				return true;
			}
		}
		return false;
	}
	
	public Usuario buscarUsuarioPorCorreo(String correo) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u");
		Usuario usuario = null;
		List<Usuario> listUsuario = (List<Usuario>) query.getResultList();
		for(Usuario u:listUsuario) {
			if(u.getEmail().equals(correo)) {
				usuario = u;
			}
		}
		return usuario;
	}
	
	public ArrayList<String> obtenerUsuarios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u");	
		List<Usuario> listUsuarios = query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Usuario u:listUsuarios) {
				aRetornar.add(u.getNickname());
		}		
		return aRetornar;
	}

	public List<String> obtenerSeguidos(String nickUsuario){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Usuario usuario= em.find(Usuario.class, nickUsuario);
		List<String> usuarioSeguidos = usuario.listarSeguidos();
		return usuarioSeguidos;
	}
	
	public void actualizarSeguidos(Usuario u) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public String[] traerNoSeguidos(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u.nickname\r\n"
				+ "from usuario u\r\n"
				+ "where u.nickname not in (\r\n"
				+ "	select uu.seguidos_nickname\r\n"
				+ "	from usuario_usuario uu\r\n"
				+ "	where uu.usuario_nickname = '"+nickname+"' \r\n"
				+ ")\r\n"
				+ "and u.nickname != '"+nickname+"'");	
		List<Usuario> listUsuarios = query.getResultList();
		String[] aRetornar = new String[listUsuarios.size()];
		int i=0;
		for(Usuario u:listUsuarios) {
				aRetornar[i] = u.getNickname();
				i++;
		}		
		return aRetornar;
	}
	
	
}
