package ar.com.ejemplo.swing.domain;

public class ArgumentoTexto extends Argumento {

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ArgumentoTexto() {
		super();
	}

	public ArgumentoTexto(String etiqueta, Boolean optional, String valor) {
		super(etiqueta, optional);
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ArgumentoTexto [valor=" + valor + ", toString()=" + super.toString() + "]";
	}
	

}
