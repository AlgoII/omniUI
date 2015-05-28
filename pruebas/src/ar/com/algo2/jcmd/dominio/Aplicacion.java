package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
	
	private String nombre;
	private String descripcion;
	private Comando comando;
	private List<Argumento> argumentos = new ArrayList<Argumento>();
	private List<Validacion> validaciones = new ArrayList<Validacion>();
	
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
	public Comando getComando() {
		return comando;
	}
	public void setComando(Comando comando) {
		this.comando = comando;
	}	
	public List<Argumento> getArgumentos() {
		return argumentos;
	}
	public void setArgumentos(List<Argumento> argumentos) {
		this.argumentos = argumentos;
	}	
	
	public List<Validacion> getValidaciones() {
		return validaciones;
	}
	public void setValidaciones(List<Validacion> validaciones) {
		this.validaciones = validaciones;
	}
	public void addArgumento(Argumento a) {
		this.argumentos.add(a);
	}
	public void addValidacion(Validacion a) {
		this.validaciones.add(a);
	}
	
	public Aplicacion(String nombre, String descripcion,
			List<Argumento> argumentos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.argumentos = argumentos;
	}
	
	public Aplicacion() {}
	
	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		
		for (Argumento a: this.argumentos)
			buff.append(a.toString()).append("\n");
		
		StringBuffer buff2 = new StringBuffer();

		for (Validacion a: this.validaciones)
			buff2.append(a.toString()).append(",");
		
		return "Aplicacion [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", comando.nombre=" + this.comando.getNombre() +  ", argumentos=" + "[\n" + buff.toString() + ", validaciones=" + "[" + buff2.toString() +  "]";		
		
	}
	
	public Validacion getUltimaValidacion() {
		return this.validaciones.get(this.validaciones.size()-1);
	}
	public Argumento getUltimoArgumento() {
		return this.argumentos.get(this.argumentos.size()-1);
	}
	
}
