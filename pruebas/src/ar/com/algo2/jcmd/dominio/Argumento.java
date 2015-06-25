package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class Argumento {
	
	private Long orden;
	private String tipo;
	private String descripcion;
	private Boolean optional;
	private String etiqueta;
	private String alternativo;
	private Boolean auxiliar;
	private Boolean habilitado;
	private String separador;
	private String nombre;
	private String valor; //cada tipo en particular tiene su valor en ese tipo (por ej. ArgumentoDate tiene un valor de tipo Date //TODO: ¿el xstream se banca agregar atributos? 
	private List<Regla> reglas = new ArrayList<Regla>();

	public String getAlternativo() {
		return alternativo;
	}
	public void setAlternativo(String alternativo) {
		this.alternativo = alternativo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Boolean getAuxiliar() {
		return auxiliar;
	}
	public void setAuxiliar(Boolean auxiliar) {
		this.auxiliar = auxiliar;
	}
	public Boolean getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	public String getSeparador() {
		return separador;
	}
	public void setSeparador(String separador) {
		this.separador = separador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public Long getOrden() {
		return orden;
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
				
		return "Argumento [valor=" + valor + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + ", optional=" + optional
				+ ", etiqueta=" + etiqueta + ", reglas=" + buff.toString()
				+ ", alternativo=" + alternativo + ", auxiliar=" + auxiliar
				+ ", habilitado=" + habilitado + ", separador=" + separador
				+ ", nombre=" + nombre + ", orden=" + orden +
				"]";
	}
	
	public Argumento() {}

	public Argumento(String nombre, String etiqueta, Boolean optional, String tipo, String valor) {
		this.etiqueta=etiqueta;
		this.nombre=nombre;
		this.optional=optional;
		this.tipo=tipo;
		this.valor=valor;
	}
	
	public Regla getUltimaRegla() {
		return this.reglas.get(this.reglas.size()-1);
	}
	
}


