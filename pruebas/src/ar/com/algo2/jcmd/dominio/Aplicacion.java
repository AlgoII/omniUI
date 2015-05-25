package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {
	
	private String nombre;
	private String descripcion;
	private Comando comando;
	private List<Argumento> argumentos = new ArrayList<Argumento>();
	
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
	public void addArgumento(Argumento a) {
		this.argumentos.add(a);
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
		
		
		return "Aplicacion [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", comando.nombre=" + this.comando.getNombre() +  ", argumentos=" + "[\n" + buff.toString() +   "]";
		
		
	}
	
}
