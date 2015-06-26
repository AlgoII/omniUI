package ar.com.algo2.jcmd.dominio;

public class ArgumentoBoolean extends Argumento {
	
	private Boolean valorInicial;
	private Boolean valorBooleano;
	
	public Boolean getValorBooleano() {
		return valorBooleano;
	}

	public void setValorBooleano(Boolean valorBooleano) {
		this.valorBooleano = valorBooleano;
	}

	public Boolean getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Boolean valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public ArgumentoBoolean() {}

	public ArgumentoBoolean(Boolean valorInicial) {
		
		super();
		
		this.valorInicial=valorInicial;
		this.valorBooleano=this.valorInicial;
		super.setValor(""+this.valorBooleano);
		
	}
	
	public ArgumentoBoolean(String nombre, String etiqueta, Boolean optional, String tipo, String valor, Boolean valorInicial) {
		super(nombre, etiqueta, optional, tipo, valor);
		
		this.valorInicial=valorInicial;
		this.valorBooleano=this.valorInicial;
		super.setValor(""+this.valorBooleano);
	}

	@Override
	public String toString() {
		return "ArgumentoBoolean [valorInicial=" + valorInicial
				+ ", valorBooleano=" + valorBooleano + ", toString()="
				+ super.toString() + "]";
	}

}
