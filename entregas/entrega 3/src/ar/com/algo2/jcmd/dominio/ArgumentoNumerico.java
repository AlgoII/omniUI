package ar.com.algo2.jcmd.dominio;

public class ArgumentoNumerico extends Argumento {
	
	private String mask;
	private Long valorNumerico;
	
	public Long getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(Long valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public ArgumentoNumerico(String mask) {
		super();
		this.mask = mask;
		this.valorNumerico=null;
	}
			
	public ArgumentoNumerico() {}

	public ArgumentoNumerico(String nombre, String etiqueta, Boolean optional, String tipo, String valor, String mask) {
		super(nombre, etiqueta, optional, tipo, valor);
		this.mask=mask;
		this.valorNumerico=null;
	}

	@Override
	public String toString() {
		return "ArgumentoNumerico [mask=" + mask + ", valorNumerico="
				+ valorNumerico + ", toString()=" + super.toString() + "]";
	}

				
}
