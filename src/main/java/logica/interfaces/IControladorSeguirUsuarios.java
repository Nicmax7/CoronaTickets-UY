package logica.interfaces;

public interface IControladorSeguirUsuarios {
	public void seguirUsuario(String nombreUsuario, String nombreSeguido);
	public void dejarSeguirUsuario(String nombreUsuario, String nombreSeguido);
	public String[] listarSeguidos(String nombreUsuario);
	public String[] listarNoSeguidos(String nombreUsuario);


}
