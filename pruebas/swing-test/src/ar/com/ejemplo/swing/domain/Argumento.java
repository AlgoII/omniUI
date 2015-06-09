package ar.com.ejemplo.swing.domain;


public class Argumento {
	
	private String etiqueta;
//	private String valor;
	private Boolean optional;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
//	public String getValor() {
//		return valor;
//	}
//	public void setValor(String valor) {
//		this.valor = valor;
//	}
	
	public Boolean getOptional() {
		return optional;
	}
	
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	
	public Argumento() {}
	
	public Argumento(String etiqueta, Boolean optional, String tipo) {
		super();
		this.etiqueta = etiqueta;
		this.optional = optional;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Argumento [etiqueta=" + etiqueta + ", optional=" + optional	+ ", tipo=" + tipo + "]";
	}



}
