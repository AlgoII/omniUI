package ar.com.algo2.jcmd.dominio;

import java.util.ArrayList;
import java.util.List;

public class ArgumentoComboBox extends Argumento {

	private List<String> valores = new ArrayList<String>();

	public ArgumentoComboBox(List<String> valores) {
		super();
		this.valores = valores;
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
	
	public ArgumentoComboBox() {super();}

	@Override
	public String toString() {
		
		StringBuffer buff = new StringBuffer();
		for (String valor: this.valores)
			buff.append(valor).append(",");
			
		return "ArgumentoCombo [valores=" + buff.toString() + ", toString()=" + super.toString() + "]";
	};
	
	
	
}

