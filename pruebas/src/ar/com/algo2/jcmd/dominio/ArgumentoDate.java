package ar.com.algo2.jcmd.dominio;

public class ArgumentoDate extends Argumento {

	private String formato;

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public ArgumentoDate(String formato) {
		super();
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "ArgumentoDate [formato=" + formato + ", toString()="
				+ super.toString() + "]";
	}
		
}
