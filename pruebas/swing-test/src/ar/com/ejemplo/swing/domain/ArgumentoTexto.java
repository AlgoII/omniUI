package ar.com.ejemplo.swing.domain;

public class ArgumentoTexto extends Argumento {

	private String valor; //en el caso de Search, sería el path del archivo

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ArgumentoTexto() {
		super();
	}

	public ArgumentoTexto(String etiqueta, Boolean optional, String tipo, String valor) {
		super(etiqueta, optional, tipo);
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ArgumentoTexto [valor=" + valor + ", toString()=" + super.toString() + "]";
	}
	

}
