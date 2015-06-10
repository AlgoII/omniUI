package ar.com.ejemplo.swing.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		DateFormat df;

		if (this.formato != null && !this.formato.equalsIgnoreCase(""))		
			df = new SimpleDateFormat(this.formato);
		else 
			df = new SimpleDateFormat("dd/MM/yyyy"); //formato por defecto

		String valorConFormato = "";

		if (this.valor != null)
			valorConFormato= df.format(this.valor);

		return "ArgumentoDate [valor=" + valorConFormato + ", formato=" + formato + ", toString()=" + super.toString() + "]";
	}

}







