package ar.com.algo2.jcmd.dominio;

public class ArgumentoNumerico extends Argumento {
	
	private String mask;

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public ArgumentoNumerico(String mask) {
		super();
		this.mask = mask;
	}
			
	public ArgumentoNumerico() {}

	@Override
	public String toString() {
		return "ArgumentoNumerico [mask=" + mask + ", toString()="
				+ super.toString() + "]";
	}
				
}
