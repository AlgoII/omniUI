package ar.com.ejemplo.swing.domain;

//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
//import java.io.Serializable;

@SuppressWarnings("serial")
//public class Argumento implements Serializable {
public class Argumento {
	
	private String etiqueta;
	private String valor;
	private Boolean optional;
	
//	private PropertyChangeSupport support = new PropertyChangeSupport(this);

	public String getEtiqueta() {
		return etiqueta;
	}
	
	public void setEtiqueta(String etiqueta) {
//		String old = this.etiqueta;
		this.etiqueta = etiqueta;
//		support.firePropertyChange("etiqueta",old,etiqueta);
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
//		String old = this.valor;
		this.valor = valor;
//		support.firePropertyChange("valor",old,valor);
	}
	
	public Boolean getOptional() {
		return optional;
	}
	
	public void setOptional(Boolean optional) {
//		Boolean old = this.optional;
		this.optional = optional;
//		support.firePropertyChange("optional",old,optional);
	}
	
	public Argumento() {}
	
	public Argumento(String etiqueta, String valor, Boolean optional) {
		super();
		this.etiqueta = etiqueta;
		this.valor = valor;
		this.optional = optional;
	}
	
//	public void addPropertyChangeListener(PropertyChangeListener listener) {
//		this.support.addPropertyChangeListener(listener);
//	}
//
//	public void removePropertyChangeListener(PropertyChangeListener listener) {
//		this.support.removePropertyChangeListener(listener);
//	}
	
	@Override
	public String toString() {
		return "Argumento [etiqueta=" + etiqueta + ", valor=" + valor + ", optional=" + optional + "]";
	}

}
