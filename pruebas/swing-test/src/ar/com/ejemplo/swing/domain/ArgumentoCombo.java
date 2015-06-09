package ar.com.ejemplo.swing.domain;

import java.util.List;

public class ArgumentoCombo extends Argumento {

	private List<String> valores;
	private String valor; //TODO: valor seleccionado

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<String> getValores() {
		return valores;
	}

	public void setValores(List<String> valores) {
		this.valores = valores;
	}

	public ArgumentoCombo() {
		super();
	}

	public ArgumentoCombo(String etiqueta, Boolean optional, String tipo, List<String> valores) {
		super(etiqueta, optional, tipo);
		this.valores = valores;
	}
	
	public void addValor(String valor) {
		valores.add(valor);
	}

	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		for (String valor: this.valores)
			buff.append(valor).append(",");
		
		return "ArgumentoCombo [valores=" + buff.toString() + ", valor=" + valor + ", toString()=" + super.toString() + "]";
	}	
	
}
