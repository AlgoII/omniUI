package ar.com.algo2.jcmd.dominio;

public class Regla {
	
	private String validacionSobreCampo;

	public String getValidacionSobreCampo() {
		return validacionSobreCampo;
	}

	public void setValidacionSobreCampo(String validacionSobreCampo) {
		this.validacionSobreCampo = validacionSobreCampo;
	}

	@Override
	public String toString() {
		return "Regla [validacionSobreCampo=" + validacionSobreCampo + "]";
	}

	public Regla(String validacionSobreCampo) {
		super();
		this.validacionSobreCampo = validacionSobreCampo;
	}

	public Regla() {}

}
