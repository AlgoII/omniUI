package ar.com.algo2.jcmd.dominio;

public class Parametro implements ParametroValidacion {
	
	private String valor;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Parametro(String valor) {
		super();
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Parametro [valor=" + valor + "]";
	}
	
}
