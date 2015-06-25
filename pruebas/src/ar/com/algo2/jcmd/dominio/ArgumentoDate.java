package ar.com.algo2.jcmd.dominio;

import java.util.Date;

public class ArgumentoDate extends Argumento {

	private String formato;
	private Date valorFecha;

	public String getFormato() {
		return formato;
	}

	public Date getValorFecha() {
		return valorFecha;
	}

	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public ArgumentoDate(String formato) {
		super();
		this.formato = formato;
	}

	public ArgumentoDate() {}

	public ArgumentoDate(String nombre, String etiqueta, Boolean optional, String tipo, String valor, String formato) {
		super(nombre, etiqueta, optional, tipo, valor);
		this.formato = formato;
		this.valorFecha = null;
	}

	@Override
	public String toString() {
		return "ArgumentoDate [formato=" + formato + ", valorFecha="
				+ valorFecha + ", toString()=" + super.toString() + "]";
	}	
		
}
