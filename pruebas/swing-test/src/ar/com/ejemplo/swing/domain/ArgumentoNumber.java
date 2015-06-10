package ar.com.ejemplo.swing.domain;

public class ArgumentoNumber extends Argumento {

	private Long valor;
	private String mask;
	
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public ArgumentoNumber() {
		super();
	}
	public ArgumentoNumber(String etiqueta, Boolean optional, String tipo, String mask) {
		super(etiqueta, optional, tipo);
		this.valor = new Long(0) ;
		this.mask = mask;
	}
	@Override
	public String toString() {
		return "ArgumentoNumber [valor=" + valor + ", mask=" + mask	+ ", toString()=" + super.toString() + "]";
	}
	
	
}
