package ar.com.algo2.jcmd.dominio;

public class Argumento {
	
	private Long orden;
	private String tipo;
	private String descripcion;
	private Boolean optional;
	private Etiqueta etiqueta;
	
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
		
	@Override
	public String toString() {
		return "Argumento [orden=" + orden + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + ", optional=" + optional
				+ ", etiqueta=" + etiqueta.toString() + "]";
	}
	public Argumento() {}
}


