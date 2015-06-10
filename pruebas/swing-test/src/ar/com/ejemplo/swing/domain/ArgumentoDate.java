package ar.com.ejemplo.swing.domain;

import java.util.Date;

public class ArgumentoDate extends Argumento {

	private Date valor;
	private String formato;

	public Date getValor() {
		return valor;
	}
	public void setValor(Date valor) {
		this.valor = valor;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public ArgumentoDate() {
		super();
	}

	public ArgumentoDate(String etiqueta, Boolean optional, String tipo, String formato) {
		super(etiqueta, optional, tipo);
		this.formato = formato;
	}
	
	@Override
	public String toString() {
		return "ArgumentoDate [valor=" + valor + ", formato=" + formato	+ ", toString()=" + super.toString() + "]";
	}
	
	


}
