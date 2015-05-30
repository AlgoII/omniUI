package ar.com.algo2.jcmd.dominio;

public class Etiqueta {

	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Etiqueta(String valor) {
		super();
		this.valor = valor;
	}

	public Etiqueta() {}
	
	@Override
	public String toString() {
		return "Etiqueta [valor=" + valor + "]";
	}
	
	
}
