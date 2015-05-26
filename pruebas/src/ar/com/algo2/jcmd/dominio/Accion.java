package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Accion {
	
	private String nombre;
	private List<Parametro> parametros = new ArrayList<Parametro>();
	private List<Constante> constantes = new ArrayList<Constante>();
	
	public List<Parametro> getParametros() {
		return parametros;
	}
	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}
	public List<Constante> getConstantes() {
		return constantes;
	}
	public void setConstantes(List<Constante> constantes) {
		this.constantes = constantes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void addParametro(Parametro parametro) {
		this.parametros.add(parametro);
	}
	
	public void addConstante(Constante constante) {
		this.constantes.add(constante);
	}
	
	@Override
	public String toString() {
		
		StringBuffer buff1 = new StringBuffer();
		
		for (Parametro param: this.parametros)
			buff1.append(param.toString()).append(",");
		
		StringBuffer buff2 = new StringBuffer();
		
		for (Constante constante: this.constantes)
			buff2.append(constante.toString()).append(",");

		
		return "Accion [nombre=" + nombre  + ", parametros=" + buff1.toString() + ", constantes=" + buff2.toString() + "]";
	}
	
	

}
