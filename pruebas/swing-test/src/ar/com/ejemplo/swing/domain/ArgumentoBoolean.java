package ar.com.ejemplo.swing.domain;

public class ArgumentoBoolean extends Argumento {

	private Boolean valor;

	public Boolean getValor() {
		return valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

	public ArgumentoBoolean() {
		super();
	}

	public ArgumentoBoolean(String etiqueta, Boolean optional, Boolean valor) {
		super(etiqueta, optional);	
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ArgumentoBoolean [valor=" + valor + ", toString()="+ super.toString() + "]";
	}

}
