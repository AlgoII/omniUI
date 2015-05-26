package ar.com.algo2.jcmd.dominio;

public class Constante {

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Constante [valor=" + valor + "]";
	}

	public Constante(String valor) {
		super();
		this.valor = valor;
	}
	
}
