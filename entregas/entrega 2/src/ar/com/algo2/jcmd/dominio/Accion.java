package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Accion {

	private String nombre;
	private List<ParametroValidacion> parametros = new ArrayList<ParametroValidacion>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ParametroValidacion> getParametros() {
		return parametros;
	}
	public void setParametros(List<ParametroValidacion> parametros) {
		this.parametros = parametros;
	}

	public void addParametro(ParametroValidacion parametro) {
		this.parametros.add(parametro);
	}


	@Override
	public String toString() {

		StringBuffer buff = new StringBuffer();

		for (ParametroValidacion param: this.parametros)
			buff.append(param.toString()).append(",");

		return "Accion [nombre=" + nombre  + ", parametros=" + buff.toString() + "]";		

	}

}
