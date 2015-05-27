package ar.com.algo2.jcmd.dominio;

public class ArgumentoBoolean extends Argumento {
	
	private Boolean valorInicial;

	public Boolean getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Boolean valorInicial) {
		this.valorInicial = valorInicial;
	}

	public ArgumentoBoolean(Boolean valorInicial) {
		super();
		this.valorInicial = valorInicial;
	}

	public ArgumentoBoolean() {}

	@Override
	public String toString() {
		return "ArgumentoBoolean [valorInicial=" + valorInicial
				+ ", toString()=" + super.toString() + "]";
	}
	

}
