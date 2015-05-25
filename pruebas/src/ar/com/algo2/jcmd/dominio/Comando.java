package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Comando {

	private String nombre;
	private String alias;
	private String descripcion;
	private String output;

	private List<Aplicacion> aplicaciones = new ArrayList<Aplicacion>();
	
	public Comando(String nombre, String alias, String descripcion,
			String output, List<Aplicacion> aplicaciones) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.descripcion = descripcion;
		this.output = output;
		this.aplicaciones = aplicaciones;
	}
	
	public Comando() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public List<Aplicacion> getAplicaciones() {
		return aplicaciones;
	}
	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}
	
	public void addAplicacion(Aplicacion aplicacion) {
		this.aplicaciones.add(aplicacion);
	}

	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		for (Aplicacion a: this.aplicaciones)
			buff.append(a.toString()).append("\n");
		
		return "Comando [nombre=" + nombre + ", alias=" + alias
				+ ", descripcion=" + descripcion + ", output=" + output
				+ ", aplicaciones=" + "[\n" + buff.toString() + "]";
	}
	
		
	
	
}
