package ar.com.ejemplo.swing.domain;

public class Argumento {

	private String etiqueta;
	private String valor;
	private Boolean optional;

	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Boolean getOptional() {
		return optional;
	}
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	public Argumento() {}
	
	public Argumento(String etiqueta, String valor, Boolean optional) {
		super();
		this.etiqueta = etiqueta;
		this.valor = valor;
		this.optional = optional;
	}
	@Override
	public String toString() {
		return "Argumento [etiqueta=" + etiqueta + ", valor=" + valor + ", optional=" + optional + "]";
	}

}
