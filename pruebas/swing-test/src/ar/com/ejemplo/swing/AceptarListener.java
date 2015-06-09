package ar.com.ejemplo.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ar.com.ejemplo.swing.domain.Argumento;

public class AceptarListener implements ActionListener {

	private List<Argumento> argumentos;

	public AceptarListener() {}
	
	public AceptarListener(List<Argumento> argumentos) {
		this.argumentos = argumentos;
	}
	
	public void actionPerformed(ActionEvent e) {
		for (Argumento a: this.argumentos)
			System.out.println(a.toString());
	}

}
