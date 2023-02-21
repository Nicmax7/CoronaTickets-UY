package logica.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.interfaces.IControladorConsultaPlataforma;
import logica.manejadores.ManejadorPlataforma;


public class ControladorConsultaPlataforma implements IControladorConsultaPlataforma{
	
	public ControladorConsultaPlataforma() {
		super();
	}
	
	@Override
	public String[] listarPlataformas() {
		ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		ArrayList<String> p;
		p = mP.obtenerPlataformas();
		String[] plataformas = new String[p.size()];
		int i=0;
		for(String aux:p) {
			plataformas[i] =aux;
			i++;
		}
		return plataformas;
	}
}
