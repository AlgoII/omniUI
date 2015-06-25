package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class ArgumentoComboBox extends Argumento {

	private List<String> valores = new ArrayList<String>();
	private String valorSeleccionado;	

	public ArgumentoComboBox(String nombre, String etiqueta, Boolean optional, String tipo, String valor,List<String> valores) {
		super(nombre, etiqueta, optional, tipo, valor);
		this.valores=valores;
	}

	public ArgumentoComboBox(List<String> valores) {
		super();
		this.valores = valores;
		this.valorSeleccionado = "";
		super.setValor(this.valorSeleccionado);
	}

	public List<String> getValores() {
		return valores;
	}

	public void setValores(List<String> valores) {
		this.valores = valores;
	}

	public void addValor(String valor) {
		this.valores.add(valor);
	}
	
	public String getValorSeleccionado() {
		return valorSeleccionado;
	}

	public void setValorSeleccionado(String valorSeleccionado) {
		this.valorSeleccionado = valorSeleccionado;
	}
	
	public ArgumentoComboBox() {super();}

	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		for (String valor: this.valores)
			buff.append(valor).append(",");
			
		return "ArgumentoCombo [valores=" + buff.toString() + ", valorSeleccionado=" + valorSeleccionado +", toString()=" + super.toString() + "]";
	};
	
}

