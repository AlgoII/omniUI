package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Argumento {
	
	private Long orden;
	private String tipo;
	private String descripcion;
	private Boolean optional;
	private Etiqueta etiqueta;
	private List<Regla> reglas = new ArrayList<Regla>();
	
	public Long getOrden() {
		return orden;
	}
	public Etiqueta getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}
	public void setOrden(Long orden) {
		this.orden = orden;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getOptional() {
		return optional;
	}
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	public void addRegla(Regla regla) {
		this.reglas.add(regla);
	}		
	public List<Regla> getReglas() {
		return reglas;
	}
	public void setReglas(List<Regla> reglas) {
		this.reglas = reglas;
	}
	
	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		
		for (Regla regla: this.reglas)
			buff.append(regla.toString()).append(",");
		
		return "Argumento [orden=" + orden + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + ", optional=" + optional
				+ ", etiqueta=" + etiqueta.toString() + ", reglas=" + buff.toString() + "]";
	}
	public Argumento() {}
}


