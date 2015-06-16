package ar.com.ejemplo.swing.domain;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

	private String nombre;
	private String descripcion;
	private List<Argumento> argumentos;

	public Aplicacion(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.argumentos = new ArrayList<Argumento>();
	}
	public List<Argumento> getArgumentos() {
		return argumentos;
	}	
	public void addArgumento(Argumento argumento) {
		this.argumentos.add(argumento);
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

}
