package ar.com.algo2.jcmd.dominio;

public class Validacion {
	
	//TODO: posible incorporación de resultado
	private Accion accion;
	
	public Accion getAccion() {
		return accion;
	}
	public void setAccion(Accion accion) {
		this.accion = accion;
	}
		
	public Validacion() {}
	
	@Override
	public String toString() {
		return "Validacion [accion=" + this.accion.toString() + "]";
	}
	
}
